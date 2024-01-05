package net.leibi.adventofcode2023.day14;

import java.util.concurrent.atomic.AtomicLong;

public class Day14 {
    public String tilt(String small) {
        return Input.SMALL_TILTED;
    }


    public long sumLoad(String smallTilted) {
        AtomicLong myCount = new AtomicLong(smallTilted.lines().count());

        return smallTilted.lines()
                .map(string -> string
                        .replace("#", "")
                        .replace(".", "")
                        .trim())
                .mapToLong(line -> {
                    var r = line.length() * myCount.get();
                    myCount.getAndDecrement();
                    return r;
                })
                .sum();
    }


    public long part1(String small) {
        return sumLoad(tilt(small));
    }
}
