package net.leibi.adventofcode2021.day5;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class Day52021Test {

  private static final String ONE_LINE = """
      0,0 -> 0,2
      """;
  private static final String SQUARE = """
      0,0 -> 0,2
      2,1 -> 2,2
      """;
  private static final String SQUARE_WITH_OVERLAP = """
      0,0 -> 0,2
      2,1 -> 2,2
      0,2 -> 2,2
      """;

  @Test
  void getNumberOfBoardCellsWithScoreBiggerThan2() {
    Day52021 day52021 = new Day52021(Input.SHORT_INPUT);
    assertThat(day52021.getNumberOfBoardCellsWithScoreBiggerThan2()).isEqualTo(5);
  }

  @Test
  void getNumberOfBoardCellsWithScoreBiggerThan2WithDiag() {
    Day52021 day52021 = new Day52021(Input.SHORT_INPUT, true);
    assertThat(day52021.getNumberOfBoardCellsWithScoreBiggerThan2()).isEqualTo(12);
  }

  @Test
  void getNumberOfBoardCellsWithScoreBiggerThan2WithDiagLong() {
    Day52021 day52021 = new Day52021(Input.LONG_INPUT, true);
    assertThat(day52021.getNumberOfBoardCellsWithScoreBiggerThan2()).isEqualTo(19374);
  }

  @Test
  void getNumberOfBoardCellsWithScoreBiggerThan2Long() {
    Day52021 day52021 = new Day52021(Input.LONG_INPUT);
    assertThat(day52021.getNumberOfBoardCellsWithScoreBiggerThan2()).isEqualTo(8350);
  }

  @Test
  void fillBoardByLinesOneLine() {
    Day52021 day52021 = new Day52021(ONE_LINE);
    assertThat(day52021.board).hasDimensions(3,1);
    assertThat(day52021.board[0][0]).isEqualTo(1);
    assertThat(day52021.board[1][0]).isEqualTo(1);
    assertThat(day52021.board[2][0]).isEqualTo(1);


  }

  @Test
  void fillBoardByLinesSquare() {
    Day52021 day52021 = new Day52021(SQUARE);
    assertThat(day52021.board).hasDimensions(3,3);
    assertThat(day52021.board[0][0]).isEqualTo(1);
    assertThat(day52021.board[1][0]).isEqualTo(1);
    assertThat(day52021.board[2][0]).isEqualTo(1);


    assertThat(day52021.board[1][2]).isEqualTo(1);
    assertThat(day52021.board[2][2]).isEqualTo(1);
  }

  @Test
  void fillBoardByLinesSquareWithOverLap() {
    Day52021 day52021 = new Day52021(SQUARE_WITH_OVERLAP);
    assertThat(day52021.board).hasDimensions(3,3);
    assertThat(day52021.board[0][0]).isEqualTo(1);
    assertThat(day52021.board[1][0]).isEqualTo(1);
    assertThat(day52021.board[2][0]).isEqualTo(2);

    assertThat(day52021.board[2][1]).isEqualTo(1);

    assertThat(day52021.board[1][2]).isEqualTo(1);
    assertThat(day52021.board[2][2]).isEqualTo(2);
  }


  @Test
  void fillBoardByLines() {
    Day52021 day52021 = new Day52021(Input.SHORT_INPUT);
    assertThat(day52021.board[0][7]).isEqualTo(1);
    assertThat(day52021.board[1][7]).isEqualTo(1);
    assertThat(day52021.board[9][3]).isEqualTo(1);

    assertThat(day52021.board[9][0]).isEqualTo(2);
  }

  @Test
  void getMaxValueFromLines() {

    int[] maxValues = Day52021.getMaxValueFromLines(Day52021.getLinesFromInput(Input.SHORT_INPUT));
    assertThat(maxValues).hasSize(2);
    assertThat(maxValues[0]).isEqualTo(9);
    assertThat(maxValues[1]).isEqualTo(9);
  }

  @Test
  void getLinesFromInputTestShort() {
    List<Line> lines = Day52021.getLinesFromInput(Input.SHORT_INPUT);
    assertThat(lines).hasSize(10);
    assertThat(lines.get(0)).isNotNull().isEqualTo(new Line(0,9,5,9));
  }

  @Test
  void cTorTest() {
    Day52021 day52021 = new Day52021(Input.SHORT_INPUT);
    assertThat(day52021.board).hasDimensions(10, 10);
  }
}
