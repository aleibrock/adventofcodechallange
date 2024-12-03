package net.leibi.adventofcode2024.day3;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class Day3Test {

    private final Day3 day3 = new Day3();

    @Test
    void testPart1() {
     assertThat(day3.part1(Input.SMALL)).isEqualTo(161);
    }


    @Test
    void testPart1Big() {
        assertThat(day3.part1(Input.BIG)).isEqualTo(173731097L);
    }

    @Test
    void getValidMul(){
        assertThat(day3.getValidMul(Input.SMALL)).hasSize(4).containsExactly(new Mul(2,4), new Mul(5,5), new Mul(11,8), new Mul(8,5));
    }

}
