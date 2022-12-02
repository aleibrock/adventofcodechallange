package net.leibi.adventofcode2021.day12;

import static net.leibi.adventofcode2021.day12.Input.SHORT_INPUT;
import static net.leibi.adventofcode2021.day12.Input.SHORT_RESULT;
import static org.assertj.core.api.Assertions.assertThat;

import net.bytebuddy.implementation.bind.annotation.IgnoreForBinding;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class Day122021Test {


  @Test
  @Disabled
  void getAllPaths() {
    assertThat(Day122021.getAllPaths(SHORT_INPUT)).hasSize(10);
  }
}