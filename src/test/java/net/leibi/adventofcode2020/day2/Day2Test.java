package net.leibi.adventofcode2020.day2;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Day2Test {

  @Test
  void getValidPasswords() {
    Day2 day2 = new Day2();
    assertThat(day2.getValidPasswords1()).isEqualTo(424);

  }

  @Test
  void getValidPasswords2() {
    Day2 day2 = new Day2();
    assertThat(day2.getValidPasswords2()).isEqualTo(747);

  }
}
