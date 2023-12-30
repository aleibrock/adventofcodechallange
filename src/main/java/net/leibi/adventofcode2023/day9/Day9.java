package net.leibi.adventofcode2023.day9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day9 {


    public Long getSumOfExtrapolatedValues(String input) {
        return input.lines().mapToLong(this::getExtrapolatedValuesFromHistory).sum();
    }

    public Long getExtrapolatedValuesFromHistory(String input) {
        var list = Arrays.stream(input.split(" ")).map(Long::parseLong).toList();

        List<List<Long>> history = getHistory(list);

        //IntStream.range(0,history.size()).mapToLong(index -> history.get(index).getLast()).

        Long extrapolated = 0L;
        for (int i = 0; i < history.size(); i++) {
            extrapolated = history.get(i).getLast() + extrapolated;
        }


        return list.getLast() + extrapolated;

    }

    private List<List<Long>> getHistory(List<Long> list) {
        var diffList = new ArrayList<Long>();
        for (int i = 0; i < list.size() - 1; i++) {
            var diff = list.get(i + 1) - list.get(i);
            diffList.add(diff);
        }
        if (diffList.stream().allMatch(x -> x.equals(0L))) {
            return new ArrayList<>();
        }
        var history = getHistory(diffList);
        history.add(diffList);
        return history;
    }
}
