package net.leibi.adventofcode2021.day6;

import static net.leibi.helpers.InputHelper.getIntArrayFromString;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Day62021 {



  static List<Integer> getFishesFromInput(String input) {
    return Arrays.stream(getIntArrayFromString(input.trim(), ","))
        .boxed()
        .collect(Collectors.toList());
  }

   static BigDecimal getNumberOfFishes(List<Integer> inputIntegers,int countTo) {
    var map = inputIntegers
        .stream()
        .collect(Collectors.groupingBy(Integer::intValue))
        .entrySet()
        .stream()
        .collect(Collectors.toMap(Map.Entry::getKey, e -> new BigDecimal(e.getValue().size())));
    for (int i = 0; i < countTo; i++) {
      Map<Integer, BigDecimal> newMap = new HashMap<>();
      BigDecimal newFishes = BigDecimal.ZERO;
      for (Integer key : map.keySet()) {
        var value = map.get(key);
        if (key == 0) {
          newFishes = value;
          newMap.merge(6, value, BigDecimal::add);
        } else {
          newMap.merge(key - 1, value, BigDecimal::add);
        }
      }
      newMap.put(8, newFishes);
      map = newMap;
    }

    return map.values().stream().reduce(BigDecimal.ZERO, (BigDecimal::add));
  }

}
