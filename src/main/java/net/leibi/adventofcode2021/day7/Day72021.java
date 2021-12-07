package net.leibi.adventofcode2021.day7;

import static java.lang.Math.abs;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import net.leibi.helpers.InputHelper;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Day72021 {

  public static int solve(String input, boolean withIncreasing) {

    int[] initialPositions = InputHelper.getIntArrayFromString(input,",");

    Map<Integer, Integer> mapPositionToFuelSpend = new HashMap<>();

    int minPos = getMinimalPosition(initialPositions);
    int maxPos = getMaximalPosition(initialPositions);

    for (int pos = minPos; pos <= maxPos; pos++) {
      mapPositionToFuelSpend.put(pos, fuelSpendToGetToPos(initialPositions, pos, withIncreasing));
    }

    return Collections.min(mapPositionToFuelSpend.values());
  }

  private static Integer fuelSpendToGetToPos(
      int[] initialPositions, int pos, boolean withIncreasing) {
    int fuel = 0;
    for (int initialPosition : initialPositions) {
      final int diff = abs(initialPosition - pos);
      fuel += withIncreasing ? fuelforDiff(diff) : diff;
    }
    return fuel;
  }


  private static int fuelforDiff(int diff) {
    return diff*(1+diff)/2;
  }

  private static int getMaximalPosition(int[] initialPositions) {
    return Arrays.stream(initialPositions).distinct().max().orElse(0);
  }

  private static int getMinimalPosition(int[] initialPositions) {
    return Arrays.stream(initialPositions).distinct().min().orElse(0);
  }
}
