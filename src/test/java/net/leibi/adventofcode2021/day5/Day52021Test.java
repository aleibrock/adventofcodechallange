package net.leibi.adventofcode2021.day5;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class Day52021Test {

  Day52021 day52021 = new Day52021();

  @Test
  void getLinesFromInputTestShort() {
    List<Line> lines = day52021.getLinesFromInput(Input.SHORT_INPUT);
    assertThat(lines).hasSize(10);
    assertThat(lines.get(0)).isNotNull().isEqualTo(new Line(0,9,5,9));
  }
}
