package net.leibi.adventofcode2023.day7;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static net.leibi.adventofcode2023.day7.Cards.WIN.*;

public class Cards extends ArrayList<Character> {


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
                if (hasNWinningCards(collectionMap, 2L))
                    yield FULL_HOUSE;
                yield FOUR_OAK;
            }
            case 3 -> {
                if (hasNWinningCards(collectionMap, 3L))
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
            case FOUR_OAK -> getWinningCardsFromMap(collectionMap, 4L);
            case FULL_HOUSE, HIGH -> collectionMap.keySet().stream().toList();
            case THREE_OAK -> getWinningCardsFromMap(collectionMap, 3L);
            case TWO_PAIR, ONE_PAIR -> getWinningCardsFromMap(collectionMap, 2L);
        };
    }

    private static boolean hasNWinningCards(Map<Character, Long> collectionMap, long anotherLong) {
        return collectionMap.values().stream().anyMatch(size -> size.compareTo(anotherLong) == 0);
    }

    private static List<Character> getWinningCardsFromMap(Map<Character, Long> collectionMap, long numberOfWinningCards) {
        return collectionMap.entrySet().stream()
                .filter(e -> e.getValue().equals(numberOfWinningCards))
                .map(Map.Entry::getKey)
                .toList();
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
