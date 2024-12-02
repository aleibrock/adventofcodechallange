package net.leibi.adventofcode2023.day3;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class Day3Test {

    private final Day3 day3 = new Day3();


    @Test
    void getSumOfPartNummbers_Small() {
        assertThat(day3.getSumOfPartNummbers(Input.SMALL)).isEqualTo(4361);
    }

    @Test
    void getSumOfPartNummbers_Big() {
        assertThat(day3.getSumOfPartNummbers(Input.BIG)).isEqualTo(536108);
    }

    @Test
    void testGetMatrixEntriesFromLine() {
        assertThat(day3.getMatrixEntriesFromLine("467..114..", 0))
                .isEqualTo(List.of(
                        new Day3.MatrixEntry(0, 2, 0, 467, false, "467"),
                        new Day3.MatrixEntry(5, 7, 0, 114, false, "114")));


    }

    @Test
    void testGetMatrixEntriesFromLine2() {
        assertThat(day3.getMatrixEntriesFromLine("..819...*819.", 0))
                .isEqualTo(List.of(
                        new Day3.MatrixEntry(2, 4, 0, 819, false, "819"),
                        new Day3.MatrixEntry(8, 8, 0, -1, true, "*"),
                        new Day3.MatrixEntry(9, 11, 0, 819, false, "819")));


    }

    @Test
    void testGetMatrixEntriesFromLine4() {
        assertThat(day3.getMatrixEntriesFromLine(".....+.58.", 0))
                .isEqualTo(List.of(
                        new Day3.MatrixEntry(5, 5, 0, -1, true, "+"),
                        new Day3.MatrixEntry(7, 8, 0, 58, false, "58")));


    }

    @Test
    void testGetMatrixEntriesFromLine3() {
        assertThat(day3.getMatrixEntriesFromLine("+617*......", 0))
                .isEqualTo(List.of(
                        new Day3.MatrixEntry(0, 0, 0, -1, true, "+"),
                        new Day3.MatrixEntry(1, 3, 0, 617, false, "617"),
                        new Day3.MatrixEntry(4, 4, 0, -1, true, "*")));


    }

    @Test
    void testIsPart() {
        var p1 = new Day3.MatrixEntry(0, 2, 1, 467, false, "467");
        var p2 = new Day3.MatrixEntry(5, 7, 1, 114, false, "114");
        var entries = day3.getMatrixEntriesFromInput(Input.SMALL);
        assertThat(day3.isPart(p1, entries)).isTrue();
        assertThat(day3.isPart(p2, entries)).isFalse();
    }

    @Test
    void testAll() {
        var entries = day3.getMatrixEntriesFromInput(Input.SMALL);
        for (Day3.MatrixEntry entry : entries) {
            if (entry.number() == 114 || entry.number() == 58 || entry.isSymbol()) {
                System.out.println("entry should be false " + entry);
                assertThat(day3.isPart(entry, entries)).isFalse();
            } else {
                System.out.println("entry should be true " + entry);
                assertThat(day3.isPart(entry, entries)).isTrue();
            }
        }

    }

    @Test
    void testParts_small() {
        var entries = day3.getMatrixEntriesFromInput(Input.SMALL);
        var parts = day3.getParts(entries);
        assertThat(parts)
                .isNotEmpty()
                .allSatisfy(p -> assertThat(p.isSymbol()).isFalse())
                .allSatisfy(p -> assertThat(Integer.valueOf(p.rawString())).isEqualTo(p.number()))
                .allSatisfy(p -> assertThat(p.xTo() - p.xFrom() + 1).isEqualTo(p.rawString().length()))
        ;
    }

    @Test
    void testParts_big() {
        var entries = day3.getMatrixEntriesFromInput(Input.BIG);
        var parts = day3.getParts(entries);
        assertThat(parts)
                .isNotEmpty()
                .allSatisfy(p -> assertThat(p.isSymbol()).isFalse())
                .allSatisfy(p -> assertThat(Integer.valueOf(p.rawString())).isEqualTo(p.number()))
                .allSatisfy(p -> assertThat((p.xTo() - p.xFrom() + 1)).isEqualTo(p.rawString().length()))
        ;
    }

    @Test
    void testSymbols() {
        var allEntries = day3.getMatrixEntriesFromInput(Input.BIG);
        var parts = day3.getParts(allEntries);
        var symbols = allEntries.stream().filter(Day3.MatrixEntry::isSymbol).toList();

        var noPart = allEntries.stream()
                .filter(p -> !parts.contains(p))
                .filter(p -> !symbols.contains(p))
                .toList();

        assertThat(noPart).isNotEmpty();
        assertThat(symbols.size() + parts.size() + noPart.size()).isEqualTo(allEntries.size());

        var l = new ArrayList<Day3.MatrixEntry>(allEntries.size());
        l.addAll(parts);
        l.addAll(symbols);
        l.addAll(noPart);
        assertThat(allEntries).allSatisfy(e -> assertThat(l).contains(e));
        assertThat(l).allSatisfy(e -> assertThat(allEntries).contains(e));


        assertThat(symbols)
                .isNotEmpty()
                .allSatisfy(p -> assertThat(p.isSymbol()).isTrue())
                .allSatisfy(p -> assertThat(p.number()).isEqualTo(-1))
                .allSatisfy(p -> assertThat((p.xTo() - p.xFrom())).isZero())
        ;
    }

    @Test
    void testSubset() {
        String s = """
                ............................................411.....................363..134.........463.775..........................506...................
                ......429...836..$............../..960........*.............+..........*...=....381.....*........67......426.....=..../...304...............
                """;
        var allEntries = day3.getMatrixEntriesFromInput(s);
        var parts = day3.getParts(allEntries);
        var symbols = allEntries.stream().filter(Day3.MatrixEntry::isSymbol).toList();

        var noPart = allEntries.stream()
                .filter(p -> !parts.contains(p))
                .filter(p -> !symbols.contains(p))
                .toList();

        assertThat(noPart).isNotEmpty();
        assertThat(symbols.size() + parts.size() + noPart.size()).isEqualTo(allEntries.size());
    }

    @Test
    @Disabled
    void testConjoinedNumbers() {
        var s = """
                ..313*820...666/.
                """;
        var allEntries = day3.getMatrixEntriesFromInput(s);
        var parts = day3.getParts(allEntries);
        var symbols = allEntries.stream().filter(Day3.MatrixEntry::isSymbol).toList();

        var noPart = allEntries.stream()
                .filter(p -> !parts.contains(p))
                .filter(p -> !symbols.contains(p))
                .toList();

        assertThat(noPart).isNotEmpty();
        assertThat(symbols.size() + parts.size() + noPart.size()).isEqualTo(allEntries.size());
    }

}