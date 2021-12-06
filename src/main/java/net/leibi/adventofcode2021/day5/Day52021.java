package net.leibi.adventofcode2021.day5;

import static net.leibi.helpers.InputHelper.getRowListFromInput;

import java.util.ArrayList;
import java.util.List;

public class Day52021 {

  List<Line> getLinesFromInput(final String input) {
    List<Line> lines = new ArrayList<>();
    List<String> rowList = getRowListFromInput(input);
    for (String row : rowList) {
      String[] points = row.split("->");
      String[] from = points[0].split(",");
      String[] to = points[1].split(",");
      Line line =
          new Line(
              Integer.parseInt(from[0].trim()),
              Integer.parseInt(from[1].trim()),
              Integer.parseInt(to[0].trim()),
              Integer.parseInt(to[1].trim()));
      lines.add(line);
    }

    return lines;
  }
}
