package net.leibi.adventofcode2024.day2;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class Day2Test {


    private final Day2 day2 = new Day2();

    @Test
    void part1Small(){
        assertThat((day2.part1(Input.SMALL))).isEqualTo(2L);
    }


    @Test
    void isSafe(){

        assertThat(day2.isSafe(List.of(7,6,4,2,1))).isTrue();
        assertThat(day2.isSafe(List.of(1,2,7,8,9))).isFalse();
        assertThat(day2.isSafe(List.of(9,7,6,2,1))).isFalse();
        assertThat(day2.isSafe(List.of(1,3,2,4,5))).isFalse();
        assertThat(day2.isSafe(List.of(8,6,4,4,1))).isFalse();
        assertThat(day2.isSafe(List.of(1,3,6,7,9))).isTrue();


    }

}