package net.leibi.adventofcode2022.day1;

import static net.leibi.helpers.InputHelper.getIntegerListFromInput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Day12022 {

  public static Integer getMostCalories(@NonNull final String input) {
    return getElfesFromInput(input).stream().map(Elf::totalCalories).max(Integer::compareTo)
        .orElse(0);
  }

  static List<Elf> getElfesFromInput(@NonNull final String input) {
    List<String> substrings = Arrays.stream(input.split("\\n\\n")).toList();
    return getElfesFromStringslist(substrings);
  }

  private static List<Elf> getElfesFromStringslist( final List<String> substrings) {
    List<Elf> elfes = new ArrayList<>();
    for (String substring : substrings) {
      elfes.add(new Elf(getIntegerListFromInput(substring)));
    }
    return elfes;
  }


}
