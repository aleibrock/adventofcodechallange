package net.leibi.adventofcode2024.day3;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MulTest {

  @Test
  void prod() {
    assertThat(new Mul(2, 4).prod()).isEqualTo(8);
  }
}
