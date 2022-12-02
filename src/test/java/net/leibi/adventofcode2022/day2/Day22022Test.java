package net.leibi.adventofcode2022.day2;

import static org.assertj.core.api.Assertions.assertThat;

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

  @Test
  void scorePart2Small() {
    assertThat(Day22022.scorePart2(Input.small)).isEqualTo(12);
  }

  @Test
  void scorePart2Large() {
    assertThat(Day22022.scorePart2(Input.large)).isEqualTo(15508);
  }

}