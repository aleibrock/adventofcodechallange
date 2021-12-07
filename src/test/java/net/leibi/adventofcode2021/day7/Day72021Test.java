package net.leibi.adventofcode2021.day7;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


class Day72021Test {

  @Test
  void solveShort() {
    assertThat(Day72021.solve(Input.SHORT_INPUT, false)).isEqualTo(37);
  }

  @Test
  void solveWithIncreasingFuelShort() {
    assertThat(Day72021.solve(Input.SHORT_INPUT, true)).isEqualTo(168);
  }

  @Test
  void solveLong() {
    assertThat(Day72021.solve(Input.LONG_INPUT, false)).isEqualTo(337833);
  }

  @Test
  void solveLongWithIncreasingFuel() {
    assertThat(Day72021.solve(Input.LONG_INPUT, true)).isEqualTo(96678050);
  }
}
