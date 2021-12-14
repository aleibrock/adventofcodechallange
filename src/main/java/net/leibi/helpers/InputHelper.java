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

  public static int[] getIntArrayFromString(String s, String delimiter) {
    return Arrays.stream(s.split(delimiter))
        .filter(string -> !string.isBlank())
        .filter(string -> !string.isEmpty())
        .map(Integer::valueOf)
        .mapToInt(i -> i)
        .toArray();
  }

  public static int[] getIntArrayFromString(String s) {
    return Arrays.stream(s.split(""))
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


  public static int[][] getIntMatrixFromInput(String input){
    List<String> rowList = InputHelper.getRowListFromInput(input);
    int[][] result = new int[rowList.size()][rowList.get(0).length()];

    int currentRow = 0;
    for (String s : rowList) {
      int[] row = InputHelper.getIntArrayFromString(s);
      result[currentRow++] = row;
    }
    return result;
  }
}
