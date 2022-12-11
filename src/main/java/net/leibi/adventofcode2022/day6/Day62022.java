package net.leibi.adventofcode2022.day6;

import java.util.Arrays;
import java.util.List;

public class Day62022 {
  static Integer getStartMarker(String s, int windowSize){
    var arr = Arrays.asList(s.split(""));
    for (int i = 0; i < arr.size()-windowSize; i++) {
      var candidate = arr.subList(i,i+windowSize);
      if(isStartMarker(candidate))
        return i+windowSize;
    }
  return null;
  }

  private static boolean isStartMarker(List<String> candidate) {
    return candidate.stream().distinct().toList().size() == candidate.size();
  }


}
