package net.leibi.adventofcode2023.day5;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class Day5Test {

    private final Day5 day5 = new Day5();

    @Test
    void getLowestLocationNumber_Small() {
        assertThat(day5.getLowestLocationNumber(Input.SMALL)).isEqualTo(35);
    }

    @Test
    void getLowestLocationNumber_Big() {
        assertThat(day5.getLowestLocationNumber(Input.BIG)).isEqualTo(240320250);
    }

    @Test
    void getSeedList() {
        day5.fillSeedList(Input.SMALL);
        assertThat(day5.seedList).isEqualTo(List.of(79, 14, 55, 13));
    }

    @Test
    void getseed2soilMap() {
        day5.getLowestLocationNumber(Input.SMALL);
        assertThat(day5.seed2SOILLookUpMap).hasSize(50);
        assertThat(day5.soil2FertilizerMap).hasSize(54);
    }

}