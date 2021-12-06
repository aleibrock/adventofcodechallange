package net.leibi.adventofcode2021.day5;

import static java.util.Objects.isNull;
import static net.leibi.helpers.InputHelper.getRowListFromInput;

import java.util.ArrayList;
import java.util.List;

public class Day52021 {

  int[][] board;
  List<Line> lines;

  public Day52021(final String input) {
    this.lines = getLinesFromInput(input);
    this.board = buildBoard();
  }

  int[][] buildBoard() {
    assert (!isNull(lines));
    int[] maxValues = getMaxValueFromLines(lines);
    int[][] tmpBoard = new int[maxValues[0]][maxValues[1]];
    for (int i = 0; i < maxValues[0]; i++) {
      for (int j = 0; j < maxValues[1]; j++) {
        tmpBoard[i][j] = 0;
      }
    }
    return tmpBoard;
  }

  static List<Line> getLinesFromInput(final String input) {
    List<Line> lines = new ArrayList<>();
    List<String> rowList = getRowListFromInput(input);
    for (String row : rowList) {
      String[] points = row.split("->");
      String[] from = points[0].split(",");
      String[] to = points[1].split(",");
      Line line =
          new Line(
              Integer.parseInt(from[0].trim()),
              Integer.parseInt(from[1].trim()),
              Integer.parseInt(to[0].trim()),
              Integer.parseInt(to[1].trim()));
      lines.add(line);
    }
    return lines;
  }

  static int[] getMaxValueFromLines(List<Line> lines) {
    int maxX = -1;
    int maxY = -1;
    for (Line line : lines) {
      if (line.from.x > maxX) maxX = line.from.x;
      if (line.from.y > maxY) maxY = line.from.y;
    }
    int[] result = new int[2];
    result[0] = maxX;
    result[1] = maxY;
    return result;
  }
}
