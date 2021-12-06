package net.leibi.adventofcode2021.day5;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class Day52021Test {

  @Test
  void fillBoardByLines() {
    Day52021 day52021 = new Day52021(Input.SHORT_INPUT);
    List<Line> lines = Day52021.getLinesFromInput(Input.SHORT_INPUT);
    day52021.fillBoardByLines(lines);
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
