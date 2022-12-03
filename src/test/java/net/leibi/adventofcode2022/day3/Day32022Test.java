package net.leibi.adventofcode2022.day3;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import net.leibi.adventofcode2022.day3.Day32022.Rucksack;
import org.junit.jupiter.api.Test;

class Day32022Test {


  @Test
  void testRucksackCtor(){

    Rucksack r = new Rucksack("abcd");
    assertThat(r.content()).isEqualTo("abcd");
    assertThat(r.firstCompartment()).isEqualTo("ab");
    assertThat(r.secondCompartment()).isEqualTo("cd");

  }



}