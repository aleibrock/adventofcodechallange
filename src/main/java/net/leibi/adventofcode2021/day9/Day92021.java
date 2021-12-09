package net.leibi.adventofcode2021.day9;

import java.util.ArrayList;
import java.util.List;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import net.leibi.helpers.InputHelper;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Day92021 {

  static int solve(final String input) {

    List<Integer> lowpoints = getLowPoints(parseInput(input));
    return lowpoints.size() + lowpoints.stream().mapToInt(i -> i).sum();
  }

  static int[][] parseInput(final String input) {

    List<String> rowList = InputHelper.getRowListFromInput(input);
    int[][] result = new int[rowList.size()][rowList.get(0).length()];

    int currentRow = 0;
    for (String s : rowList) {
      int[] row = InputHelper.getIntArrayFromString(s);
      result[currentRow++] = row;
    }
    return result;
  }

  static List<Integer> getLowPoints(int[][] matrix) {

    List<Integer> result = new ArrayList<>();

    int height = matrix.length;
    int width = matrix[0].length;

    for (int columnCursor = 0; columnCursor < height; columnCursor++) {
      for (int rowCursor = 0; rowCursor < width; rowCursor++) {

        int up = columnCursor > 0 ? matrix[columnCursor - 1][rowCursor] : 10;
        int down = columnCursor < height - 1 ? matrix[columnCursor + 1][rowCursor] : 10;
        int left = rowCursor > 0 ? matrix[columnCursor][rowCursor - 1] : 10;
        int right = rowCursor < width - 1 ? matrix[columnCursor][rowCursor + 1] : 10;

        if (matrix[columnCursor][rowCursor] < Math.min(Math.min(Math.min(up, down), left), right)) {
          result.add(matrix[columnCursor][rowCursor]);
        }
      }
    }
    return result;
  }
}
