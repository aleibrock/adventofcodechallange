package net.leibi.adventofcode2024.day2;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class Day2Test {

  private final Day2 day2 = new Day2();

  @Test
  void part1Small() {
    assertThat((day2.part1(Input.SMALL))).isEqualTo(2L);
  }

  @Test
  void part1Big() {
    assertThat((day2.part1(Input.BIG))).isEqualTo(624L);
  }

  @Test
  void part2Small() {
    assertThat((day2.part1(Input.SMALL))).isEqualTo(4L);
  }

  @Test
  void part2Big() {
    assertThat((day2.part1(Input.BIG))).isEqualTo(624L);
  }

  @Test
  void isSafe() {

    assertThat(day2.isSafe(List.of(7, 6, 4, 2, 1), false)).isTrue();
    assertThat(day2.isSafe(List.of(1, 2, 7, 8, 9), false)).isFalse();
    assertThat(day2.isSafe(List.of(9, 7, 6, 2, 1), false)).isFalse();
    assertThat(day2.isSafe(List.of(1, 3, 2, 4, 5), false)).isFalse();
    assertThat(day2.isSafe(List.of(8, 6, 4, 4, 1), false)).isFalse();
    assertThat(day2.isSafe(List.of(1, 3, 6, 7, 9), false)).isTrue();
  }

  @Test
  void isSafeWithDampener() {

    assertThat(day2.isSafe(List.of(7, 6, 4, 2, 1), true)).isTrue();
    assertThat(day2.isSafe(List.of(1, 2, 7, 8, 9), true)).isFalse();
    assertThat(day2.isSafe(List.of(9, 7, 6, 2, 1), true)).isFalse();
    assertThat(day2.isSafe(List.of(1, 3, 2, 4, 5), true)).isTrue();
    assertThat(day2.isSafe(List.of(8, 6, 4, 4, 1), true)).isTrue();
    assertThat(day2.isSafe(List.of(1, 3, 6, 7, 9), true)).isTrue();
  }
}
