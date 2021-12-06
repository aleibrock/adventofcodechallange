package net.leibi.adventofcode2021.day6;

import static net.leibi.adventofcode2021.day6.Day62021.getFishesFromInput;
import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.List;
import org.junit.jupiter.api.Test;

class Day62021Test {

  @Test
  void getFishesFromInputTest() {
    List<Integer> fishes = getFishesFromInput(Input.SHORT_INPUT);
    assertThat(fishes).hasSize(5);
    assertThat(fishes.get(0)).isEqualTo(3);
    assertThat(fishes.get(4)).isEqualTo(2);
  }

  @Test
  void test18Days() {
    assertThat(Day62021.getNumberOfFishes(getFishesFromInput(Input.SHORT_INPUT),18)).isEqualTo(BigDecimal.valueOf(26));
  }

  @Test
  void test80Days() {
    assertThat(Day62021.getNumberOfFishes(getFishesFromInput(Input.SHORT_INPUT),80)).isEqualTo(BigDecimal.valueOf(5934));
 }

  @Test
  void test80DaysLong() {
    assertThat(Day62021.getNumberOfFishes(getFishesFromInput(Input.LONG_INPUT),80)).isEqualTo(BigDecimal.valueOf(390011));
  }

  @Test
  void test256DaysLong() {
    assertThat(Day62021.getNumberOfFishes(getFishesFromInput(Input.LONG_INPUT),256)).isEqualTo(BigDecimal.valueOf(1746710169834L));
  }
}
