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

        assertThat(galaxies).hasSize(9).contains(new Day11.Galaxy(0, 4),
                new Day11.Galaxy(11, 5),
                new Day11.Galaxy(11, 0));

    }

    @Test
    void testGalaxyPairs() {
        var expandedUniverse = day11.getExpandedUniverse(Input.SMALL);
        var galaxies = day11.getGalaxiesFromUniverse(expandedUniverse);
        assertThat(day11.getGalaxyPairs(galaxies)).hasSize(36);
    }

    @Test
    void testDistancInGalaxyPair() {
        Day11.GalaxyPair galaxyPair = new Day11.GalaxyPair(new Day11.Galaxy(1, 2), new Day11.Galaxy(3, 4));
        assertThat(galaxyPair.getDistance()).isEqualTo(4);
    }

    @Test
    void testSumOfShortestPaths() {
        assertThat(day11.getSumOfShortestPaths(Input.SMALL)).isEqualTo(374);
    }

    @Test
    void testSumOfShortestPathsBig() {
        assertThat(day11.getSumOfShortestPaths(Input.BIG)).isEqualTo(9565386);
    }

}