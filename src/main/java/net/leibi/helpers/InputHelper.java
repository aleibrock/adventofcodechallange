package net.leibi.helpers;

import java.util.Arrays;
import java.util.List;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class InputHelper {

  public static List<Integer> getIntegerListFromInput(final String input) {
    return Arrays.stream(input.split("\\r?\\n")).map(Integer::valueOf).toList();
  }

  public static List<String> getRowListFromInput(final String input) {
    return Arrays.stream(input.split("\\r?\\n")).toList();
  }

  public static int getIntegerFromString(String s) {
    int[] intArray = getIntArrayFromString(s);
    return getIntegerFromIntArray(intArray);
  }

  public static int[] getIntArrayFromString(String s) {
    return Arrays.stream(s.split(""))
        .filter(string -> !string.isBlank())
        .filter(string -> !string.isEmpty())
        .map(Integer::valueOf)
        .mapToInt(i -> i)
        .toArray();
  }

  public static int[] getIntArrayFromStringWithSpaces(String s) {
    return Arrays.stream(s.split(" "))
        .filter(string -> !string.isBlank())
        .filter(string -> !string.isEmpty())
        .map(Integer::valueOf)
        .mapToInt(i -> i)
        .toArray();
  }

  public static int getIntegerFromIntArray(int[] intArray) {
    int result = 0;
    int multiplier = 1;
    for (int i = intArray.length - 1; i >= 0; --i) {
      result += (multiplier * intArray[i]);
      multiplier *= 2;
    }
    return result;
  }
}
