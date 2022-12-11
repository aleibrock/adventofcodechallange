package net.leibi.adventofcode2022.day6;

import java.util.Arrays;
import java.util.List;

public class Day62022 {

  static final Integer WINDOWSIZE = 4;
  static Integer getStartMarker(String s){
    var arr = Arrays.asList(s.split(""));
    for (int i = 0; i < arr.size()-4; i++) {
      var candidate = arr.subList(i,i+4);
      if(isStartMarker(candidate))
        return i+4;
    }
  return null;
  }

  private static boolean isStartMarker(List<String> candidate) {
    return candidate.stream().distinct().toList().size() == candidate.size();
  }


}
