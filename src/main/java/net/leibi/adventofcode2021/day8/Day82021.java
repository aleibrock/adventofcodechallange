package net.leibi.adventofcode2021.day8;

import static net.leibi.helpers.InputHelper.getRowListFromInput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Day82021 {

  private static final int[] valid_length = new int[] {2, 3, 4, 7};

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
}
