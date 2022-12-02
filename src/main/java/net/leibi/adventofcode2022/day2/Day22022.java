package net.leibi.adventofcode2022.day2;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import net.leibi.helpers.InputHelper;

public class Day22022 {

  public static Integer score(final String input) {
    return getPairingsFromInput(input).stream().map(Pairing::score).reduce(0, Integer::sum);
  }

  private static List<Pairing> getPairingsFromInput(String input) {
    var result = new ArrayList<Pairing>();
    for (String s : InputHelper.getRowListFromInput(input)) {
      String[] array = s.split(" ");
      result.add(new Pairing(array[0], array[1]));
    }
    return result;
  }
  static List<Pairing> equivalents = List.of(new Pairing("A", "X"),
      new Pairing("B", "Y"),
      new Pairing("C", "Z")
  );

  static Map<String, String> beats = Map.of("C", "Y", "B", "X", "A", "Z");

  public static final int WIN_VALUE = 6;
  public static final int DRAW_VALUE = 3;

  // Rock: A, X - 1
  // Paper: B, Y - 2
  // Scissors: C, Z -3

  // Scissors > Paper > Rock > Scissors

  private record Pairing(String opponent, String me) {
    public Integer score() {
      switch (result()) {
        case WIN -> {
          return WIN_VALUE + value(me);
        }
        case DRAW -> {
          return DRAW_VALUE + value(me);
        }
        case LOSE -> {
          return value(me);
        }
      }
      throw new RuntimeException("Could not get score");
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
