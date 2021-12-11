package net.leibi.adventofcode2021.day1;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Day12021Test {

  @Test
  void getNumberOfEncreasesWithSlidingWindowShort() {
    assertThat(Day12021.getNumberOfIncreasesWithSlidingWindow(Input.SHORT_INPUT)).isEqualTo(5);
  }

  @Test
  void getNumberOfEncreasesWithSlidingWindow() {
    assertThat(Day12021.getNumberOfIncreasesWithSlidingWindow(Input.LONG_INPUT)).isEqualTo(1600);
  }

  @Test
  void getNumberOfEncreasesShort() {
    assertThat(Day12021.getNumberOfIncreases(Input.SHORT_INPUT)).isEqualTo(7);
  }

  @Test
  void getNumberOfEncreases() {
    assertThat(Day12021.getNumberOfIncreases(Input.LONG_INPUT)).isEqualTo(1559);
  }
}
