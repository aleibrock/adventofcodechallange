package net.leibi.adventofcode2021.day6;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class Day62021Test {

  @Test
  void getFishesFromInputTest() {
    List<Integer> fishes = Day62021.getFishesFromInput(Input.SHORT_INPUT);
    assertThat(fishes).hasSize(5);
    assertThat(fishes.get(0)).isEqualTo(3);
    assertThat(fishes.get(4)).isEqualTo(2);
  }

  @Test
  void testCtor() {
    Day62021 day62021 = new Day62021(Input.SHORT_INPUT);
    assertThat(day62021.fishes).isNotEmpty().hasSize(5);
  }

  @Test
  void testfirstDay() {
    Day62021 day62021 = new Day62021(Input.SHORT_INPUT);
    day62021.simulateDays(1);
    assertThat(day62021.fishes).isNotEmpty().hasSize(5);
    assertThat(day62021.fishes.get(0)).isEqualTo(2);
    assertThat(day62021.fishes.get(1)).isEqualTo(3);
    assertThat(day62021.fishes.get(2)).isEqualTo(2);
    assertThat(day62021.fishes.get(3)).isEqualTo(0);
    assertThat(day62021.fishes.get(4)).isEqualTo(1);
  }
  @Test
  void testTwoDays() {
    Day62021 day62021 = new Day62021(Input.SHORT_INPUT);
    day62021.simulateDays(2);
    assertThat(day62021.fishes).isNotEmpty().hasSize(6);
    assertThat(day62021.fishes.get(0)).isEqualTo(1);
    assertThat(day62021.fishes.get(1)).isEqualTo(2);
    assertThat(day62021.fishes.get(2)).isEqualTo(1);
    assertThat(day62021.fishes.get(3)).isEqualTo(6);
    assertThat(day62021.fishes.get(4)).isEqualTo(0);
    assertThat(day62021.fishes.get(5)).isEqualTo(8);
  }

  @Test
  void test18Days() {
    Day62021 day62021 = new Day62021(Input.SHORT_INPUT);
    day62021.simulateDays(18);
    assertThat(day62021.fishes).isNotEmpty().hasSize(26);
    assertThat(day62021.fishes.get(0)).isEqualTo(6);
    assertThat(day62021.fishes.get(25)).isEqualTo(8);
  }

  @Test
  void test80Days() {
    Day62021 day62021 = new Day62021(Input.SHORT_INPUT);
    day62021.simulateDays(80);
    assertThat(day62021.fishes).isNotEmpty().hasSize(5934);
 }

  @Test
  void test80DaysLong() {
    Day62021 day62021 = new Day62021(Input.LONG_INPUT);
    day62021.simulateDays(80);
    assertThat(day62021.fishes).isNotEmpty().hasSize(390011);
  }

  @Test
  void test256DaysLong() {
    Day62021 day62021 = new Day62021(Input.LONG_INPUT);
    day62021.simulateDays(256);
    assertThat(day62021.fishes).isNotEmpty().hasSize(390011);
  }
}
