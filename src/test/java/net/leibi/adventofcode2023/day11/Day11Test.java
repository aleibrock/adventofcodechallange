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

    @Test
    void testGalaxyExtraction() {

        var expandedUniverse = day11.getExpandedUniverse(Input.SMALL);
        var galaxies = day11.getGalaxiesFromUniverse(expandedUniverse);

        assertThat(galaxies).hasSize(9).contains(new Day11.Galaxy(0, 4), new Day11.Galaxy(11, 5), new Day11.Galaxy(11, 0));

    }

}