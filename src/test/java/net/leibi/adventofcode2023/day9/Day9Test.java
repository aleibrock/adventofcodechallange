package net.leibi.adventofcode2023.day9;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Day9Test {

    Day9 day9 = new Day9();

    @Test
    void testSmall() {
        assertThat(day9.getSumOfExtrapolatedValues(Input.SMALL)).isEqualTo(114);
    }

    @Test
    void testBig() {
        assertThat(day9.getSumOfExtrapolatedValues(Input.BIG)).isEqualTo(1725987467L);
    }


    @Test
    void testGetExtrapolatedValuesFromHistory() {
        assertThat(day9.getExtrapolatedValuesFromHistory("0 3 6 9 12 15")).isEqualTo(18);
        assertThat(day9.getExtrapolatedValuesFromHistory("1 3 6 10 15 21")).isEqualTo(28);
        assertThat(day9.getExtrapolatedValuesFromHistory("10 13 16 21 30 45")).isEqualTo(68);
    }


}