package net.leibi.adventofcode2024.day2;

import java.util.Arrays;
import java.util.List;

public class Day2 {

  public static final int MIN_SAFE = 1;
  public static final int MAX_SAFE = 3;

  public long part1(String input) {
    final var list = input.lines().map(s -> s.split("\\s+")).toList();

    long cnt = 0;
    for (String[] strings : list) {
      var integerList = Arrays.stream(strings).map(Integer::parseInt).toList();
      if (isSafe(integerList)) {
        cnt++;
      }
    }
    return cnt;
  }

  boolean isSafe(List<Integer> report) {

    Direction direction = getDirection(getDiff(report, 1));
    boolean returnValue = true;
    for (var i = 1; i < report.size(); i++) {
      var diff = getDiff(report, i);
      if (isNotSafeDistance(diff)) return false;

      Direction localDir = getDirection(diff);
      if (localDir != direction) return false;
    }
    return returnValue;
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
    INC,
    DEC,
    BOTH
  }
}
