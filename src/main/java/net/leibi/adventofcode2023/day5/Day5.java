package net.leibi.adventofcode2023.day5;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.LongStream;

public class Day5 {

    List<Long> seedList = new ArrayList<>();
    LookUpMap seed2SOILLookUpMap = new LookUpMap();
    LookUpMap soil2FertilizerMap = new LookUpMap();
    LookUpMap fertilizor2WaterMap = new LookUpMap();
    LookUpMap water2LightMap = new LookUpMap();
    LookUpMap light2TempMap = new LookUpMap();
    LookUpMap temp2HumidMap = new LookUpMap();
    LookUpMap humid2LocationMap = new LookUpMap();
    List<Long> tmpList = new ArrayList<>();

    Long getLowestLocationNumber(String input) {
        fillMaps(input);
        fillSeedList(input);

        return seedList.stream()
                .parallel()
                .map(seed2SOILLookUpMap::getMapping)
                .map(soil2FertilizerMap::getMapping)
                .map(fertilizor2WaterMap::getMapping)
                .map(water2LightMap::getMapping)
                .map(light2TempMap::getMapping)
                .map(temp2HumidMap::getMapping)
                .map(humid2LocationMap::getMapping)
                .min(Long::compareTo).orElseThrow();

    }

    Long getLowestLocationNumberFromSeedList(String input) {
        fillMaps(input);
        fillSeedList(input);

        return getCompleteSeedList()
                .parallel()
                .map(seed2SOILLookUpMap::getMapping)
                .map(soil2FertilizerMap::getMapping)
                .map(fertilizor2WaterMap::getMapping)
                .map(water2LightMap::getMapping)
                .map(light2TempMap::getMapping)
                .map(temp2HumidMap::getMapping)
                .map(humid2LocationMap::getMapping)
                .boxed()
                .min(Long::compareTo).orElseThrow();

    }

    void fillMap(String input, LookUpMap lookUpMap, String deliminatorString) {
        // get all lines between the deliminatorString and the next empty line
        var split = Arrays.stream(input.split("\n\n"))
                .filter(s -> s.startsWith(deliminatorString))
                .findFirst();
        if (split.isEmpty()) return;
        // now we can parse the lines
        split.get().split(":")[1].lines().filter(s -> !s.isEmpty()).forEach(lookUpMap::fill);


    }

    void fillSeedList(String input) {
        var first = input.lines().filter(line -> line.startsWith("seeds:")).findFirst();
        if (first.isEmpty()) return;

        seedList.addAll(Arrays
                .stream(first.get().split(":")[1]
                        .split(" "))
                .filter(s -> !s.isEmpty())
                .map(Long::valueOf)
                .toList());
    }

    private LongStream getCompleteSeedList() {

        var partition = Lists.partition(seedList, 2);
        return partition.stream()
                .flatMapToLong(x -> generateSeedsAsStream(x.getFirst(), x.getFirst() + x.getLast()));
    }

    private LongStream generateSeedsAsStream(Long start, Long end) {
        return LongStream.range(start, end + 1);
    }

    private void fillMaps(String input) {

        fillMap(input, seed2SOILLookUpMap, "seed-to-soil map:");
        fillMap(input, soil2FertilizerMap, "soil-to-fertilizer map:");
        fillMap(input, fertilizor2WaterMap, "fertilizer-to-water map:");
        fillMap(input, water2LightMap, "water-to-light map:");
        fillMap(input, light2TempMap, "light-to-temperature map:");
        fillMap(input, temp2HumidMap, "temperature-to-humidity map:");
        fillMap(input, humid2LocationMap, "humidity-to-location map:");
    }

    static class LookUpMap extends ArrayList<LookUpMap.MyMapEntry> {

        public void fill(String inputstring) {
            // 55 98 2
            var l = Arrays.stream(inputstring.split(" ")).filter(s -> !s.isEmpty()).toList();
            var m = new MyMapEntry(l);
            add(m);
        }

        Long getMapping(Long input) {
            // if input is a BigDecimal between any sourceStart and sourceStart+range
            // we return destStart + distance
            var destination = this.stream().map(myMapEntry -> myMapEntry.getDestination(input)).filter(Optional::isPresent).findFirst().orElse(Optional.empty());
            return destination.orElse(input);
        }

        record MyMapEntry(Long destStart, Long sourceStart, Long range) {
            public MyMapEntry(List<String> l) {
                this(Long.valueOf(l.get(0)), Long.valueOf(l.get(1)), Long.valueOf(l.get(2)));
            }

            public Optional<Long> getDestination(Long input) {
                if (input.compareTo(sourceStart) < 0 || input.compareTo(sourceStart + range) > 0)
                    return Optional.empty();

                return Optional.of(destStart + (input - sourceStart));
            }
        }

    }


}
