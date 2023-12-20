package net.leibi.adventofcode2023.day7;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Day7Test {

    private final Day7 day7 = new Day7();

    @Test
    void getTotalWinnings() {
        assertThat(day7.getTotalWinnings(Input.SMALL)).isEqualTo(6440);
    }

    @Test
    void getHands() {
        Day7.Cards cards = new Day7.Cards("32T3K");
        assertThat(day7.getHands(Input.SMALL)).hasSize(5).contains(new Day7.Hand(cards,765L));
    }

}