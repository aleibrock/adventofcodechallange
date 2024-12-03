package net.leibi.adventofcode2024.day3;

public record Mul(int x, int y) {

    public int prod() {
        return x * y;
    }
}
