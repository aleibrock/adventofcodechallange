package net.leibi.adventofcode2021.day4;

import java.util.Arrays;
import net.leibi.helpers.InputHelper;

public class Board {

  int[][] boardContent;
  boolean[][] markedBoard = new boolean[5][5];
  int lastNumberMarked = -1;

  public Board(final String initialContent) {
    boardContent = getBoardContent(initialContent);
  }

  int[][] getBoardContent(String initialContent) {
    return (int[][])
        Arrays.stream(initialContent.split("\\r?\\n"))
            .map(InputHelper::getIntArrayFromString)
            .toArray();
  }

  void markNumberOnBoard(int number) {}

  boolean isBoardWinning() {
    return false;
  }
}
