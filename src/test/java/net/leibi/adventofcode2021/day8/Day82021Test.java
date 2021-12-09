package net.leibi.adventofcode2021.day8;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class Day82021Test {

  @Test
  void getOutputForDisplayOneLine() {

    Display display = new Display(Input.SHORT_INPUT_ONE_LINE);
    assertThat(display).isNotNull();
    assertThat(Day82021.getOutputForDisplay(display)).isEqualTo(5353);
  }

  @Test
  void getCurrentConfigurationOneLine() {

    Display display = new Display(Input.SHORT_INPUT_ONE_LINE);
    assertThat(display).isNotNull();
    assertThat(display.getCurrentConfiguration()).isEqualTo(new String[]{"d","e","a","f","g","b","c"});
  }

  @Test
  void solve2Short() {
    assertThat(Day82021.solve2(Input.SHORT_INPUT)).isEqualTo(61229);
  }

  @Test
  void solve2OneLine() {
    assertThat(Day82021.solve2(Input.SHORT_INPUT_ONE_LINE)).isEqualTo(5353);
  }

  @Test
  void parseOutputValues() {

    List<String> values = Day82021.parseOutputValues(Input.SHORT_INPUT);
    assertThat(values).hasSize(40);
  }

  @Test
  void solveShort() {
    assertThat(Day82021.getNumberOfUniqueDigits(Input.SHORT_INPUT)).isEqualTo(26);
  }

  @Test
  void solveLong() {
    assertThat(Day82021.getNumberOfUniqueDigits(Input.LONG_INPUT)).isEqualTo(409);
  }
}
