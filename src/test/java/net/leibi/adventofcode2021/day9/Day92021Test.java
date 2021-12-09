package net.leibi.adventofcode2021.day9;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class Day92021Test {

  @Test
  void solve() {
    assertThat(Day92021.solve(Input.SHORT_INPUT)).isEqualTo(15);
  }

  @Test
  void solveLong() {
    assertThat(Day92021.solve(Input.LONG_INPUT)).isEqualTo(496);
  }

  @Test
  void getLowPoints() {
    int[][] matrix = Day92021.parseInput(Input.SHORT_INPUT);
    List<Integer> lowPoints = Day92021.getLowPoints(matrix);

    assertThat(lowPoints).hasSize(4).containsExactly(1, 0, 5, 5);
  }

  @Test
  void parseInput() {

    int[][] matrix = Day92021.parseInput(Input.SHORT_INPUT);
    assertThat(matrix).hasDimensions(5,10);
    assertThat(matrix[0][0]).isEqualTo(2);
    assertThat(matrix[4][9]).isEqualTo(8);

  }
}
