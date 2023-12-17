package net.leibi.adventofcode2023.day6;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class Day6Test {

    private final Day6 day6 = new Day6();

    @Test
    void getRaces() {
        assertThat(day6.getRaces(Input.SMALL)).hasSize(3).containsExactlyInAnyOrder(new Day6.Race(7, 9), new Day6.Race(15, 40), new Day6.Race(30, 200));

    }

    @Test
    void getNumberOfWaysToWin() {
        assertThat(day6.getNumberOfWaysToWin(new Day6.Race(7, 9))).isEqualTo(4);
        assertThat(day6.getNumberOfWaysToWin(new Day6.Race(15, 40))).isEqualTo(8);
        assertThat(day6.getNumberOfWaysToWin(new Day6.Race(30, 200))).isEqualTo(9);
    }


    @Test
    void getProductOfWaysToWinByRaces() {
        assertThat(day6.getProductOfWaysToWinByRaces(List.of(new Day6.Race(7, 9), new Day6.Race(15, 40), new Day6.Race(30, 200)))).isEqualTo(288);
    }

    @Test
    void getProductOfWaysToWin() {
        assertThat(day6.getProductOfWaysToWin(Input.SMALL)).isEqualTo(288);
    }

    @Test
    void getProductOfWaysToWin_BIG() {
        assertThat(day6.getProductOfWaysToWin(Input.BIG)).isEqualTo(293046L);
    }

}