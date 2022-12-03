package net.leibi.adventofcode2022.day3;

import static com.google.common.primitives.Ints.max;

import com.google.common.collect.Lists;
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

  static Integer scorePart2(String input) {
    return getListOfGroups(input).stream()
        .map(Group::getCommonItem)
        .map(Day32022::getValueFromItem)
        .reduce(0, Integer::sum);
  }

  static List<Rucksack> getRucksackListFromInput(final String input) {
    return input.lines().map(Rucksack::new).toList();
  }

  static Integer getValueFromItem(final Character item) {
    int intValue = item;
    if (intValue > 95) {
      return intValue - 96;
    }
    return intValue - 38;
  }

  static List<Group> getListOfGroups(String input) {
    return Lists.partition(
            getRucksackListFromInput(input), 3).stream()
        .map(l -> new Group(l.get(0), l.get(1), l.get(2))).toList();
  }

  record Group(Rucksack r1, Rucksack r2, Rucksack r3) {

    public Character getCommonItem() {
      Rucksack rMax = getBiggestRucksack();
      for (int i = 0; i < rMax.content.length(); i++) {
        char ch = rMax.content.charAt(i);
        if (r1.content.indexOf(ch) != -1 && r2.content.indexOf(ch) != -1
            && r3.content.indexOf(ch) != -1) {
          return ch;
        }
      }
      return null;
    }

    private Rucksack getBiggestRucksack() {
      int maxLength = max(r1.content.length(), r2.content.length(), r3.content.length());
      Rucksack rMax = null;
      if (r1.content.length() == maxLength) {
        rMax = r1;
      } else if (r2.content.length() == maxLength) {
        rMax = r2;
      } else {
        rMax = r3;
      }
      return rMax;
    }
  }

  record Rucksack(String content, String firstCompartment, String secondCompartment) {

    public Rucksack(String content) {
      this(content, content.substring(0, content.length() / 2),
          content.substring((content.length() / 2)));
    }

    List<Character> getCommonItems() {
      var result = new ArrayList<Character>();
      for (int i = 0; i < firstCompartment.length(); i++) {
        Character ch = firstCompartment.charAt(i);
        if (secondCompartment.indexOf(ch) != -1 && !result.contains(ch)) {
          result.add(ch);
        }
      }
      return result;
    }

  }
}
