package net.leibi.adventofcode2021.day3;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class Day32021Test {

  private final Day32021 day32021 = new Day32021();

  @Test
  void getLifeSupportRatingShort() {
    assertThat(day32021.getLifeSupportRating(Input.SHORT_INPUT)).isEqualTo(230);
    }

  @Test
  void getLifeSupportRating() {
    assertThat(day32021.getLifeSupportRating(Input.LONG_INPUT)).isEqualTo(4203981);
  }

  @Test
  void co2ScrubberRatingShort() {
    assertThat(day32021.co2ScrubberRating(Input.SHORT_INPUT)).isEqualTo(10);
    }

  @Test
  void getOxigenGeneratorRatingShort() {
    assertThat(day32021.getOxigenGeneratorRating(Input.SHORT_INPUT)).isEqualTo(23);
    }

  @Test
  void getGammaValue() {
    List<String> columns = day32021.getColumnsFromInput("""
    00100
    11110
    11111
    """);
    assertThat(day32021.getGammaValue(columns)).isEqualTo(30);
    }

  @Test
  void getEpsilonRate() {
    List<String> columns = day32021.getColumnsFromInput("""
    00100
    11110
    11111
    """);
    assertThat(day32021.getEpsilonRate(columns)).isEqualTo(1);
  }


  @Test
  void getMostCommonBinaryInString() {
    assertThat(day32021.getMostCommonBinaryInString("1110111")).isEqualTo(1);
    }

  @Test
  void getLeastCommonBinaryInString() {
    assertThat(day32021.getLeastCommonBinaryInString("1110111")).isZero();
    }

  @Test
  void getIntegerFromIntArray() {
    int[] intArray = new int[]{1,0,0,1};
    assertThat(day32021.getIntegerFromIntArray(intArray)).isEqualTo(9);
    }


  @Test
  void getColumnsFromInputOneLine() {
    List<String> columns = day32021.getColumnsFromInput("00100");

    assertThat(columns).hasSize(5);
    assertThat(columns.get(0)).isEqualTo("0");
    assertThat(columns.get(2)).isEqualTo("1");
    assertThat(columns.get(4)).isEqualTo("0");
  }

  @Test
  void getColumnsFromInputTwoLines() {
    List<String> columns = day32021.getColumnsFromInput("""
    00100
    11110
    """);

    assertThat(columns).hasSize(5);
    assertThat(columns.get(0)).isEqualTo("01");
    assertThat(columns.get(2)).isEqualTo("11");
    assertThat(columns.get(4)).isEqualTo("00");
  }

  @Test
  void getColumnsFromInput() {
    List<String> columns = day32021.getColumnsFromInput(Input.SHORT_INPUT);

    assertThat(columns).hasSize(5);
    assertThat(columns.get(0)).isEqualTo("011110011100");
    assertThat(columns.get(4)).isEqualTo("000111100100");



  }

  @Test
  void getPowerConsumptionShort() {
   assertThat(day32021.getPowerConsumption(Input.SHORT_INPUT)).isEqualTo(198);
  }

  @Test
  void getPowerConsumptionLong() {
    assertThat(day32021.getPowerConsumption(Input.LONG_INPUT)).isEqualTo(1540244);
  }
}
