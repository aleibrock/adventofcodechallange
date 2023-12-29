package net.leibi.adventofcode2023.day8;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class Day8Test {

    public static final Day8 day8 = new Day8();

    @Test
    void smallTest(){

        assertThat(day8.getNumberofSteps(Input.SMALL1)).isEqualTo(2);
        assertThat(day8.getNumberofSteps(Input.SMALL2)).isEqualTo(6);

    }

}