package net.leibi.adventofcode2022.day6;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Day62022Test {

  @Test
  void getStartMarker() {

    assertThat(Day62022.getStartMarker(Input.input1)).isEqualTo(7);
    assertThat(Day62022.getStartMarker(Input.input2)).isEqualTo(5);
    assertThat(Day62022.getStartMarker(Input.input3)).isEqualTo(6);
    assertThat(Day62022.getStartMarker(Input.input4)).isEqualTo(10);
    assertThat(Day62022.getStartMarker(Input.input5)).isEqualTo(11);

  }

  @Test
  void getStartMarkerLarge(){
    assertThat(Day62022.getStartMarker(Input.large)).isEqualTo(1658);
  }
}