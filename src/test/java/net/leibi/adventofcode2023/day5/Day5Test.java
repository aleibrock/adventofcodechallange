package net.leibi.adventofcode2023.day5;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Day5Test {

    private final Day5 day5 = new Day5();

    @Test
    void getLowestLocationNumber_Small() {
        assertThat(day5.getLowestLocationNumber(Input.SMALL)).isEqualTo(35);
    }

    @Test
    void getCompleteSeedList_Small() {
        assertThat(day5.getLowestLocationNumberFromSeedList(Input.SMALL)).isEqualTo(46);
    }


    @Test
    void getCompleteSeedList_Big() {
        assertThat(day5.getLowestLocationNumberFromSeedList(Input.BIG)).isEqualTo(46);
    }

    @Test
    void getLowestLocationNumber_Big() {
        assertThat(day5.getLowestLocationNumber(Input.BIG)).isEqualTo(240320250);
    }

    @Test
    void getSeedList() {
        day5.fillSeedList(Input.SMALL);
        assertThat(day5.seedList).hasSize(4);
    }

    @Test
    void getseed2soilMap() {
        day5.getLowestLocationNumber(Input.SMALL);
        assertThat(day5.seed2SOILLookUpMap).hasSize(2);
        assertThat(day5.soil2FertilizerMap).hasSize(3);
    }

}