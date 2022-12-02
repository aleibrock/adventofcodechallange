package net.leibi.adventofcode2021.day4;

import static net.leibi.helpers.InputHelper.getIntArrayFromString;

import java.util.Arrays;
import java.util.List;
import lombok.Getter;

@Getter
public class Board {

  public static final int BOARDSIZE = 5;
  private final int[][] boardContent;
  private final boolean[][] markedBoard = new boolean[BOARDSIZE][BOARDSIZE];
  private int lastNumberMarked = -1;
  private boolean hasWon = false;

  public Board(final String initialContent) {
    boardContent = getBoardContent(initialContent);
    for (int i = 0; i < BOARDSIZE; i++) {
      for (int j = 0; j < BOARDSIZE; j++) {
        markedBoard[i][j] = false;
      }
    }
  }

  public int getScore() {
    return lastNumberMarked * getSumOfUnMarkedNumbersOnBoard();
  }

  private int getSumOfUnMarkedNumbersOnBoard() {
    int sum = 0;
    for (int i = 0; i < BOARDSIZE; i++) {
      for (int j = 0; j < BOARDSIZE; j++) {
        if (!markedBoard[i][j]) {
          sum += boardContent[i][j];
        }
      }
    }
    return sum;
  }

  void markNumberOnBoard(final int number) {
    lastNumberMarked = -1;
    for (int i = 0; i < BOARDSIZE; i++) {
      for (int j = 0; j < BOARDSIZE; j++) {
        if (boardContent[i][j] == number) {
          markedBoard[i][j] = true;
          lastNumberMarked = number;
        }
      }
    }
  }

  boolean isBoardWinning() {

    for (int i = 0; i < BOARDSIZE; i++) {
      boolean complete = isRowComplete(i);
      if (complete) {
        hasWon = true;
        return true;

      }
      complete = isColumnComplete(i);
      if (complete) {
        hasWon = true;
        return true;
      }
    }
    return false;
  }

  private boolean isColumnComplete(int columnNumber) {
    return markedBoard[0][columnNumber]
        && markedBoard[1][columnNumber]
        && markedBoard[2][columnNumber]
        && markedBoard[3][columnNumber]
        && markedBoard[4][columnNumber];
  }

  private boolean isRowComplete(int rowNumber) {
    return markedBoard[rowNumber][0]
        && markedBoard[rowNumber][1]
        && markedBoard[rowNumber][2]
        && markedBoard[rowNumber][3]
        && markedBoard[rowNumber][4];
  }

  private int[][] getBoardContent(String initialContent) {

    int[][] intArray = new int[BOARDSIZE][BOARDSIZE];
    List<String> rows = Arrays.stream(initialContent.split("\\r?\\n")).toList();
    assert (rows.size() == BOARDSIZE);

    for (int i = 0; i < rows.size(); i++) {
      String row = rows.get(i);
      List<Integer> rowList = Arrays.stream(getIntArrayFromString(row, " ")).boxed().toList();
      for (int j = 0; j < rowList.size(); j++) {
        intArray[i][j] = rowList.get(j);
      }
    }

    return intArray;
  }
}
