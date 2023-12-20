package net.leibi.adventofcode2023.day7;

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
    void getTotalWinnings_Big() {
        assertThat(day7.getTotalWinnings(Input.BIG)).isEqualTo(250433478L);
    }

    @Test
    void getHands() {
        Day7.Cards cards = new Day7.Cards("32T3K");
        assertThat(day7.getHands(Input.SMALL)).hasSize(5).contains(new Day7.Hand(cards, 765L));
    }

    @Test
    void testWinngings() {
        assertThat(new Day7.Cards("KKKKK").getWin()).isEqualTo(Day7.Cards.WIN.FIVE_OAK);
        assertThat(new Day7.Cards("AKKKK").getWin()).isEqualTo(Day7.Cards.WIN.FOUR_OAK);
        assertThat(new Day7.Cards("AAKKK").getWin()).isEqualTo(Day7.Cards.WIN.FULL_HOUSE);
        assertThat(new Day7.Cards("AKAKK").getWin()).isEqualTo(Day7.Cards.WIN.FULL_HOUSE);
        assertThat(new Day7.Cards("AATKK").getWin()).isEqualTo(Day7.Cards.WIN.TWO_PAIR);
        assertThat(new Day7.Cards("A2A3K").getWin()).isEqualTo(Day7.Cards.WIN.ONE_PAIR);
        assertThat(new Day7.Cards("23456").getWin()).isEqualTo(Day7.Cards.WIN.HIGH);


    }

    @Test
    void testWinningCards() {
        assertThat(new Day7.Cards("KKKKK").getWinningCards()).isEqualTo(List.of('K'));
        assertThat(new Day7.Cards("AKKKK").getWinningCards()).isEqualTo(List.of('K'));
        assertThat(new Day7.Cards("AAKKK").getWinningCards()).isEqualTo(List.of('A', 'K'));
        assertThat(new Day7.Cards("AKAKK").getWinningCards()).isEqualTo(List.of('A', 'K'));
        assertThat(new Day7.Cards("AATKK").getWinningCards()).isEqualTo(List.of('A', 'K'));
        assertThat(new Day7.Cards("A2A3K").getWinningCards()).isEqualTo(List.of('A'));
        assertThat(new Day7.Cards("23456").getWinningCards()).isEqualTo(List.of('2', '3', '4', '5', '6'));


    }

    @Test
    void testHigherCard() {
        assertThat(Day7.isCardHigher('A', '6')).isEqualTo(1);
        assertThat(Day7.isCardHigher('K', 'A')).isEqualTo(-1);
        assertThat(Day7.isCardHigher('K', 'K')).isZero();

    }

    /*
    @Test
    void testHighestCard(){
       assertThat(Day7.getHighestCard(new Day7.Cards("AAKKK"))).isEqualTo('A');
        assertThat(Day7.getHighestCard(new Day7.Cards("23456"))).isEqualTo('6');
        assertThat(Day7.getHighestCard(new Day7.Cards("AATKK"))).isEqualTo('A');

    }

     */


}