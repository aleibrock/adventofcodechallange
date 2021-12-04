package net.leibi.adventofcode2021.day1;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Day12021Test {

  @Test
  void getNumberOfEncreasesShort() {
    assertThat(Day12021.getNumberOfEncreases(Input.SHORT_INPUT)).isEqualTo(7);
  }

  @Test
  void getNumberOfEncreases() {
    assertThat(Day12021.getNumberOfEncreases(Input.LONG_INPUT)).isEqualTo(1559);
  }
}
