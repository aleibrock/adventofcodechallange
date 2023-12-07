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
    void testDay1_Part2Small() {
        assertThat(day1.getSumOfCalibrationValuesSpelledOut(Input.SMALL_PART2)).isEqualTo(281);
    }

    @Test
    void testDay1_Part2Big() {
        assertThat(day1.getSumOfCalibrationValuesSpelledOut(Input.BIG)).isEqualTo(52840);
    }

    @Test
    void testDay1Big() {
        assertThat(day1.getSumOfCalibrationValues(Input.BIG)).isEqualTo(53974);
    }

    @Test
    void testDay1Ding(){
        assertThat(day1.getCalibrationValueSpelledOut("4121knflgt")).isEqualTo(41);
    }
    @Test
    void testDay1Ding2(){
        assertThat(day1.getCalibrationValueSpelledOut("drvglmnine7three8one7twodxtr")).isEqualTo(92);
    }



}