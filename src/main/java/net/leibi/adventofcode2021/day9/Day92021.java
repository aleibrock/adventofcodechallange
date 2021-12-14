package net.leibi.adventofcode2021.day9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;
import net.leibi.helpers.InputHelper;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Day92021 {

  static int solveBonus(final String input) {

    int[][] matrix = InputHelper.getIntMatrixFromInput(input);
    List<LowPoint> lowpoints = getLowPoints(matrix);

    List<LowPoint> basin = new ArrayList<>();
    List<Integer> basinSizes = new ArrayList<>();
    for (LowPoint lowpoint : lowpoints) {
      basin.clear();
      basinSizes.add(getBasinForLowPoint(matrix, lowpoint, basin).size());
    }

    Collections.sort(basinSizes);

    return  basinSizes.get(basinSizes.size()-1) * basinSizes.get(basinSizes.size()-2) * basinSizes.get(basinSizes.size()-3);

  }

  static List<LowPoint> getBasinForLowPoint(
      int[][] matrix, LowPoint lowPoint, List<LowPoint> basin) {
    if (!basin.contains(lowPoint)) {
      basin.add(lowPoint);
    }
    List<LowPoint> nextPoints = new ArrayList<>();

    int height = matrix.length;
    int width = matrix[0].length;
    // right
    int currentRow = lowPoint.row + 1;
    int currentCol = lowPoint.column;
    while (currentRow < width) {
      if (reachedANine(matrix, currentCol, currentRow, nextPoints, lowPoint, basin)) break;
      currentRow++;
    }
    // left
    currentRow = lowPoint.row - 1;
    currentCol = lowPoint.column;
    while (currentRow >= 0) {
      if (reachedANine(matrix, currentCol, currentRow, nextPoints, lowPoint, basin)) break;
      currentRow--;
    }
    // up
    currentRow = lowPoint.row;
    currentCol = lowPoint.column - 1;
    while (currentCol >= 0) {
      if (reachedANine(matrix, currentCol, currentRow, nextPoints, lowPoint, basin)) break;
      currentCol--;
    }
    // down
    currentCol = lowPoint.column + 1;
    currentRow = lowPoint.row;
    while (currentCol < height) {
      if (reachedANine(matrix, currentCol, currentRow, nextPoints, lowPoint, basin)) break;
      currentCol++;
    }

    nextPoints.forEach(nextPoint -> getBasinForLowPoint(matrix, nextPoint, basin));
    return basin;
  }

  static List<LowPoint> getLowPoints(int[][] matrix) {
    List<LowPoint> result = new ArrayList<>();

    int height = matrix.length;
    int width = matrix[0].length;

    for (int columnCursor = 0; columnCursor < height; columnCursor++) {
      for (int rowCursor = 0; rowCursor < width; rowCursor++) {

        int up = getUp(matrix, columnCursor, rowCursor);
        int down = getDown(matrix, height, columnCursor, rowCursor);
        int left = getLeft(matrix, columnCursor, rowCursor);
        int right = getRight(matrix, width, columnCursor, rowCursor);

        if (matrix[columnCursor][rowCursor] < Math.min(Math.min(Math.min(up, down), left), right)) {
          result.add(
              LowPoint.builder()
                  .value(matrix[columnCursor][rowCursor])
                  .column(columnCursor)
                  .row(rowCursor)
                  .build());
        }
      }
    }
    return result;
  }

  static int solve(final String input) {

    List<LowPoint> lowpoints = getLowPoints(InputHelper.getIntMatrixFromInput(input));
    return lowpoints.size() + lowpoints.stream().mapToInt(i -> i.value).sum();
  }



  private static boolean reachedANine(
      int[][] matrix,
      int currentCol,
      int currentRow,
      List<LowPoint> nextPoints,
      LowPoint originalLowPoint,
      List<LowPoint> basin) {
    if (matrix[currentCol][currentRow] < 9) {
      LowPoint lp =
          LowPoint.builder()
              .row(currentRow)
              .column(currentCol)
              .value(matrix[currentCol][currentRow])
              .build();
      if (!nextPoints.contains(lp) && !basin.contains(lp) && lp != originalLowPoint) {
        nextPoints.add(lp);
      }
      if (!basin.contains(lp)) {
        basin.add(lp);
      }
    } else return true;
    return false;
  }

  @Builder
  static class LowPoint {
    int column;
    int row;
    int value;

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (!(o instanceof LowPoint lowPoint)) {
        return false;
      }
      return column == lowPoint.column && row == lowPoint.row && value == lowPoint.value;
    }

    @Override
    public int hashCode() {
      return Objects.hash(column, row, value);
    }
  }

  private static int getRight(int[][] matrix, int width, int columnCursor, int rowCursor) {
    return rowCursor < width - 1 ? matrix[columnCursor][rowCursor + 1] : 10;
  }

  private static int getLeft(int[][] matrix, int columnCursor, int rowCursor) {
    return rowCursor > 0 ? matrix[columnCursor][rowCursor - 1] : 10;
  }

  private static int getDown(int[][] matrix, int height, int columnCursor, int rowCursor) {
    return columnCursor < height - 1 ? matrix[columnCursor + 1][rowCursor] : 10;
  }

  private static int getUp(int[][] matrix, int columnCursor, int rowCursor) {
    return columnCursor > 0 ? matrix[columnCursor - 1][rowCursor] : 10;
  }
}
