package net.leibi.adventofcode2022.day5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import net.leibi.helpers.InputHelper;

public class Day52022 {


  static List<Stack> getStacksFromInput(String input) {
    List<String> substrings = Arrays.stream(input.split("\\n\\n")).toList();
    assert (substrings.size() == 2);
    return getStacksFromSubInput(substrings.get(0));
  }


  static List<Move> getMovesFromInput(String input) {
    List<String> substrings = Arrays.stream(input.split("\\n\\n")).toList();
    assert (substrings.size() == 2);
    List<String> rowListFromInput = InputHelper.getRowListFromInput(substrings.get(1));
    return rowListFromInput.stream().map(s -> {
      String[] arr = s.split(" ");
      return new Move(Integer.parseInt(arr[1]), Integer.parseInt(arr[3]), Integer.parseInt(arr[5]));
    }).toList();
  }

  static List<Stack> getStacksFromSubInput(String s) {
    /*
                [A]
            [D] [Y]
        [N] [C] [X]
        [Z] [M] [P]
         1   2   3s
     */

    var stackList = new HashMap<Integer, Stack>();
    List<String> rowListFromInput = InputHelper.getRowListFromInput(s);
    for (String currentRow : rowListFromInput) {
      int idx = 0;
      for (String columnItem : currentRow.split(" ")) {
        if (columnItem.isEmpty() || columnItem.length() == 1) {
          idx++;
          continue;
        }
        // [D]
        final Character ch = columnItem.charAt(1);
        stackList
            .computeIfAbsent((idx) / 3, k -> new Stack(k, new ArrayList<>()))
            .crates.add(ch);
        idx += 3;
      }
    }
    return stackList.values().stream().toList();

  }

  record Stack(int StackNumber, List<Character> crates) {

    Optional<Character> getTopCrate() {
      if (crates.isEmpty()) {
        return Optional.empty();
      }
      return Optional.of(crates.get(0));
    }

  }

  record Move(int amount, int from, int to) {

  }

}
