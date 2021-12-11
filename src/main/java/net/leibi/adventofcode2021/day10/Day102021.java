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
        .map(row -> getScoreForIncompleteChar(getFirstWrongChar(row)))
        .mapToInt(i -> i)
        .sum();
  }

  static int solveSecondPart(final String input) {
    List<Integer> scoreList =
        InputHelper.getRowListFromInput(input).stream()
            .map(Day102021::getCompletionString)
            .mapToInt(Day102021::getScoreForCompletingString)
            .filter(i -> i > 0)
            .boxed()
            .sorted()
            .toList();

    // get the middle score
    return scoreList.get(scoreList.size()/2);
  }

  static int getScoreForCompletingString(String input) {
    int sum = 0;
    for (String ch : input.split("")) {
      sum *= 5;
      sum += getScoreForCompletionChar(ch);
    }
    return sum;
  }

  static String getCompletionString(String input){

    StringBuilder result = new StringBuilder();
    List<String> openingChars = new ArrayList<>();
    if(getFirstWrongCharOrFilOpeningChars(input,openingChars).equals("")){
      for (int i = openingChars.size() - 1; i >= 0; i--) {
        result.append(getCounterPart(openingChars.get(i)));
      }
    }

    return result.toString();
  }

  private static int getScoreForCompletionChar(String ch) {
    if (ch.equals(")")) return 1;
    if (ch.equals("]")) return 2;
    if (ch.equals("}")) return 3;
    if (ch.equals(">")) return 4;

    return 0;
  }

  private static String getCounterPart(String s) {
    if (s.equals("(")) return ")";
    if (s.equals("[")) return "]";
    if (s.equals("{")) return "}";
    if (s.equals("<")) return ">";

    return "";
  }

  static String getFirstWrongChar(final String input) {
    List<String> openingChars = new ArrayList<>();
    return getFirstWrongCharOrFilOpeningChars(input,openingChars);
  }

  static String getFirstWrongCharOrFilOpeningChars(final String input, List<String> openingChars){
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

  static int getScoreForIncompleteChar(String ch) {
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
