package net.leibi.adventofcode2021.day8;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class Day82021Test {

  @Test
  void parseInput() {

    List<String> values = Day82021.parseInput(Input.SHORT_INPUT);
    assertThat(values).hasSize(40);
  }

  @Test
  void solveShort() {
    assertThat(Day82021.solve(Input.SHORT_INPUT)).isEqualTo(26);
  }

  @Test
  void solveLong() {
    assertThat(Day82021.solve(Input.LONG_INPUT)).isEqualTo(26);
  }
}
