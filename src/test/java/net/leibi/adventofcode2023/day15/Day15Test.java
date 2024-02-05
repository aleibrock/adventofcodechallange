package net.leibi.adventofcode2023.day15;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class Day15Test {

    private final Day15 day15 = new Day15();

    @Test
    void testHash() {
        assertThat(day15.getHash("HASH")).isEqualTo(52);
    }

    @Test
    void testDay1() {
        assertThat(day15.day1(Input.SMALL)).isEqualTo(1320);
    }

    @Test
    void testDay1Big() {
        assertThat(day15.day1(Input.BIG)).isEqualTo(507666L);
    }

    @Test
    void testDay2Small() {
        assertThat(day15.day2(Input.SMALL)).isEqualTo(145);
    }

    @Test
    void testDay2Big() {
        assertThat(day15.day2(Input.BIG)).isEqualTo(233537L);
    }


    @Test
    void testDay2GetLabeledEntry(){

        assertThat(day15.getLabeledEntry("rn=1")).isEqualTo(new Day15.LabeledEntry("rn","=",1L));
        assertThat(day15.getLabeledEntry("cm-")).isEqualTo(new Day15.LabeledEntry("cm","-",null));


    }
}