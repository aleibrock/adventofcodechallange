package net.leibi.adventofcode2021.day8;

import static net.leibi.helpers.InputHelper.getRowListFromInput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Day82021 {

  private static final int[] valid_length = new int[] {2, 3, 4, 7};

  static List<String> parseInput(final String input) {

    List<String> result = new ArrayList<>();

    List<String> lines = getRowListFromInput(input);
    for (String line : lines) {
      result.addAll(
          Arrays.stream(line.split("\\|")[1].split(" "))
              .filter(s -> !s.isBlank())
              .collect(Collectors.toList()));
    }

    return result;
  }

  static int solve(final String input) {
    List<String> output_values = parseInput(input);

    return output_values.stream()
        .filter(s -> Arrays.stream(valid_length).anyMatch(v -> v == s.trim().length()))
        .toList()
        .size();
  }
}
