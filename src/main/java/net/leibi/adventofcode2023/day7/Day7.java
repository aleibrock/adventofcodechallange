package net.leibi.adventofcode2023.day7;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static net.leibi.adventofcode2023.day7.Day7.Cards.WIN.*;

@Slf4j
public class Day7 {
    static List<Character> cardOrder = List.of('A', 'K', 'Q', 'J', 'T', '9', '8', '7', '6', '5', '4', '3', '2');

    public Long getTotalWinnings(String input) {
        var hands = getHands(input);
        log.info("hands: {}", hands);
        var sortedHands = new ArrayList<>(hands);
        sortedHands.sort(Hand::isBetter);
        log.info("sorted hands: {}", sortedHands);
        return IntStream.range(0, sortedHands.size())
                .mapToLong(rank -> {
                    //xlog.info("rank: {}, value {}, result: {}", rank, sortedHands.get(rank).Bid, sortedHands.get(rank).Bid * (rank + 1));
                    return sortedHands.get(rank).Bid * (rank + 1);
                })
                .sum();
    }

    public List<Hand> getHands(String input) {
        return input.lines().map(this::getHand).toList();
    }

    static int isCardHigher(Character c1, Character c2) {
        return Integer.compare(cardOrder.indexOf(c2), cardOrder.indexOf(c1));
    }

    /*
    static Character getHighestCard(Cards cards) {
        var thisMap = cards.stream().collect(Collectors.groupingBy(Character::charValue, Collectors.counting()));
        var sorted = thisMap.entrySet().stream().sorted((e1, e2) -> isCardHigher(e2.getKey(), e1.getKey()));
        return sorted.findFirst().get().getKey();
    }

     */

    static List<Character> sortCards(Cards cards) {
        var thisMap = cards.stream().collect(Collectors.groupingBy(Character::charValue, Collectors.counting()));
        return thisMap.entrySet().stream()
                .sorted((e1, e2) -> isCardHigher(e2.getKey(), e1.getKey()))
                .map(Map.Entry::getKey).distinct()
                .toList();
    }

    private static List<Character> sortCards(List<Character> characters) {
        return characters.stream().sorted((c1, c2) -> -1 * Day7.isCardHigher(c1, c2)).toList();
    }


    private Hand getHand(String line) {
        var split = line.split(" ");
        return new Hand(new Cards(split[0]), Long.parseLong(split[1]));
    }

    public record Hand(Cards cards, Long Bid) {

        public int isBetter(Hand o2) {
            var myRank = cards.getWin().ordinal();
            var otherRank = o2.cards.getWin().ordinal();
            var compare = Integer.compare(otherRank, myRank);
            if (0 != compare) {
                return compare;
            }
            // determine highest card of the winning bunch
            var sorted = new ArrayList<>(sortCards(cards.getWinningCards()));
            var otherSorted = new ArrayList<>(sortCards(o2.cards.getWinningCards()));
            assert (sorted.size() == otherSorted.size());
            while (sorted.getFirst().equals(otherSorted.getFirst())) {
                sorted.removeFirst();
                otherSorted.removeFirst();
                if (sorted.isEmpty()) return 0;
            }

            return isCardHigher(sorted.getFirst(), otherSorted.getFirst());


        }


    }

    public static class Cards extends ArrayList<Character> {
        ;

        public Cards(String cardsAsString) {
            super(cardsAsString.length());
            for (int i = 0; i < cardsAsString.toCharArray().length; i++) {
                add(cardsAsString.toCharArray()[i]);
            }
        }

        WIN getWin() {
            var collectionMap = this.stream().collect(Collectors.groupingBy(Character::charValue, Collectors.counting()));
            return switch (collectionMap.keySet().size()) {
                case 1 -> FIVE_OAK;
                case 2 -> {
                    // full house or four of a kind
                    if (collectionMap.values().stream().anyMatch(size -> size.compareTo(2L) == 0))
                        yield FULL_HOUSE;
                    yield FOUR_OAK;
                }
                case 3 -> {
                    if (collectionMap.values().stream().anyMatch(size -> size.compareTo(3L) == 0))
                        yield THREE_OAK;
                    yield TWO_PAIR;
                }
                case 4 -> ONE_PAIR;
                case 5 -> HIGH;
                default -> throw new RuntimeException("what?");
            };
        }

        List<Character> getWinningCards() {
            var collectionMap = this.stream().collect(Collectors.groupingBy(Character::charValue, Collectors.counting()));
            return switch (getWin()) {
                case FIVE_OAK -> collectionMap.keySet().stream().distinct().toList();
                case FOUR_OAK ->
                        collectionMap.entrySet().stream().filter(e -> e.getValue().equals(4L)).map(Map.Entry::getKey).toList();
                case FULL_HOUSE -> collectionMap.keySet().stream().toList();
                case THREE_OAK ->
                        collectionMap.entrySet().stream().filter(e -> e.getValue().equals(3L)).map(Map.Entry::getKey).toList();
                case TWO_PAIR ->
                        collectionMap.entrySet().stream().filter(e -> e.getValue().equals(2L)).map(Map.Entry::getKey).toList();
                case ONE_PAIR ->
                        collectionMap.entrySet().stream().filter(e -> e.getValue().equals(2L)).map(Map.Entry::getKey).toList();
                case HIGH -> collectionMap.keySet().stream().toList();
            };
        }

        enum WIN {
            FIVE_OAK,
            FOUR_OAK,
            FULL_HOUSE,
            THREE_OAK,
            TWO_PAIR,
            ONE_PAIR,
            HIGH

        }


    }
}
