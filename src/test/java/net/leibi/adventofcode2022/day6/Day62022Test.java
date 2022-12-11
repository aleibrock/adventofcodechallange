package net.leibi.adventofcode2022.day6;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Day62022Test {

  @Test
  void getStartMarker() {

    assertThat(Day62022.getStartMarker(Input.input1,4)).isEqualTo(7);
    assertThat(Day62022.getStartMarker(Input.input2,4)).isEqualTo(5);
    assertThat(Day62022.getStartMarker(Input.input3,4)).isEqualTo(6);
    assertThat(Day62022.getStartMarker(Input.input4,4)).isEqualTo(10);
    assertThat(Day62022.getStartMarker(Input.input5,4)).isEqualTo(11);

  }

  @Test
  void getStartMarkerLarge(){
    assertThat(Day62022.getStartMarker(Input.large, 4)).isEqualTo(1658);
  }

  @Test
  void getStartMarkerLarge2(){
    assertThat(Day62022.getStartMarker(Input.large, 14)).isEqualTo(2260);
  }
}