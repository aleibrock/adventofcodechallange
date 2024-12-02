package net.leibi.adventofcode2024.day2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Day2 {

    public static final int MIN_SAFE = 1;
    public static final int MAX_SAFE = 3;

    public long part1(String input, boolean dampener) {
        final var list = input.lines().map(s -> s.split("\\s+")).toList();

        long cnt = 0;
        for (String[] strings : list) {
            var integerList = Arrays.stream(strings).map(Integer::parseInt).toList();
            if (isSafe(integerList, dampener)) {
                cnt++;
            }
        }
        return cnt;
    }

    boolean isSafe(List<Integer> report, boolean dampener) {

        Direction direction = getDirection(getDiff(report, 1));
        final var failedIndices = getFailedIndices(report, direction);
        if (dampener && !failedIndices.isEmpty()) {
            for (var i = 0; i < report.size(); i++) {
                var clone = new ArrayList<>(report);
                clone.remove(i);
                if (isSafe(clone, false)) return true;
            }
        }
        return failedIndices.isEmpty();
    }

    private static Set<Integer> getFailedIndices(List<Integer> report, Direction direction) {
        Set<Integer> failedIndices = new HashSet<>();
        for (var i = 1; i < report.size(); i++) {
            var diff = getDiff(report, i);
            if (isNotSafeDistance(diff)) {
                failedIndices.add(i - 1);
            }

            Direction localDir = getDirection(diff);
            if (localDir != direction) {
                failedIndices.add(i - 1);
            }
        }
        return failedIndices;
    }

    private static int getDiff(List<Integer> report, int i) {
        return report.get(i) - report.get(i - 1);
    }

    private static Direction getDirection(int diff) {
        return diff > 0 ? Direction.INC : Direction.DEC;
    }

    private static boolean isNotSafeDistance(int diff) {
        return Math.abs(diff) > MAX_SAFE || Math.abs(diff) < MIN_SAFE;
    }

    enum Direction {
        INC, DEC, BOTH
    }
}
