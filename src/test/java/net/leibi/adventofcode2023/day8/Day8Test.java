package net.leibi.adventofcode2023.day8;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Day8Test {

    public static final Day8 day8 = new Day8();

    @Test
    void smallTest() {
        assertThat(day8.getNumberofSteps(Input.SMALL1)).isEqualTo(2);
        assertThat(day8.getNumberofSteps(Input.SMALL2)).isEqualTo(6);
    }

    @Test
    void smallPart2() {
        assertThat(day8.getNumberofStepsPart2(Input.SMALLPART2)).isEqualTo(6);
    }

    @Test
    @Disabled("performance issues")
    void bigPart2() {
        assertThat(day8.getNumberofStepsPart2(Input.BIG)).isEqualTo(6);
    }

    @Test
    void bigtest() {
        assertThat(day8.getNumberofSteps(Input.BIG)).isEqualTo(13939L);
    }

}