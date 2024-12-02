package net.leibi.adventofcode2024.day2;

import java.util.Arrays;
import java.util.List;

public class Day2 {
    public long part1(String input) {
        final var list = input.lines().map(s -> s.split("\\s+")).toList();
        return list.stream().filter(a -> isSafe(Arrays.asList(a))).count();
    }

    boolean isSafe(List<Integer> report) {

        int minSafe = 1;
        int maxSafe = 3;

        Direction direction = report.get(1) - report.get(0) > 0 ? Direction.INC : Direction.DEC;
        for (var i = 1; i < report.size(); i++) {
            var diff = report.get(i) - report.get(i - 1);
            if (Math.abs(diff) > maxSafe || Math.abs(diff) < minSafe)
                return false;

            Direction localDir = diff > 0 ? Direction.INC : Direction.DEC;
            if (localDir != direction)
                return false;
        }
        return true;
    }

    enum Direction {
        INC,
        DEC,
        BOTH
    }

}
