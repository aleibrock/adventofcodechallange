package net.leibi.adventofcode2023.day12;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Day12Test {

    public static final Day12 day12 = new Day12();

    @Test
    void testSumOfPossibilitiesSmall() {
        assertThat(day12.getSumOfPossibilities(Input.SMALL)).isEqualTo(21);
    }

    @Test
    void testSumOfPossibilitiesBig() {
        assertThat(day12.getSumOfPossibilities(Input.BIG)).isEqualTo(7236L);
    }


    @Test
    void testGetPossibilitiesForRow1() {
        assertThat(day12.getPossibilitiesForRow("???.### 1,1,3")).isEqualTo(1);
    }

    @Test
    void testGetPossibilitiesForRow2() {
        assertThat(day12.getPossibilitiesForRow(".??..??...?##. 1,1,3")).isEqualTo(4);
    }

    @Test
    void testGetPossibilitiesForRow3() {
        assertThat(day12.getPossibilitiesForRow("?#?#?#?#?#?#?#? 1,3,1,6")).isEqualTo(1);
    }
}

