package net.leibi.adventofcode2022.day2;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Day22022Test {

  @Test
  void scoreSmall() {
    assertThat(Day22022.score(Input.small)).isEqualTo(15);
  }

  @Test
  void scorelarge() {
    assertThat(Day22022.score(Input.large)).isEqualTo(13268);
  }
}