package net.leibi.adventofcode2022.day3;

public class Day32022 {

  record Rucksack(String content, String firstCompartment, String secondCompartment) {
    public Rucksack(String content) {
      this(content, content.substring(0, content.length() / 2),
          content.substring((content.length() / 2)));
    }
  }

}
