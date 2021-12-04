package net.leibi.adventofcode2020.day1;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Day1Test {

  @Test
  void getProductOfNumbersAddingUpTo2020FromInput() {
    assertThat(Day1.getProductOfNumbersAddingUpTo2020FromInput()).isEqualTo(55776);
  }

  @Test
  void getProductOfThreeNumbersAddingUpTo2020FromInput() {
    assertThat(Day1.getProductOfThreeNumbersAddingUpTo2020FromInput()).isEqualTo(223162626);
  }
}
