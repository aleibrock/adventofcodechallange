package net.leibi.adventofcode2023.day8;

public record MazeItem(String from, String right, String left) {
    public MazeItem(String row) {
        //AAA = (BBB, CCC)
        this(getFrom(row), getLeft(row), getRight(row));
    }

    private static String getLeft(String row) {
        return row.split("=")[1].split(",")[1].substring(1, 4).trim();
    }

    private static String getRight(String row) {
        return row.split("=")[1].split(",")[0].substring(2).trim();
    }

    private static String getFrom(String row) {
        return row.split("=")[0].trim();
    }
}
