package net.leibi.adventofcode2024.day1;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class Day1Test {

    private final Day1 day1 = new Day1();

    @Test
    void getListOfListsFromInput() {

        final var listOfListsFromInput = day1.getListOfListsFromInput(Input.SMALL);
        assertThat(listOfListsFromInput).hasSize(2)
                .containsExactly(List.of(3, 4, 2, 1, 3, 3), List.of(4, 3, 5, 3, 9, 3));
    }

    @Test
    void testDay1Part1Small() {
        assertThat(day1.part1(Input.SMALL)).isEqualTo(11);
    }

    @Test
    void testDay1Part1Big() {
        assertThat(day1.part1(Input.BIG)).isEqualTo(2904518L);
    }

    @Test
    void testDay1Part2Small(){
        assertThat(day1.part2(Input.SMALL)).isEqualTo(31);
    }

    @Test
    void testDay1Part2Big(){
        assertThat(day1.part2(Input.BIG)).isEqualTo(18650129);
    }



}