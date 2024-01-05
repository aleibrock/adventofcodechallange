package net.leibi.adventofcode2023.day14;

import net.leibi.helpers.InputHelper;

import java.util.concurrent.atomic.AtomicLong;

public class Day14 {
    public String tilt(String input) {

        final var charMatrixFromInput = InputHelper.getCharMatrixFromInput(input);
        tiltMirrors(charMatrixFromInput);

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

    static void tiltMirrors(char[][] charMatrixFromInput) {
        for (int row = 1; row < charMatrixFromInput.length; row++) {
            char[] currentRow = charMatrixFromInput[row];
            for (int col = 0; col < currentRow.length; col++) {
                // move the current item as high as it gets
                char node = charMatrixFromInput[row][col];
                if (node == 'O') {
                    charMatrixFromInput[row][col] = '.';
                    int tmpRow = row - 1;
                    while (tmpRow >= 0 && charMatrixFromInput[tmpRow][col] == '.') {
                        tmpRow--;
                    }
                    if (tmpRow != row) {
                        tmpRow +=1;
                        charMatrixFromInput[tmpRow][col] = 'O';
                    }
                }
            }
        }
    }

    private String getStringFromCharArray(char[][] charMatrixFromInput) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < charMatrixFromInput.length; i++) {
            sb.append(new String(charMatrixFromInput[i]));
            sb.append("\n");
        }
        return sb.toString();
    }
}
