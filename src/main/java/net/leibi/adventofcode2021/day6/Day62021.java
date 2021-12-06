package net.leibi.adventofcode2021.day6;

import static net.leibi.helpers.InputHelper.getIntArrayFromString;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Day62021 {

  List<Integer> fishes;

  public Day62021(final String input) {
    fishes = getFishesFromInput(input);
  }

  public void simulateDays(int numberOfDays) {

    for (int i = 0; i < numberOfDays; i++) {
      simulateDay();
    }
  }

  static List<Integer> getFishesFromInput(String input) {
    return Arrays.stream(getIntArrayFromString(input.trim(), ","))
        .boxed()
        .collect(Collectors.toList());
  }

  private void simulateDay() {
    int numberOfFishesToAdd = 0;
    for (int i = 0; i < fishes.size(); i++) {
      int currentFish = fishes.get(i);
      if (currentFish == 0) {
        fishes.set(i, 6);
        numberOfFishesToAdd++;
      } else {
        fishes.set(i, --currentFish);
      }
    }
    for (int i = 0; i < numberOfFishesToAdd; i++) {
      fishes.add(8);
    }
  }
}
