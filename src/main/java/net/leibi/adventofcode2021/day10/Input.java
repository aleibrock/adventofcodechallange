package net.leibi.adventofcode2021.day10;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Input {

  public static final String SHORT_INPUT = """
      [({(<(())[]>[[{[]{<()<>>
      [(()[<>])]({[<{<<[]>>(
      {([(<{}[<>[]}>{[]{[(<()>
      (((({<>}<{<{<>}{[]{[]{}
      [[<[([]))<([[{}[[()]]]
      [{[{({}]{}}([{[{{{}}([]
      {<[[]]>}<{[{[{[]{()[[[]
      [<(<(<(<{}))><([]([]()
      <{([([[(<>()){}]>(<<{{
      <{([{{}}[<[[[<>{}]]]>[]]
      """;

  public static final String SHORT_INPUT_LINE1 = "{([(<{}[<>[]}>{[]{[(<()>";
  public static final String SHORT_INPUT_LINE2 = "[[<[([]))<([[{}[[()]]]";
  public static final String SHORT_INPUT_LINE3 = "[{[{({}]{}}([{[{{{}}([]";
  public static final String SHORT_INPUT_LINE4 = "[<(<(<(<{}))><([]([]()";
  public static final String SHORT_INPUT_LINE5 = "<{([([[(<>()){}]>(<<{{";

}
