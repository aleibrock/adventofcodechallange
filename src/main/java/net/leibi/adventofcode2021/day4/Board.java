package net.leibi.adventofcode2021.day4;

import static net.leibi.helpers.InputHelper.getIntArrayFromString;

import java.util.Arrays;
import java.util.List;
import lombok.Getter;

@Getter
public class Board {

  private final int[][] boardContent;
  private final boolean[][] markedBoard = new boolean[5][5];
  private int lastNumberMarked = -1;

  public Board(final String initialContent) {
    boardContent = getBoardContent(initialContent);
    for (int i = 0; i < 5; i++) {
      for (int j = 0; j < 5; j++) {
        markedBoard[i][j] = false;
      }
    }
  }

  public int getScore() {
    return lastNumberMarked * getSumOfUnMarkedNumbersOnBoard();
  }

  private int getSumOfUnMarkedNumbersOnBoard() {
    int sum = 0;
    for (int i = 0; i < 5; i++) {
      for (int j = 0; j < 5; j++) {
        if (!markedBoard[i][j]) {
          sum += boardContent[i][j];
        }
      }
    }
    return sum;
  }

  void markNumberOnBoard(final int number) {
    lastNumberMarked = -1;
    for (int i = 0; i < 5; i++) {
      for (int j = 0; j < 5; j++) {
        if (boardContent[i][j] == number) {
          markedBoard[i][j] = true;
          lastNumberMarked = number;
        }
      }
    }
  }

  boolean isBoardWinning() {

    for (int i = 0; i < 5; i++) {
      boolean complete = isRowComplete(i);
      if (complete) {
        return true;
      }
      complete = isColumnComplete(i);
      if (complete) {
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

    int[][] intArray = new int[5][5];
    List<String> rows = Arrays.stream(initialContent.split("\\r?\\n")).toList();
    assert (rows.size() == 5);

    for (int i = 0; i < rows.size(); i++) {
      String row = rows.get(i);
      List<Integer> rowList = Arrays.stream(getIntArrayFromString(row)).boxed().toList();
      for (int j = 0; j < rowList.size(); j++) {
        intArray[i][j] = rowList.get(j);
      }
    }

    return intArray;
  }
}
