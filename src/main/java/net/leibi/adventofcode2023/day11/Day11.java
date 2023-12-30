package net.leibi.adventofcode2023.day11;

import net.leibi.helpers.InputHelper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Day11 {
    public char[][] getExpandedUniverse(String small) {

        var expandedRows = small.lines().map(this::getExpandedRow).collect(Collectors.joining());
        return getExpandedColumns(expandedRows);
    }

    private char[][] getExpandedColumns(String expandedRows) {
        var array = InputHelper.getCharMatrixFromInput(expandedRows);
        var width = array[0].length;

        var indexList = getIndexList(width, array);

        //build new aray
        var newWidth = width + indexList.size();
        var chars = new char[array.length][newWidth];
        for (int i = 0; i < array.length; i++) {
            char[] currentRow = array[i];
            var newRow = new char[newWidth];
            for (int j =0 , nj = 0; j < currentRow.length; nj++,j++) {
                newRow[nj] = currentRow[j];
                if (indexList.contains(j)) {
                    newRow[nj + 1] = '.';
                    nj++;
                }
            }
            chars[i] = newRow;
        }
        return chars;
    }

    private ArrayList<Integer> getIndexList(int width, char[][] array) {
        var indexList = new ArrayList<Integer>();
        for (int i = 0; i < width; i++) {
            Character[] col = getColumn(array, i);
            if (Arrays.stream(col).noneMatch(c -> c.equals('#'))) {
                indexList.add(i);
            }
        }
        return indexList;
    }

    private Character[] getColumn(char[][] array, int index) {

        Character[] result = new Character[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = array[i][index];
        }
        return result;
    }

    private String getExpandedRow(String string) {

        if (string.contains("#")) return string + "\n";
        return string + "\n" + string + "\n";
    }
}
