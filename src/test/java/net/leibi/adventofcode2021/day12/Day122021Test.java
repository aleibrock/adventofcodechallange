package net.leibi.adventofcode2021.day12;

import static net.leibi.adventofcode2021.day12.Input.SHORT_INPUT;
import static net.leibi.adventofcode2021.day12.Input.SHORT_RESULT;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Day122021Test {

  @Test
  void getAllPaths() {
    assertThat(Day122021.getAllPaths(SHORT_INPUT)).hasSize(10);
  }
}