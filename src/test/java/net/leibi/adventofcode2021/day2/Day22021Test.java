package net.leibi.adventofcode2021.day2;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class Day22021Test {

  @Test
  void getResultShort() {
    assertThat(Day22021.getResult(Input.SHORT_INPUT)).isEqualTo(150);
  }

  @Test
  void getResult() {
    assertThat(Day22021.getResult(Input.LONG_INPUT)).isEqualTo(1746616);

  }

  @Test
  void parseInput() {
    List<Event> events = Day22021.parseInput(Input.SHORT_INPUT);
    assertThat(events)
        .hasSize(6)
        .contains(Event.builder().direction("forward").amount(5).build())
        .contains(Event.builder().direction("forward").amount(2).build());
  }
}
