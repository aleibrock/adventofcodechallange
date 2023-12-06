package net.leibi.adventofcode2023.day1;

import lombok.extern.slf4j.Slf4j;

import java.util.stream.IntStream;

@Slf4j
public class Day1 {
    public Integer getSumOfCalibrationValues(String small) {
        return small
                .lines()
                .map(this::getCalibrationValue)
                .flatMapToInt(IntStream::of)
                .sum();
    }

    private Integer getCalibrationValue(String line) {
        //1abc2
        var numbers = line.chars()
                .filter(i -> i > 48 && i <= 57) // numbers
                .map(i -> i - 48)
                .toArray();
        log.info("{} -> {}: {}", line, numbers, numbers.length);
        return numbers[0] * 10 + numbers[numbers.length - 1];
    }
}
