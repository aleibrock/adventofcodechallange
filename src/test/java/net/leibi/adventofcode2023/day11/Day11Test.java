package net.leibi.adventofcode2023.day11;

import net.leibi.helpers.InputHelper;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Day11Test {

    public static final Day11 day11 = new Day11();

    @Test
    void testExandUniverse() {

        String expectedString = """
                ....#........
                .........#...
                #............
                .............
                .............
                ........#....
                .#...........
                ............#
                .............
                .............
                .........#...
                #....#.......
                """;

        var charMatrixFromInput = InputHelper.getCharMatrixFromInput(expectedString);

        var expandedUniverse = day11.getExpandedUniverse(Input.SMALL);
        assertThat(expandedUniverse).isEqualTo(charMatrixFromInput);

    }

}