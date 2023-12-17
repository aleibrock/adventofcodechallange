package net.leibi.adventofcode2023.day6;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Day6Test {

    private final Day6 day6 = new Day6();

    @Test
    void getRaces() {

        assertThat(day6.getRaces(Input.SMALL)).hasSize(3).containsExactlyInAnyOrder(new Day6.Race(7, 9), new Day6.Race(15, 40), new Day6.Race(30, 200));

    }

}