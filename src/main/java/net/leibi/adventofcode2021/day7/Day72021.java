package net.leibi.adventofcode2021.day7;

import static java.lang.Math.abs;
import static java.lang.Math.signum;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import net.leibi.helpers.InputHelper;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Day72021 {

  public static int solve(String input) {

    int[] initialPositions = InputHelper.getIntArrayFromString(input,",");

    Map<Integer, Integer> mapPositionToFuelSpend = new HashMap<>();

    int minPos = getMinimalPosition(initialPositions);
    int maxPos = getMaximalPosition(initialPositions);

    for (int pos = minPos; pos <= maxPos; pos++) {
      mapPositionToFuelSpend.put(pos, fuelSpendToGetToPos(initialPositions, pos));
    }

    return Collections.min(mapPositionToFuelSpend.values());
  }

  public static int solveWithIncreasingFuel(String input) {

    int[] initialPositions = InputHelper.getIntArrayFromString(input,",");

    Map<Integer, Integer> mapPositionToFuelSpend = new HashMap<>();

    int minPos = getMinimalPosition(initialPositions);
    int maxPos = getMaximalPosition(initialPositions);

    for (int pos = minPos; pos <= maxPos; pos++) {
      mapPositionToFuelSpend.put(pos, fuelSpendToGetToPosWithIncreasingFuelSpent(initialPositions, pos));
    }

    return Collections.min(mapPositionToFuelSpend.values());
  }

  private static Integer fuelSpendToGetToPos(int[] initialPositions, int pos) {
    int fuel = 0;
    for (int initialPosition : initialPositions) {
      fuel+= abs(initialPosition-pos);
    }
    return fuel;
  }

  private static Integer fuelSpendToGetToPosWithIncreasingFuelSpent(int[] initialPositions, int pos) {
    int fuel = 0;
    for (int initialPosition : initialPositions) {

      /*
          1 => 1
          2 => 3
          3 => 6
          4 => 14
          5 => 19
       */

      int diff =  abs(initialPosition-pos);
      fuel += fuelforDiff(diff);
    }
    return fuel;
  }

  private static int fuelforDiff(int diff) {
    int sum = 0;
    for (int i = 1; i <= diff; i++) {
      sum += i;
    }
    return sum;
  }

  private static int getMaximalPosition(int[] initialPositions) {
    int max = 0;
    for (int initialPosition : initialPositions) {
      if (initialPosition > max)
        max = initialPosition;
    }
    return max;
  }

  private static int getMinimalPosition(int[] initialPositions) {
    int min = 10000000;
    for (int initialPosition : initialPositions) {
      if (initialPosition < min)
        min = initialPosition;
    }
    return min;
  }
}
