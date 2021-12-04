package net.leibi.adventofcode2021.day1;

import static net.leibi.helpers.InputHelper.getIntegerListFromInput;

import java.util.List;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Day12021 {

  public static int getNumberOfEncreases(final String input) {
    List<Integer> inputList = getIntegerListFromInput(input);
    int cnt = 0;
    for (int i = 0; i < inputList.size(); i++) {
      if (i > 0 && inputList.get(i) > inputList.get(i - 1)) {
        cnt++;
      }
    }
    return cnt;
  }

  public static int getNumberOfEncreasesWithSlidingWindow(final String input) {
    List<Integer> inputList = getIntegerListFromInput(input);
    int cnt = 0;
    for (int i = 0; i < inputList.size(); i++) {
      if (i > 2 && getCurrentWindow(inputList, i ) > getCurrentWindow(inputList, i-1)) {
        cnt++;
      }
    }
    return cnt;
  }

  private static int getCurrentWindow(List<Integer> inputList, int lastElement) {
    assert (inputList.size() > lastElement);
    return inputList.get(lastElement)
        + inputList.get(lastElement - 1)
        + inputList.get(lastElement - 2);
  }
}
