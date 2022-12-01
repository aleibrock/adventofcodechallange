package net.leibi.adventofcode2022.day1;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Day12022Test {

  @Test
  void getMostCaloriesSmall() {
    assertThat(Day12022.getMostCalories(Input.content.small())).isEqualTo(24000);
  }

  @Test
  void getMostCaloriesLage() {
    assertThat(Day12022.getMostCalories(Input.content.large())).isEqualTo(68442);
  }

  @Test
  void getElfesFromInput() {

    assertThat(Day12022.getElfesFromInput(Input.content.small())).hasSize(5)
        .anySatisfy(elf -> assertThat(elf.totalCalories()).isEqualTo(24000))
        .anySatisfy(elf -> assertThat(elf.totalCalories()).isEqualTo(6000))
        .anySatisfy(elf -> assertThat(elf.totalCalories()).isEqualTo(4000))
        .anySatisfy(elf -> assertThat(elf.totalCalories()).isEqualTo(10000))
        .anySatisfy(elf -> assertThat(elf.totalCalories()).isEqualTo(11000));


  }
}