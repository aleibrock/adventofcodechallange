package net.leibi.adventofcode2023.day14;

import net.leibi.helpers.InputHelper;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Day14Test {

    Day14 day14 = new Day14();

    @Test
    void testTilt() {
        assertThat(day14.tilt(Input.SMALL)).isEqualTo(net.leibi.adventofcode2023.day14.Input.SMALL_TILTED);
    }

    @Test
    void testTiltTest2() {
        assertThat(day14.tilt("""
                .#O
                ...
                OOO
                """))
                .isEqualTo("""
                        O#O
                        .OO
                        ...
                        """);
    }

    @Test
    void testCycleSmall() {
        assertThat(day14.cycle("""
                .#O
                ...
                OOO
                """, 1))
                .isEqualTo("""
                        .#.
                        ..O
                        OOO
                        """);
    }


    @Test
    void testSouth() {

        String input = """
                .#O
                ...
                OOO
                """;

        var c = InputHelper.getCharMatrixFromInput(input);
        Day14.tiltSouth(c);
        var res = Day14.getStringFromCharArray(c);

        assertThat(res)
                .isEqualTo("""
                        .#.
                        ..O
                        OOO
                        """);
    }

    @Test
    void testSouth2() {

        String input = """
                .#O
                OOO
                O..
                """;

        var c = InputHelper.getCharMatrixFromInput(input);
        Day14.tiltSouth(c);
        var res = Day14.getStringFromCharArray(c);

        assertThat(res)
                .isEqualTo("""
                        .#.
                        O.O
                        OOO
                        """);
    }

    @Test
    void testWest() {

        String input = """
                .#O
                ..O
                OOO
                """;

        var c = InputHelper.getCharMatrixFromInput(input);
        Day14.tiltWest(c);
        var res = Day14.getStringFromCharArray(c);

        assertThat(res)
                .isEqualTo("""
                        .#O
                        O..
                        OOO
                        """);
    }

    @Test
    void testWest2() {

        String input = """
                .#O
                ..O
                .OO
                """;

        var c = InputHelper.getCharMatrixFromInput(input);
        Day14.tiltWest(c);
        var res = Day14.getStringFromCharArray(c);

        assertThat(res)
                .isEqualTo("""
                        .#O
                        O..
                        OO.
                        """);
    }


    @Test
    void testEast() {

        String input = """
                .#O
                O..
                OO.
                """;

        var c = InputHelper.getCharMatrixFromInput(input);
        Day14.tiltEast(c);
        var res = Day14.getStringFromCharArray(c);

        assertThat(res)
                .isEqualTo("""
                        .#O
                        ..O
                        .OO
                        """);
    }

    @Test
    void testCycle() {

        assertThat(day14.cycle(Input.SMALL, 1)).isEqualTo("""
                .....#....
                ....#...O#
                ...OO##...
                .OO#......
                .....OOO#.
                .O#...O#.#
                ....O#....
                ......OOOO
                #...O###..
                #..OO#....
                """);

        assertThat(day14.cycle(Input.SMALL, 2)).isEqualTo("""
                .....#....
                ....#...O#
                .....##...
                ..O#......
                .....OOO#.
                .O#...O#.#
                ....O#...O
                .......OOO
                #..OO###..
                #.OOO#...O
                """);

        assertThat(day14.cycle(Input.SMALL, 3)).isEqualTo("""
                .....#....
                ....#...O#
                .....##...
                ..O#......
                .....OOO#.
                .O#...O#.#
                ....O#...O
                .......OOO
                #...O###.O
                #.OOO#...O
                """);

    }

    @Test
    void testCyclPerformancee() {
        assertThat(day14.cycle(Input.BIG, 100_000)).isNotBlank();
    }

    @Test
    void testLoad() {
        assertThat(day14.sumLoad(Input.SMALL_TILTED)).isEqualTo(136);
    }

    @Test
    void testLoadSmall() {
        assertThat(day14.sumLoad("OOOO.#.O..")).isEqualTo(5);
        assertThat(day14.sumLoad("""
                OOOO.#.O..
                OO..#....#
                """)).isEqualTo((5 * 2) + 2);
    }

    @Test
    void testPart1Small() {
        assertThat(day14.part1(Input.SMALL)).isEqualTo(136);
    }

    @Test
    @Disabled
    void testPart2Small() {
        assertThat(day14.part2(Input.SMALL)).isEqualTo(64);
    }

    @Test
    void testPart1Big() {
        assertThat(day14.part1(Input.BIG)).isEqualTo(103614L);
    }

    @Test
    @Disabled
    void testPart2Big() {
        assertThat(day14.part2(Input.BIG)).isEqualTo(103614L);
    }

}