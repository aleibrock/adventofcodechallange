package net.leibi.adventofcode2022.day5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import net.leibi.helpers.InputHelper;

public class Day52022 {

  static String getTopCratesAfterMove(String input){
    Stacks stacks = getStacksFromInput(input);
    List<Move> moves = getMovesFromInput(input);

    for (Move move : moves) {
      stacks.applyMove(move);
    }

    return stacks.getTopCrates();

  }

  static Stacks getStacksFromInput(String input) {
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

  static Stacks getStacksFromSubInput(String s) {
    /*
                [A]
            [D] [Y]
        [N] [C] [X]
        [Z] [M] [P]
         1   2   3s
     */

    var stackList = new HashMap<Integer, Stack>();
    List<String> rowListFromInput = InputHelper.getRowListFromInput(s);

    rowListFromInput = enhanceRowList(rowListFromInput);

    for (String currentRow : rowListFromInput) {
      int idx = 0;
      for (String columnItem : currentRow.split(" ")) {
        if (columnItem.isEmpty() || columnItem.length() == 1 || columnItem.equals("[-]")) {
          idx++;
          continue;
        }
        // [D]
        final Character ch = columnItem.charAt(1);
        stackList
            .computeIfAbsent(idx, k -> new Stack(k, new ArrayList<>()))
            .crates.add(ch);
        idx++;
      }
    }
    return new Stacks(new ArrayList<>(stackList.values()));
  }

  private static List<String> enhanceRowList(List<String> rowListFromInput) {
    List<String> newList = new ArrayList<>();
    for (String currentRow : rowListFromInput) {
     newList.add( currentRow
         .replace("   ", "[-]")
         .replace("][", "] [")
         .replace("  ", " ")
     );
    }
    return newList;
  }

  record Stack(int StackNumber, List<Character> crates) {

    public void add(Optional<Character> topCrate) {
      if (topCrate.isPresent()) {
        crates.add(0, topCrate.get());
      }
    }

    public void removeTopCrate() {
      if(crates.size() > 0) {
        crates.remove(0);
      }
    }

    Optional<Character> getTopCrate() {
      if (crates.isEmpty()) {
        return Optional.empty();
      }
      return Optional.of(crates.get(0));
    }

  }

  record Move(int amount, int from, int to) {

    Move(int amount, int from, int to){
      this.amount = amount;
      this.from = from-1;
      this.to = to-1;
    }

  }

  record Stacks(List<Stack> stacks) {

    public Optional<Character> getTopCrate(int index) {
      return stacks.get(index).getTopCrate();
    }

    public String getTopCrates() {
      StringBuilder result = new StringBuilder();
      for (Stack stack : stacks) {
        if(stack.getTopCrate().isPresent()) {
          result.append(stack.getTopCrate().get());
        }
      }
      return result.toString();
    }

    long size() {
      return stacks.size();
    }

    Stack get(int index) {
      while (index > stacks.size() - 1) {
        stacks.add(new Stack(stacks.size(), new ArrayList<>()));
      }
      return stacks.get(index);
    }

    void applyMove(Move move) {
      for (int i = 0; i <move.amount; i++) {
        get(move.to).add(getTopCrate(move.from));
        stacks.get(move.from).removeTopCrate();
      }
    }

  }

}
