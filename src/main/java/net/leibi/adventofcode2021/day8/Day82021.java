package net.leibi.adventofcode2021.day8;

import static net.leibi.helpers.InputHelper.getRowListFromInput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import net.leibi.helpers.InputHelper;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Day82021 {

  private static final int[] valid_length = new int[] {2, 3, 4, 7};

  public static List<String> parsePattern(String line) {
    return Arrays.stream(line.split("\\|")[0].split(" ")).filter(s -> !s.isBlank()).toList();
  }

  public static int solve2(String input) {

    List<String> lines = InputHelper.getRowListFromInput(input);
    int result = 0;
    for (String line : lines) {
      Display display = new Display(line);
      result += getOutputForDisplay(display);
    }
    return result;
  }

  static List<String> parseOutputValues(final String input) {
    List<String> result = new ArrayList<>();
    List<String> lines = getRowListFromInput(input);
    for (String line : lines) {
      result.addAll(
          Arrays.stream(line.split("\\|")[1].split(" ")).filter(s -> !s.isBlank()).toList());
    }
    return result;
  }

  static int getNumberOfUniqueDigits(final String input) {
    return parseOutputValues(input).stream()
        .filter(s -> Arrays.stream(valid_length).anyMatch(v -> v == s.trim().length()))
        .toList()
        .size();
  }

  static int getOutputForDisplay(final Display display) {
    int result = 0;
    List<Integer> outPutDigits = display.getOutputDigits();
    for (int i = 0; i < outPutDigits.size(); i++) {
      result *= 10;
      result += outPutDigits.get(i);
    }
    return result;
  }
}
