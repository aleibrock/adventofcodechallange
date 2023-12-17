package net.leibi.adventofcode2023.day6;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Day6 {

    public List<Race> getRaces(String small) {

        var times = parseLine(small, "Time:");
        var distances = parseLine(small, "Distance:");

        return IntStream.range(0, times.size()).mapToObj(index -> new Race(times.get(index), distances.get(index))).toList();
    }

    private static List<Integer> parseLine(String small, String prefix) {
        return Arrays.stream(small.lines().filter(line -> line.startsWith(prefix)).findFirst().orElseThrow().split(":")[1].split(" ")).filter(s -> !s.isEmpty()).map(Integer::parseInt).toList();
    }

    public record Race(int time, int distance) {
    }
}
