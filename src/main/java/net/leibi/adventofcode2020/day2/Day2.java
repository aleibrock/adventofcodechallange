package net.leibi.adventofcode2020.day2;

import java.util.Arrays;
import java.util.List;

public class Day2 {

  public long getValidPasswords1() {
    return parseInput().stream().filter(this::isValid1).count();
  }

  public long getValidPasswords2() {
    return parseInput().stream().filter(this::isValid2).count();
  }

  private boolean isValid2(Entry entry) {
    char c1 = entry.getPassword().charAt(entry.getFirstLimit() - 1);
    char c2 = entry.getPassword().charAt(entry.getSecondLimit() - 1);
    return c1 == entry.getCharacter() ^ c2 == entry.getCharacter();
  }

  private boolean isValid1(Entry entry) {
    int nbChar = entry.getPassword().replaceAll("[^" + entry.getCharacter() + "]", "").length();
    return nbChar >= entry.getFirstLimit() && nbChar <= entry.getSecondLimit();
  }

  private List<Entry> parseInput() {
    return Arrays.stream(Input.getInput().split("\\r?\\n")).map(this::getEntry).toList();
  }

  private Entry getEntry(String s) {
    String[] splittedString = s.split(" ");
    assert (splittedString.length == 3);
    return Entry.builder()
        .firstLimit(Integer.parseInt(splittedString[0].split("-")[0]))
        .secondLimit(Integer.parseInt(splittedString[0].split("-")[1]))
        .password(splittedString[2])
        .character(splittedString[1].charAt(0))
        .build();
  }
}
