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


  public int getFlashesForSteps(int steps){
   for (int i = 0; i < steps; i++) {
      getNextStep();
    }
    return flashes;
  }

  public int getStepWhereAllFlashes() {

    int numberCells = matrix.length * matrix[matrix.length - 1].length;

    int stepCount = 0;
    while (true) {
      stepCount++;
      getNextStep();
      if (hasFlased.size() == numberCells) return stepCount;
    }
  }

  void getNextStep() {
    hasFlased.clear();
    for (int currentColumn = 0; currentColumn < matrix.length; currentColumn++) {
      for (int currentRow = 0; currentRow < matrix[currentColumn].length; currentRow++) {
        increaseEngergyAt(currentColumn, currentRow);
      }
    }

    for (int currentColumn = 0; currentColumn < matrix.length; currentColumn++) {
      for (int currentRow = 0; currentRow < matrix[currentColumn].length; currentRow++) {
        flashCell(currentColumn, currentRow);
      }
    }

    setFlashedToZero();
  }

  private void setFlashedToZero() {
    for (Point point : hasFlased) {
      matrix[point.column][point.row] = 0;
    }
  }

  private void flashCell(int currentColumn, int currentRow) {
    if (matrix[currentColumn][currentRow] > 9) {
      increaseCell(currentColumn, currentRow);
    }
  }

  private void increaseEngergyAt(int currentColumn, int currentRow) {
    matrix[currentColumn][currentRow]++;
  }

  private void increaseCell(int currentColumn, int currentRow) {
    if (currentColumn >= matrix.length || currentColumn < 0) return;
    if (currentRow >= matrix[currentColumn].length || currentRow < 0) return;
    Point currentPoint = new Point(currentColumn, currentRow);
    if (hasFlased.contains(currentPoint)) return;

    matrix[currentColumn][currentRow]++;
    if (matrix[currentColumn][currentRow] > 9) {
      flashes++;
      hasFlased.add(currentPoint);
      increaseCell(currentColumn - 1, currentRow);
      increaseCell(currentColumn + 1, currentRow);
      increaseCell(currentColumn - 1, currentRow - 1);
      increaseCell(currentColumn - 1, currentRow + 1);
      increaseCell(currentColumn, currentRow + 1);
      increaseCell(currentColumn, currentRow - 1);
      increaseCell(currentColumn + 1, currentRow - 1);
      increaseCell(currentColumn + 1, currentRow + 1);
    }
  }

  static class Point {
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
