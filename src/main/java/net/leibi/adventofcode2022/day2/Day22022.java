package net.leibi.adventofcode2022.day2;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import net.leibi.helpers.InputHelper;

public class Day22022 {

  public static Integer score(final String input) {
    return getPairingsFromInput(input).stream().map(Pairing::score).reduce(0, Integer::sum);
  }

  public static Integer scorePart2(final String input) {
    return getPairingsFromInput(input).stream().map(Pairing::scorePart2).reduce(0, Integer::sum);
  }

  private static List<Pairing> getPairingsFromInput(String input) {
    var result = new ArrayList<Pairing>();
    for (String s : InputHelper.getRowListFromInput(input)) {
      String[] array = s.split(" ");
      result.add(new Pairing(array[0], array[1]));
    }
    return result;
  }
  static List<Pairing> equivalents = List.of(
      new Pairing("A", "X"),
      new Pairing("B", "Y"),
      new Pairing("C", "Z")
  );

  private static final Map<String, String> beats = Map.of(
      "C", "Y",  //Scissors ->  Paper
      "B", "X",     //Paper -> Rock
      "A", "Z",     // Rock -> Scissors
      "X", "C",     // Rock -> Scissors
      "Y", "A",     // Paper -> Rock
      "Z", "B");     // Scissors -> Paper

  private static final int WIN_VALUE = 6;
  private static final int DRAW_VALUE = 3;
  private record Pairing(String opponent, String me) {
    public Integer score() {
      Integer innerScore = innerScore(result(), me);
      if (innerScore != null) {
        return innerScore;
      }
      throw new RuntimeException("Could not get score");
    }

    private Integer innerScore(resultEnum result, String myDraw) {
      switch (result) {
        case WIN -> {
          return WIN_VALUE + value(myDraw);
        }
        case DRAW -> {
          return DRAW_VALUE + value(myDraw);
        }
        case LOSE -> {
          return value(myDraw);
        }
      }
      return null;
    }

    public Integer scorePart2() {
      var expectedResult = getExpectedResult();
      var myDraw = getDrawtoReceiveResult(expectedResult, opponent);
      return innerScore(expectedResult, myDraw);
    }

    private String getDrawtoReceiveResult(resultEnum expectedResult, String opponent) {
      switch (expectedResult){
        case LOSE -> {return beats.get(opponent);}
        case DRAW -> {
          return equivalents.stream().filter(pairing -> pairing.opponent.equals(opponent)).map(Pairing::me).findFirst().orElseThrow();
        }
        case WIN -> {
          return beats
              .entrySet()
              .stream()
              .filter(entry -> entry.getValue().equals(opponent))
              .map(Map.Entry::getKey).findFirst().orElseThrow(() -> new RuntimeException("can not find counterpart to " + opponent));
        }
      }
      throw new RuntimeException("Could not get my draw");
    }

    private resultEnum getExpectedResult() {
      switch (me) {
        case "X" -> {
          return resultEnum.LOSE;
        }
        case "Y" -> {
          return resultEnum.DRAW;
        }
        case "Z" -> {
          return resultEnum.WIN;
        }
        default -> throw new RuntimeException("not supported: " + me);
      }
    }

    private int value(String me) {
      switch (me) {
        case "X" -> {
          return 1;
        }
        case "Y" -> {
          return 2;
        }
        case "Z" -> {
          return 3;
        }
        default -> throw new RuntimeException("not supported: " + me);
      }
    }

    private resultEnum result() {
      if (equivalents.contains(this)) return resultEnum.DRAW;
      if(beats.get(opponent).equals(me)) return resultEnum.LOSE;
      return resultEnum.WIN;
    }

    enum resultEnum {
      WIN,
      LOSE,
      DRAW
    }
  }

}
