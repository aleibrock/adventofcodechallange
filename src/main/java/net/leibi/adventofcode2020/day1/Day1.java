package net.leibi.adventofcode2020.day1;

import static net.leibi.helpers.InputHelper.getIntegerListFromInput;

import java.util.List;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Day1 {

  public static Integer getProductOfNumbersAddingUpTo2020FromInput() {

    List<Integer> inputInts = getIntegerListFromInput(Input.getINPUT());

    for (Integer integer1 : inputInts) {
      for (Integer integer2 : inputInts) {
        if (Input.getTARGET() == integer1 + integer2) {
          return integer1 * integer2;
        }
      }
    }
    return null;
  }

  public static Integer getProductOfThreeNumbersAddingUpTo2020FromInput() {

    List<Integer> inputInts = getIntegerListFromInput(Input.getINPUT());

    for (Integer integer1 : inputInts) {
      for (Integer integer2 : inputInts) {
        for (Integer integer3 : inputInts) {
          if (Input.getTARGET() == integer1 + integer2 + integer3) {
            return integer1 * integer2 * integer3;
          }
        }
      }
    }
    return null;
  }
}
