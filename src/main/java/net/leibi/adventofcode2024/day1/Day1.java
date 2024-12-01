package net.leibi.adventofcode2024.day1;

import java.util.ArrayList;
import java.util.List;

public class Day1 {


    public long part1(String input) {
        var lists = getListOfListsFromInput(input);
        return getSumOfDistances(lists.get(0), lists.get(1));
    }


    public List<List<Integer>> getListOfListsFromInput(String input) {
        var left = new ArrayList<Integer>();
        var right = new ArrayList<Integer>();
        input.lines().forEach(line -> {
            final var split = line.split("\\s+");
            left.add(Integer.valueOf(split[0]));
            right.add(Integer.valueOf(split[1]));
        });

        return List.of(left, right);
    }

    public Integer getSumOfDistances(List<Integer> left, List<Integer> right) {
        if (left.size() != right.size()) throw new RuntimeException("list sizes differ");

        left.sort(Integer::compareTo);
        right.sort(Integer::compareTo);

        Integer sum = 0;
        for (var i = 0; i < left.size(); i++) {
            sum += Math.abs(left.get(i) - right.get(i));
        }

        return sum;
    }

}
