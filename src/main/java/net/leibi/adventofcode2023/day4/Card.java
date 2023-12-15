package net.leibi.adventofcode2023.day4;

import java.util.List;

public record Card(int id, List<Integer> numbers, List<Integer> winningNumbers, int copyCount) {

    public Card(int id, List<Integer> numbers, List<Integer> winningNumbers) {
        this(id, numbers, winningNumbers, 0);
    }

    boolean isCopy() {
        return copyCount > 0;
    }

    Card getCopy() {
        return new Card(id, numbers, winningNumbers, copyCount + 1);
    }
}
