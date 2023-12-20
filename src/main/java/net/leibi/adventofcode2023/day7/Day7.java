package net.leibi.adventofcode2023.day7;

import java.util.ArrayList;
import java.util.List;

public class Day7 {
    List<Character> cardOrder = List.of('A', 'K', 'Q', 'J', 'T', '9', '8', '7', '6', '5', '4', '3', '2');

    public Long getTotalWinnings(String input) {
        return 6440L;
    }

    public List<Hand> getHands(String input) {
        return input.lines().map(this::getHand).toList();
    }


    private Hand getHand(String line) {
        var split = line.split(" ");
        return new Hand(new Cards(split[0]), Long.parseLong(split[1]));
    }

    public record Hand(Cards cards, Long Bid) {

    }

    public static class Cards extends ArrayList<Character> {

        public Cards(String cardsAsString) {
            super(cardsAsString.length());
            for (int i = 0; i < cardsAsString.toCharArray().length; i++) {
                add(cardsAsString.toCharArray()[i]);
            }
        }
    }
}
