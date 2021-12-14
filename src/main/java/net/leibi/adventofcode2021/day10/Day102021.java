package net.leibi.adventofcode2021.day10;

import java.math.BigInteger;
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
    List<BigInteger> scoreList =
        InputHelper.getRowListFromInput(input).stream()
            .map(Day102021::getCompletionString)
            .filter(string -> !string.isBlank())
            .map(Day102021::getScoreForCompletingString)
            .filter(i -> i.compareTo(BigInteger.ZERO) > 0)
            .sorted()
            .toList();

     // get the middle score
    return scoreList.get(scoreList.size()/2).intValue();
  }

  static BigInteger getScoreForCompletingString(String input) {
    if(input.isBlank()) return BigInteger.valueOf(-1);
    BigInteger sum = BigInteger.ZERO;
    for (String ch : input.split("")) {
      sum = sum.multiply( BigInteger.valueOf(5));
      sum = sum.add(getScoreForCompletionChar(ch));
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

  private static BigInteger getScoreForCompletionChar(String ch) {
    if (ch.equals(")")) return BigInteger.valueOf(1);
    if (ch.equals("]")) return BigInteger.valueOf(2);
    if (ch.equals("}")) return BigInteger.valueOf(3);
    if (ch.equals(">")) return BigInteger.valueOf(4);

    return BigInteger.ZERO;
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
    assert(openingChars.isEmpty());
    for (String ch : input.split("")) {
      if (isOpeningChar(ch)) {
        openingChars.add(ch);
      } else {
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
