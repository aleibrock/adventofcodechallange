package net.leibi.adventofcode2022.day5;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Day52022Test {

  @Test
  void getStacksFromSubInput() {

    String s = """
                [A] \s
            [D] [Y] \s
        [N] [C] [X] \s
        [Z] [M] [P] \s
         0   1   2
        """;
    assertThat(Day52022.getStacksFromSubInput(s)).hasSize(3);
    assertThat(Day52022.getStacksFromSubInput(s).get(0).getTopCrate()).hasValue('N');
    assertThat(Day52022.getStacksFromSubInput(s).get(1).getTopCrate()).hasValue('D');
    assertThat(Day52022.getStacksFromSubInput(s).get(2).getTopCrate()).hasValue('A');
  }
}