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
}
