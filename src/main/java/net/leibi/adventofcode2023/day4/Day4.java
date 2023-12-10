package net.leibi.adventofcode2023.day4;

import org.springframework.lang.NonNull;

import java.util.Arrays;
import java.util.List;

public class Day4 {
    public Integer sumPointsOfPile(String input) {

        return input.lines()
                .map(this::getCardFromLine)
                .mapToInt(this::getPointsFromCard)
                .sum();

    }

    private Integer getPointsFromCard(Card card) {
        var numberOfWinningNumbers = card.numbers().stream().filter(number -> card.winningNumbers().contains(number)).count();
        if (numberOfWinningNumbers == 0) return 0;
        if (numberOfWinningNumbers == 1) return 1;
        return ((Double) Math.pow(2, numberOfWinningNumbers - 1)).intValue();
    }

    @NonNull
    private Card getCardFromLine(String line) {
        //Card 1: 41 48 83 86 17 | 83 86  6 31 17  9 48 53
        var id = Arrays.stream(line.split(":")[0].split(" ")).filter(s -> !s.isEmpty()).toList().getLast();
        var numbersSplit = line.split(":")[1].split("\\|");
        List<Integer> numbers = Arrays.stream(numbersSplit[0].trim().split(" "))
                .filter(s -> !s.isEmpty())
                .map(Integer::parseInt)
                .toList();
        List<Integer> winningNumbers = Arrays.stream(numbersSplit[1].trim().split(" "))
                .filter(s -> !s.isEmpty())
                .map(Integer::parseInt)
                .toList();

        return new Card(Integer.parseInt(id), numbers, winningNumbers);
    }
}
