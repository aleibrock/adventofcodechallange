package net.leibi.adventofcode2023.day14;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Day14Test {

    Day14 day14 = new Day14();

    @Test
    void testTilt() {
        assertThat(day14.tilt(Input.SMALL)).isEqualTo(net.leibi.adventofcode2023.day14.Input.SMALL_TILTED);
    }

    @Test
    void testLoad() {
        assertThat(day14.sumLoad(Input.SMALL_TILTED)).isEqualTo(136);
    }

    @Test
    void testLoadSmall() {
        assertThat(day14.sumLoad("OOOO.#.O..")).isEqualTo(5);
        assertThat(day14.sumLoad("""
                OOOO.#.O..  
                OO..#....#
                """)).isEqualTo((5 * 2) + 2);
    }

    @Test
    void testPart1Small() {
        assertThat(day14.part1(Input.SMALL)).isEqualTo(136);
    }

}