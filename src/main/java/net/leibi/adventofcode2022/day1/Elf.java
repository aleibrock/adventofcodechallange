package net.leibi.adventofcode2022.day1;

import java.util.List;

public record Elf(List<Integer> calories ) {

  public Integer totalCalories(){
    return calories.stream().reduce(0,Integer::sum);
  }

}
