package net.leibi.adventofcode2021.day2;

import java.util.Arrays;
import java.util.List;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;


@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Day22021 {



  static int getResult(final String input){
    final List<Event> events = parseInput(input);
    return getHorizontalPosition(events) * getDepth(events);
  }

   static List<Event> parseInput(final String input) {
    return Arrays.stream(input.split("\\r?\\n")).map(Day22021::getEvent).toList();
  }

  private static int getHorizontalPosition(List<Event> events){
    int pos =0;
    for (Event event : events) {
      if(event.getDirection().equalsIgnoreCase("forward")){
        pos += event.getAmount();
      }
    }
    return pos;
  }

  private static int getDepth(List<Event> events) {
    int depth = 0;
    for (Event event : events) {
      if(event.getDirection().equalsIgnoreCase("up")){
        depth -= event.getAmount();
      }else if(event.getDirection().equalsIgnoreCase("down")){
        depth += event.getAmount();
      }
    }
    return depth;
  }

  private static Event getEvent(String s) {
    String[] splittedString = s.split(" ");
    assert (splittedString.length == 2);
    return Event.builder()
        .direction(splittedString[0])
        .amount(Integer.parseInt(splittedString[1]))
        .build();
  }

}
