package net.leibi.adventofcode2021.day4;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Day42021Test {

  @Test
  void testCtor() {

    Day42021 day42021 = new Day42021(Input.SHORT_INPUT);
    assertThat(day42021.getInputNumbers())
        .containsExactly(
            7, 4, 9, 5, 11, 17, 23, 2, 0, 14, 21, 24, 10, 16, 13, 6, 15, 25, 12, 22, 18, 20, 8, 19,
            3, 26, 1);
    assertThat(day42021.getBoardList()).hasSize(3);
  }

  @Test
  void testPlayShort() {
    Day42021 day42021 = new Day42021(Input.SHORT_INPUT);
    assertThat(day42021.play()).isEqualTo(4512);
  }

  @Test
  void testPlayLong() {
    Day42021 day42021 = new Day42021(Input.LONG_INPUT);
    assertThat(day42021.play()).isEqualTo(67716);
  }
}
