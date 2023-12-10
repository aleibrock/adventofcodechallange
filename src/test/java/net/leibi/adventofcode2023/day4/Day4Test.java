package net.leibi.adventofcode2023.day4;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Day4Test {

    private final Day4 day4 = new Day4();

    @Test
    void testPointsOfPileSmall() {
        assertThat(day4.sumPointsOfPile(Input.SMALL)).isEqualTo(13);
    }

    @Test
    void testPointsOfPileBig() {

        assertThat(day4.sumPointsOfPile(Input.BIG)).isEqualTo(15268);

    }

}