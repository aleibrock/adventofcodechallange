package net.leibi.adventofcode2022.day4;


import static org.assertj.core.api.Assertions.assertThat;

import net.leibi.adventofcode2022.day4.Day42022.ElfePair;
import org.junit.jupiter.api.Test;

class Day42022Test {

  @Test
  void getCompleteOverlapsSmall(){
    assertThat(Day42022.getCompleteOverlaps(Input.small)).isEqualTo(2);
  }

  @Test
  void getCompleteOverlapsLarge(){
    assertThat(Day42022.getCompleteOverlaps(Input.large)).isEqualTo(450);
  }

  @Test
  void hasOverLap(){

    assertThat(new ElfePair("2-4","6-8").hasCompleteOverlap()).isFalse();
    assertThat(new ElfePair("2-3","4-5").hasCompleteOverlap()).isFalse();
    assertThat(new ElfePair("5-7","7-9").hasCompleteOverlap()).isFalse();
    assertThat(new ElfePair("2-8","3-7").hasCompleteOverlap()).isTrue();
    assertThat(new ElfePair("6-6","4-6").hasCompleteOverlap()).isTrue();
    assertThat(new ElfePair("2-6","4-8").hasCompleteOverlap()).isFalse();

  }

  @Test
  void getListOfPairs() {
    assertThat(Day42022.getListOfPairs(Input.small)).hasSize(6)
        .contains(new ElfePair("2-4", "6-8"));
  }


  @Test
  void ElfePairCtor() {
    ElfePair actual = new ElfePair("2-4", "6-8");
    assertThat(actual).isNotNull();
    assertThat(actual.firstSection()).containsExactly(2, 3, 4);
    assertThat(actual.secondSection()).containsExactly(6, 7, 8);
  }

}