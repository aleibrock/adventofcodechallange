package net.leibi.adventofcode2022.day3;

import java.util.ArrayList;
import java.util.List;

public class Day32022 {


  static Integer score(String input) {
    return getRucksackListFromInput(input).stream()
        .map(Rucksack::getCommonItems)
        .map(commonItems -> commonItems.stream()
            .map(Day32022::getValueFromItem)
            .reduce(0, Integer::sum))
        .reduce(0, Integer::sum);
  }

  static List<Rucksack> getRucksackListFromInput(final String input) {
    return input.lines().map(Rucksack::new).toList();
  }


  static Integer getValueFromItem(final String item) {
    int intValue = (item.charAt(0));
    if (intValue > 95) {
      return intValue - 96;
    }
    return intValue - 38;
  }

  record Rucksack(String content, String firstCompartment, String secondCompartment) {

    public Rucksack(String content) {
      this(content, content.substring(0, content.length() / 2),
          content.substring((content.length() / 2)));
    }

    List<String> getCommonItems() {
      var result = new ArrayList<String>();
      for (int i = 0; i < firstCompartment.length(); i++) {
        char ch = firstCompartment.charAt(i);
        if (secondCompartment.indexOf(ch) != -1 && !result.contains(String.valueOf(ch))) {
          result.add(String.valueOf(ch));
        }
      }
      return result;
    }

  }

}
