package net.leibi.adventofcode2021.day9;

import java.util.List;
import net.leibi.helpers.InputHelper;

public class Day92021 {

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
}
