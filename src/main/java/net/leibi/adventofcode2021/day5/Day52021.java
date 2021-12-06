package net.leibi.adventofcode2021.day5;

import static java.util.Objects.isNull;
import static net.leibi.helpers.InputHelper.getRowListFromInput;

import java.util.ArrayList;
import java.util.List;
import net.leibi.adventofcode2021.day5.Line.Point;

public class Day52021 {

  int[][] board;
  List<Line> lines;
  private final boolean fillDiag;

  public Day52021(final String input) {
    this(input, false);
  }

  public Day52021(final String input, boolean fillDiag) {
    this.lines = getLinesFromInput(input);
    this.board = buildBoard();
    this.fillDiag = fillDiag;
    fillBoardByLines(lines);
  }

  int getNumberOfBoardCellsWithScoreBiggerThan2() {
    int result = 0;

    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board.length; j++) {
        if (board[i][j] > 1) result++;
      }
    }
    return result;
  }

  int[][] buildBoard() {
    assert (!isNull(lines));
    int[] maxValues = getMaxValueFromLines(lines);
    return new int[maxValues[0] + 1][maxValues[1] + 1];
  }

  void fillBoardByLines(List<Line> lines) {
    for (Line line : lines) {
      fillBoardByPoints(line.from, line.to, fillDiag);
    }
  }

  private void fillBoardByPoints(Point from, Point to, boolean fillDiag) {
    if (from.x == to.x) {
      fillHorizontal(from, to);
    } else if (from.y == to.y) {
      fillVertical(from, to);
    } else if (fillDiag) {
      fillDiagonal(from, to);
    }
  }

  private void fillDiagonal(Point from, Point to) {

    if (from.x < to.x && from.y < to.y) { // leftup to rightdown
      fillLeftUpToRightDown(from, to);
    } else if (from.x > to.x && from.y > to.y) { // rightup to leftDown
      fillRightUpToLeftDown(from, to);
    } else if (from.x > to.x && from.y < to.y) { // rightdown to leftup
      fillRightDownToLeftUp(from, to);
    } else if (from.x < to.x && from.y > to.y) { // leftup to rightdown
      fillLeftDownToRightUp(from, to);
    }
  }

  private void fillLeftDownToRightUp(Point from, Point to) {
    int x = from.x;
    int y = from.y;
    while (x <= to.x && y >= to.y) {
      board[x++][y--]++;
    }
  }

  private void fillRightDownToLeftUp(Point from, Point to) {
    int x = from.x;
    int y = from.y;
    while (x >= to.x && y <= to.y) {
      board[x--][y++]++;
    }
  }

  private void fillRightUpToLeftDown(Point from, Point to) {
    int x = from.x;
    int y = from.y;
    while (x >= to.x && y >= to.y) {
      board[x--][y--]++;
    }
  }

  private void fillLeftUpToRightDown(Point from, Point to) {
    int x = from.x;
    int y = from.y;
    while (x <= to.x && y <= to.y) {
      board[x++][y++]++;
    }
  }

  private void fillVertical(Point from, Point to) {
    if (from.x < to.x) {
      for (int i = from.x; i <= to.x; i++) {
        board[i][from.y]++;
      }
    } else {
      for (int i = from.x; i >= to.x; i--) {
        board[i][from.y]++;
      }
    }
  }

  private void fillHorizontal(Point from, Point to) {
    if (from.y < to.y) {
      for (int i = from.y; i <= to.y; i++) {
        board[from.x][i]++;
      }
    } else {
      for (int i = from.y; i >= to.y; i--) {
        board[from.x][i]++;
      }
    }
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
      if (line.to.x > maxX) maxX = line.to.x;
      if (line.to.y > maxY) maxY = line.to.y;
    }
    int[] result = new int[2];
    result[0] = maxX;
    result[1] = maxY;
    return result;
  }
}
