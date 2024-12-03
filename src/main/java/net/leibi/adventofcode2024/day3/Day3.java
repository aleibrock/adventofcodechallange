package net.leibi.adventofcode2024.day3;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day3 {
  public long part1(String small) {
    return getValidMul(small).stream().mapToLong(Mul::prod).sum();
  }

  public List<Mul> getValidMul(String small) {
    final String regex = "mul\\((\\d+),(\\d+)\\)";
    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(small);
    List<Mul> muls = new ArrayList<>();

    while (matcher.find()) {
      int x = Integer.parseInt(matcher.group(1));
      int y = Integer.parseInt(matcher.group(2));
      muls.add(new Mul(x, y));
    }

    return muls;
  }
}
