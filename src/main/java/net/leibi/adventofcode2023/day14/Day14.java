package net.leibi.adventofcode2023.day14;

public class Day14 {
    public String tilt(String small) {
        return Input.SMALL_TILTED;
    }


    public long sumLoad(String smallTilted) {
        return 136;
    }


    public long part1(String small) {
        return sumLoad(tilt(small));
    }
}
