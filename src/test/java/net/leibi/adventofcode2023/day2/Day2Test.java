package net.leibi.adventofcode2023.day2;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Day2Test {

    Day2 day2 = new Day2();

    @Test
    void testDay2Small() {
        assertThat(day2.getSumOfPossibleGames(Input.SMALL)).isEqualTo(8);
    }

    @Test
    void testDay2_2Small() {
        assertThat(day2.getPowerSum(Input.SMALL)).isEqualTo(2286);
    }

    @Test
    void testDay2_2Big() {
        assertThat(day2.getPowerSum(Input.BIG)).isEqualTo(2286);
    }

    @Test
    void testDay2Big() {
        assertThat(day2.getSumOfPossibleGames(Input.BIG)).isEqualTo(74229);
    }

}