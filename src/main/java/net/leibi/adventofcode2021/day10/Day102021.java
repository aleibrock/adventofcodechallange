package net.leibi.adventofcode2021.day10;

import java.util.ArrayList;
import java.util.List;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import net.leibi.helpers.InputHelper;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Day102021 {

  static int solveFirstPart(final String input) {
    return InputHelper.getRowListFromInput(input).stream()
        .map(row -> getScoreForChar(getFirstWrongChar(row)))
        .mapToInt(i -> i)
        .sum();
  }

  static String getFirstWrongChar(final String input) {
    List<String> openingChars = new ArrayList<>();
    for (String ch : input.split("")) {
      if (isOpeningChar(ch)) {
        openingChars.add(ch);
      } else {
        // so we have a closing char
        // it has to match the last openingChar
        if (isCounterPart(openingChars.get(openingChars.size() - 1), ch)) {
          openingChars.remove(openingChars.size() - 1);
        } else {
          return ch;
        }
      }
    }
    return "";
  }

  static int getScoreForChar(String ch) {
    if (ch.equals(")")) return 3;
    if (ch.equals("]")) return 57;
    if (ch.equals("}")) return 1197;
    if (ch.equals(">")) return 25137;

    return 0;
  }

  private static boolean isCounterPart(String openingChar, String currentChar) {
    if (openingChar.equals("(")) return currentChar.equals(")");
    if (openingChar.equals("[")) return currentChar.equals("]");
    if (openingChar.equals("{")) return currentChar.equals("}");
    if (openingChar.equals("<")) return currentChar.equals(">");

    return false;
  }

  private static boolean isOpeningChar(String ch) {
    return ch.equals("[") || ch.equals("(") || ch.equals("<") || ch.equals("{");
  }
}
