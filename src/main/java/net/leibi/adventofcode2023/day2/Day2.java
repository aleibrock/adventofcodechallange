package net.leibi.adventofcode2023.day2;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class Day2 {

    static final int cntRed = 12;
    static final int cntGreen = 13;
    static final int cntBlue = 14;


    public int getSumOfPossibleGames(String input) {
        log.info(input);
        var listOfGames = getListOfGames(input);
        log.info("list of games: {}", listOfGames);
        return listOfGames.stream().filter(this::gameIsPossible).mapToInt(Game::id).sum();
    }

    private boolean gameIsPossible(Game game) {
        return game.reveal.stream()
                .allMatch(g -> g.blue <= cntBlue && g.red <= cntRed && g.green <= cntGreen);
    }

    private List<Game> getListOfGames(String input) {
        return input.lines().map(this::getGameFromLine).toList();
    }

    private Game getGameFromLine(String line) {
        // Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green
        var id = Integer.parseInt(line.split(":")[0].split(" ")[1]);
        var revealLines = line.split(":")[1].split(";");
        var reveals = Arrays.stream(revealLines).map(this::getRGBFromReveal).toList();
        return new Game(id, reveals);
    }

    private RGB getRGBFromReveal(String reveal) {
        //1 red, 2 green
        AtomicInteger r = new AtomicInteger();
        AtomicInteger g = new AtomicInteger();
        AtomicInteger b = new AtomicInteger();

        String[] splittedReveal = reveal.trim().split((","));

        Arrays.stream(splittedReveal)
                .forEach(rev -> {
                    var split = rev.trim().split(" ");

                    int value = Integer.parseInt(split[0]);
                    switch (split[1]) {
                        case "red":
                            r.set(value);
                            break;
                        case "blue":
                            b.set(value);
                            break;
                        case "green":
                            g.set(value);
                            break;
                    }
                });

        return new RGB(r.get(), g.get(), b.get());
    }

    record Game(int id, List<RGB> reveal) {
    }

    record RGB(int red, int green, int blue) {
    }
}
