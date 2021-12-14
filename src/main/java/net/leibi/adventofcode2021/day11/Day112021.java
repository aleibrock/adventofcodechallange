package net.leibi.adventofcode2021.day11;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import lombok.Getter;
import net.leibi.helpers.InputHelper;

public class Day112021 {

  List<Point> hasFlased = new ArrayList<>();
  @Getter private Integer flashes = 0;

  int [][] matrix;

  public Day112021(String input) {
    matrix = InputHelper.getIntMatrixFromInput(input);
  }

  void getNextStep() {
    hasFlased.clear();
    for (int currentColumn = 0; currentColumn < matrix.length; currentColumn++) {
      for (int currentRow = 0; currentRow < matrix[currentColumn].length; currentRow++) {
        matrix[currentColumn][currentRow]++;
        if (matrix[currentColumn][currentRow] > 9) {
          increaseCell(currentColumn, currentRow);
        }
      }
    }
  }

  private void increaseCell(int currentColumn, int currentRow) {
    if (currentColumn > matrix.length || currentColumn < 0) return;
    if (currentRow > matrix[currentColumn].length || currentRow < 0) return;
    Point currentPoint = new Point(currentColumn, currentRow);
    if (hasFlased.contains(currentPoint)) return;

    matrix[currentColumn][currentRow]++;
    if (matrix[currentColumn][currentRow] > 9) {
      flashes++;
      hasFlased.add(currentPoint);
      matrix[currentColumn][currentRow] = 0;
      increaseCell(currentColumn - 1, currentRow);
      increaseCell(currentColumn + 1, currentRow);
      increaseCell(currentColumn - 1, currentRow - 1);
      increaseCell(currentColumn - 1, currentRow + 1);
      increaseCell(currentColumn, currentRow + 1);
      increaseCell(currentColumn, currentRow - 1);
      increaseCell(currentColumn + 1, currentRow - 1);
      increaseCell(currentColumn - 1, currentRow + 1);
    }
  }

  class Point {
    int column;
    int row;

    public Point(int column, int row) {
      this.column = column;
      this.row = row;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (!(o instanceof Point)) {
        return false;
      }
      Point point = (Point) o;
      return column == point.column && row == point.row;
    }

    @Override
    public int hashCode() {
      return Objects.hash(column, row);
    }
  }
}
