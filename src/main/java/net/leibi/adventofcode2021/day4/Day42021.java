package net.leibi.adventofcode2021.day4;

import static java.util.Objects.isNull;
import static net.leibi.helpers.InputHelper.getRowListFromInput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lombok.Getter;

@Getter
public class Day42021 {

  private final List<Integer> inputNumbers;
  private final List<Board> boardList;

  public Day42021(final String input) {
    inputNumbers = getInputNumbers(input);
    boardList = getBoardList(input);
  }

  public int play() {
    for (Integer inputNumber : inputNumbers) {
      for (Board board : boardList) {
        board.markNumberOnBoard(inputNumber);
        if (board.isBoardWinning()) {
          return board.getScore();
        }
      }
    }
    return -1;
  }

  public int playToWinLast() {
    Board lastWinningBoard = null;
    for (Integer inputNumber : inputNumbers) {
      for (Board board : boardList) {
        if (board.isHasWon()) continue;
        board.markNumberOnBoard(inputNumber);
        if (board.isBoardWinning()) {
          lastWinningBoard = board;
        }
      }
    }

    if (isNull(lastWinningBoard)) return -1;
    return lastWinningBoard.getScore();
  }

  private List<Board> getBoardList(String input) {
    final List<Board> tmpBoardList = new ArrayList<>();
    for (String s : input.split("\n\n")) {
      if (s.contains("\n")) {
        tmpBoardList.add(new Board(s));
      }
    }
    return tmpBoardList;
  }

  private List<Integer> getInputNumbers(String input) {
    String firstRow = getRowListFromInput(input).get(0).trim();
    return Arrays.stream(firstRow.split(",")).map(Integer::valueOf).toList();
  }
}
