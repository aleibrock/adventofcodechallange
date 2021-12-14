package net.leibi.adventofcode2021.day11;

import static org.assertj.core.api.Assertions.assertThat;

import net.leibi.helpers.InputHelper;
import org.junit.jupiter.api.Test;

class Day112021Test {

  @Test
  void getNextStep() {

    Day112021 day112021 = new Day112021(Input.TINY_INPUT);
    assertThat(day112021.getFlashes()).isZero();
    day112021.getNextStep();
    assertThat(day112021.getFlashes()).isEqualTo(9);
    day112021.getNextStep();
    assertThat(day112021.getFlashes()).isEqualTo(9);
  }
}
