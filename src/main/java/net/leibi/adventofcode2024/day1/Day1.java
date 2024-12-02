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

        int sum = 0;
        for (var i = 0; i < left.size(); i++) {
            sum += Math.abs(left.get(i) - right.get(i));
        }

        return sum;
    }

    public long part2(String input) {

        var lists = getListOfListsFromInput(input);
        int[] rightArray = lists.get(1).stream().mapToInt(Integer::intValue).toArray();
        var scores = getSimilarityScores(lists.get(0), rightArray);

        return scores.stream().mapToLong(i -> i).sum();
    }

    private List<Long> getSimilarityScores(List<Integer> left, int[] right) {

        var scores = new ArrayList<Long>();


        for (var currentNumber : left) {
            scores.add(getCountOfOccurancesOfNumberInList(right, currentNumber) * currentNumber);
        }
        return scores;
    }

    private static long getCountOfOccurancesOfNumberInList(int[] right, int i) {
        long cnt = 0;
        for (int integer : right) {
            if (i == integer) cnt++;
        }
        return cnt;
    }
}
