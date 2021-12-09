package net.leibi.adventofcode2021.day9;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Day92021Test {

  @Test
  void parseInput() {

    int[][] matrix = Day92021.parseInput(Input.SHORT_INPUT);
    assertThat(matrix).hasDimensions(5,10);
    assertThat(matrix[0][0]).isEqualTo(2);
    assertThat(matrix[4][9]).isEqualTo(8);

  }
}
