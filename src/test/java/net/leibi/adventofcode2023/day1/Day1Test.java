package net.leibi.adventofcode2023.day1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class Day1Test {

    Day1 day1 = new Day1();

    @Test
    void testDay1Small() {
        assertThat(day1.getSumOfCalibrationValues(Input.SMALL)).isEqualTo(142);
    }

    @Test
    void testDay1Big() {
        assertThat(day1.getSumOfCalibrationValues(Input.BIG)).isEqualTo(53974);
    }

}