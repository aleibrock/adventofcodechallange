package net.leibi.adventofcode2021.day3;

import static net.leibi.helpers.InputHelper.getRowListFromInput;

import java.util.ArrayList;
import java.util.List;

public class Day32021 {

  public int getPowerConsumption(final String input) {

    List<String> columns = getColumnsFromInput(input);
    int gammaValue = getGammaValue(columns);
    int epsilonRate = getEpsilonRate(columns);

    return gammaValue * epsilonRate;
  }

  List<String> getColumnsFromInput(final String input) {
    List<String> rowlist = getRowListFromInput(input);

    int columnSize = rowlist.get(0).length();

    List<String> columns = new ArrayList<>();

    for (String s : rowlist) {
      char[] splittedString = s.toCharArray();
      assert (splittedString.length == columnSize);
      for (int i = 0; i < splittedString.length; i++) {
        if (columns.size() > i ) { // we have it already
          String newString = columns.get(i).concat(String.valueOf(splittedString[i]));
          columns.set(i, newString);
        } else {
          columns.add(i, String.valueOf(splittedString[i]));
        }
      }
    }

    return columns;
  }

  int getMostCommonBinaryInString(final String string) {
    String ones = string.replace("0", "");
    String zeros = string.replace("1", "");
    if (ones.length() > zeros.length()) return 1;
    else return 0;
  }

  int getLeastCommonBinaryInString(final String string) {
    if (getMostCommonBinaryInString(string) == 1) return 0;
    return 1;
  }

   int getGammaValue(List<String> columns) {
    int[] gamma = new int[columns.size()];
    for (int i = 0; i < columns.size(); i++) {
      gamma[i] = getMostCommonBinaryInString(columns.get(i));
    }
    return getIntegerFromIntArray(gamma);
  }

   int getEpsilonRate(List<String> columns) {
    int[] gamma = new int[columns.size()];
    for (int i = 0; i < columns.size(); i++) {
      gamma[i] = getLeastCommonBinaryInString(columns.get(i));
    }
    return getIntegerFromIntArray(gamma);
  }

  int getIntegerFromIntArray(int[] intArray) {
    int result = 0;
    int multiplier = 1;
    for (int i = intArray.length-1; i >= 0; --i) {
      result += (multiplier * intArray[i]);
      multiplier *= 2;
    }
    return result;
  }
}
