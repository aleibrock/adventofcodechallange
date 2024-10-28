package net.leibi.adventofcode2023.day16;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class Day16Test {


    @Test
    void part1() {
        assertThat(Day16.day1(Input.SMALL)).isEqualTo(46);
    }

}