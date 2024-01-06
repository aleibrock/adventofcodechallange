package net.leibi.adventofcode2023.day14;

import lombok.extern.slf4j.Slf4j;
import net.leibi.helpers.InputHelper;

import java.util.concurrent.atomic.AtomicLong;


@Slf4j
public class Day14 {
    public String tilt(String input) {

        final var charMatrixFromInput = InputHelper.getCharMatrixFromInput(input);
        tiltNorth(charMatrixFromInput);

        return getStringFromCharArray(charMatrixFromInput);
    }

    public String cycle(String input, long times) {
        final var charMatrixFromInput = InputHelper.getCharMatrixFromInput(input);

        for (long i = 0; i < times; i++) {
            if (i % 1_000_000 == 0)
                log.info("Cycle # {}", i);
            cycleMirrors(charMatrixFromInput);
        }
        return getStringFromCharArray(charMatrixFromInput);
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

    public long part2(String small) {
        return sumLoad(cycle(small, 1_000_000_000));
    }

    static void tiltSouth(char[][] charMatrixFromInput) {
        var tmpRow = 0;
        for (int row = charMatrixFromInput.length - 1; row >= 0; row--) {
            char[] currentRow = charMatrixFromInput[row];
            for (int col = 0; col < currentRow.length; col++) {
                // move the current item as high as it gets
                if (currentRow[col] == 'O') {
                    charMatrixFromInput[row][col] = '.';
                    tmpRow = row + 1;
                    while (tmpRow < charMatrixFromInput.length && charMatrixFromInput[tmpRow][col] == '.') {
                        tmpRow++;
                    }
                    tmpRow -= 1;
                    charMatrixFromInput[tmpRow][col] = 'O';
                }
            }
        }
    }

    static void tiltEast(char[][] charMatrixFromInput) {
        for (int row = 0; row < charMatrixFromInput.length; row++) {
            char[] currentRow = charMatrixFromInput[row];
            moveRight(currentRow);
        }
    }

    static void tiltWest(char[][] charMatrixFromInput) {
        for (int row = 0; row < charMatrixFromInput.length; row++) {
            char[] currentRow = charMatrixFromInput[row];
            moveLeft(currentRow);
        }
    }

    static void tiltNorth(char[][] charMatrixFromInput) {
        var tmpRow = 0;
        for (int row = 1; row < charMatrixFromInput.length; row++) {
            char[] currentRow = charMatrixFromInput[row];
            for (int col = 0; col < currentRow.length; col++) {
                // move the current item as high as it gets
                if (currentRow[col] == 'O') {
                    currentRow[col] = '.';
                    tmpRow = row - 1;
                    while (tmpRow >= 0 && charMatrixFromInput[tmpRow][col] == '.') {
                        tmpRow--;
                    }
                    if (tmpRow != row) {
                        tmpRow += 1;
                        charMatrixFromInput[tmpRow][col] = 'O';
                    }
                }
            }
        }
    }

    static String getStringFromCharArray(char[][] charMatrixFromInput) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < charMatrixFromInput.length; i++) {
            sb.append(new String(charMatrixFromInput[i]));
            sb.append("\n");
        }
        return sb.toString();
    }

    static void moveLeft(char[] currentRow) {
        var tmpCol = 0;
        for (int col = 0; col < currentRow.length; col++) {
            // move the left
            if (currentRow[col] == 'O') {
                currentRow[col] = '.';
                tmpCol = col - 1;
                while (tmpCol >= 0 && currentRow[tmpCol] == '.') {
                    tmpCol--;
                }
                if (tmpCol != col) {
                    tmpCol += 1;
                    currentRow[tmpCol] = 'O';
                }
            }
        }
    }

    static void moveRight(char[] currentRow) {

        var tmpCol = 0;
        for (int col = currentRow.length - 1; col >= 0; col--) {
            // move the left
            if (currentRow[col] == 'O') {
                currentRow[col] = '.';
                tmpCol = col + 1;
                while (tmpCol < currentRow.length && currentRow[tmpCol] == '.') {
                    tmpCol++;
                }
                if (tmpCol != col) {
                    tmpCol -= 1;
                    currentRow[tmpCol] = 'O';
                }
            }
        }
    }

    private void cycleMirrors(char[][] charMatrixFromInput) {
        tiltNorth(charMatrixFromInput);
        tiltWest(charMatrixFromInput);
        tiltSouth(charMatrixFromInput);
        tiltEast(charMatrixFromInput);
    }
}
