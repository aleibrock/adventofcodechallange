package net.leibi.adventofcode2023.day12;

import java.util.Arrays;
import java.util.List;

public class Day12 {

    public Long getSumOfPossibilities(String input) {
        return input.lines().mapToLong(this::getPossibilitiesForRow).sum();
    }

    public Long getPossibilitiesForRow(String s) {
        // ?#?#?#?#?#?#?#? 1,3,1,6
        var split = s.split(" ");
        var list = Arrays.stream(split[1].split(",")).mapToInt(Integer::parseInt).boxed().toList();
        var row = new Springs(split[0], list);

        return row.getPossibilities();
    }


}
