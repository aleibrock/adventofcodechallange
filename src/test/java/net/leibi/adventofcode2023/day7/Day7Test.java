package net.leibi.adventofcode2023.day7;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class Day7Test {

    private final Day7 day7 = new Day7();

    @Test
    void getTotalWinnings() {
        assertThat(day7.getTotalWinnings(Input.SMALL)).isEqualTo(6440);
    }

    @Test
    @Disabled
    void getTotalWinnings_Big() {
        assertThat(day7.getTotalWinnings(Input.BIG)).isNotEqualTo(250498105L);
        assertThat(day7.getTotalWinnings(Input.BIG)).isNotEqualTo(250497395L);
        assertThat(day7.getTotalWinnings(Input.BIG)).isEqualTo(1L);
    }

    @Test
    void getHands() {
        Cards cards = new Cards("32T3K");
        assertThat(day7.getHands(Input.SMALL)).hasSize(5).contains(new Hand(cards, 765L));
    }

    @Test
    void testWinngings() {
        assertThat(new Cards("KKKKK").getWin()).isEqualTo(Cards.WIN.FIVE_OAK);
        assertThat(new Cards("AKKKK").getWin()).isEqualTo(Cards.WIN.FOUR_OAK);
        assertThat(new Cards("AAKKK").getWin()).isEqualTo(Cards.WIN.FULL_HOUSE);
        assertThat(new Cards("AKAKK").getWin()).isEqualTo(Cards.WIN.FULL_HOUSE);
        assertThat(new Cards("AATKK").getWin()).isEqualTo(Cards.WIN.TWO_PAIR);
        assertThat(new Cards("A2A3K").getWin()).isEqualTo(Cards.WIN.ONE_PAIR);
        assertThat(new Cards("23456").getWin()).isEqualTo(Cards.WIN.HIGH);


    }

    @Test
    void testWinningCards() {
        assertThat(new Cards("KKKKK").getWinningCards()).isEqualTo(List.of('K'));
        assertThat(new Cards("AKKKK").getWinningCards()).isEqualTo(List.of('K'));
        assertThat(new Cards("AAKKK").getWinningCards()).isEqualTo(List.of('A', 'K'));
        assertThat(new Cards("AKAKK").getWinningCards()).isEqualTo(List.of('A', 'K'));
        assertThat(new Cards("AATKK").getWinningCards()).isEqualTo(List.of('A', 'K'));
        assertThat(new Cards("A2A3K").getWinningCards()).isEqualTo(List.of('A'));
        assertThat(new Cards("23456").getWinningCards()).isEqualTo(List.of('2', '3', '4', '5', '6'));


    }

    @Test
    void testHigherCard() {
        assertThat(Day7.isCardHigher('A', '6')).isEqualTo(1);
        assertThat(Day7.isCardHigher('K', 'A')).isEqualTo(-1);
        assertThat(Day7.isCardHigher('K', 'K')).isZero();

    }

    @Test
    void testSorting() {

        var sortedHandsSmall = day7.getSortedHands(Input.SMALL);
        assertThat(sortedHandsSmall.getFirst()).isEqualTo(getHand("32T3K", 765L));
        assertThat(sortedHandsSmall.getLast()).isEqualTo(getHand("QQQJA", 483L));

        assertThat(sortedHandsSmall)
                .hasSize(5)
                .containsExactly(getHand("32T3K", 765L),
                        getHand("KTJJT", 220L),
                        getHand("KK677", 28L),
                        getHand("T55J5", 684L),
                        getHand("QQQJA", 483L)
                );

        var sortedHands = day7.getSortedHands(Input.BIG);
        assertThat(sortedHands.getFirst()).isEqualTo(getHand("75362", 490L));
        assertThat(sortedHands.getLast()).isEqualTo(getHand("JJJJJ", 996L));
    }

    private static Hand getHand(String cards, Long bid) {
        return new Hand(new Cards(cards), bid);
    }


}