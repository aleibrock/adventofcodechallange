package net.leibi.adventofcode2022.day3;

import static org.assertj.core.api.Assertions.assertThat;

import net.leibi.adventofcode2022.day3.Day32022.Rucksack;
import org.junit.jupiter.api.Test;

class Day32022Test {


  @Test
  void scoreSmall() {
    assertThat(Day32022.score(Input.small)).isEqualTo(157);
  }

  @Test
  void scoreLarge() {
    assertThat(Day32022.score(Input.large)).isEqualTo(7446);
  }

  @Test
  void getValueFromItem() {
    assertThat(Day32022.getValueFromItem("a")).isEqualTo(1);
    assertThat(Day32022.getValueFromItem("z")).isEqualTo(26);
    assertThat(Day32022.getValueFromItem("A")).isEqualTo(27);
    assertThat(Day32022.getValueFromItem("Z")).isEqualTo(52);
  }

  @Test
  void testRucksackCtor() {

    Rucksack r = new Rucksack("abcd");
    assertThat(r.content()).isEqualTo("abcd");
    assertThat(r.firstCompartment()).isEqualTo("ab");
    assertThat(r.secondCompartment()).isEqualTo("cd");

  }

  @Test
  void getRucksackListFromInputTest() {

    assertThat(Day32022.getRucksackListFromInput("abcd")).hasSize(1)
        .containsExactly(new Rucksack("abcd"));

    assertThat(Day32022.getRucksackListFromInput("""
        abcd
        defg
        """)).hasSize(2).containsExactly(new Rucksack("abcd"), new Rucksack("defg"));
  }

  @Test
  void getCommonItemsTest() {
    var r = new Rucksack("abcd");
    assertThat(r.getCommonItems()).isEmpty();

    r = new Rucksack("abac");
    assertThat(r.getCommonItems()).hasSize(1).containsExactly("a");

    r = new Rucksack("abcafg");
    assertThat(r.getCommonItems()).hasSize(1).containsExactly("a");

    r = new Rucksack("abcafc");
    assertThat(r.getCommonItems()).hasSize(2).containsExactly("a", "c");

    r = new Rucksack("aaaa");
    assertThat(r.getCommonItems()).hasSize(1).containsExactly("a");

  }


}