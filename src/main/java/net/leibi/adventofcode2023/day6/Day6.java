package net.leibi.adventofcode2023.day6;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class Day6 {

    public List<Race> getRaces(String small) {

        var times = parseLine(small, "Time:");
        var distances = parseLine(small, "Distance:");

        return IntStream.range(0, times.size())
                .mapToObj(index -> new Race(times.get(index), distances.get(index)))
                .toList();
    }

    public Long getNumberOfWaysToWin(Race race) {
        return LongStream.range(0, race.time + 1)
                .filter(race::speedWinsRace)
                .count();
    }

    public Long getProductOfWaysToWinByRaces(List<Race> races) {
        return races.stream().mapToLong(this::getNumberOfWaysToWin).reduce((l1, l2) -> l1 * l2).getAsLong();
    }

    public Long getProductOfWaysToWin(String small) {
        return getProductOfWaysToWinByRaces(getRaces(small));
    }

    public Race getRace(String small) {
        var time = parseLineSinge(small, "Time:");
        var distance = parseLineSinge(small, "Distance:");

        return new Race(time, distance);
    }

    public Long getWaysToWinSingleRace(String small) {
        return getNumberOfWaysToWin(getRace(small));
    }

    private Long parseLineSinge(String small, String delimiter) {
        return Long.valueOf(small.lines()
                .filter(l -> l.startsWith(delimiter))
                .findFirst().orElseThrow()
                .split(":")[1]
                .replace(" ", ""));
    }

    private static List<Integer> parseLine(String small, String prefix) {
        return Arrays.stream(small.lines()
                        .filter(line -> line.startsWith(prefix)).findFirst().orElseThrow()
                        .split(":")[1].split(" "))
                .filter(s -> !s.isEmpty())
                .map(Integer::parseInt)
                .toList();
    }

    public record Race(long time, long distance) {

        boolean speedWinsRace(Long speed) {
            return (speed * (time - speed)) > distance;
        }
    }
}
