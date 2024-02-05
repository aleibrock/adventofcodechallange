package net.leibi.adventofcode2023.day12;


import java.util.*;

public record Springs(String pattern, List<Integer> brokenSprings) {

    public Long getPossibilities() {
        var possibilities = getAllPossibilites().stream().filter(string -> !string.contains("?")).distinct().toList();

        var patternLists = possibilities.parallelStream()
                .map(this::getHashLists)
                .filter(list -> list.size() == brokenSprings.size())
                .filter(this::listPatternMatchesBrokenSprings)
                .toList();


        return (long) patternLists.size();
    }

    Set<String> getAllPossibilites() {
        final var qmlist = getIndicesOfQM();
        return replaceAtIndex(pattern, qmlist, 0);

    }

    private boolean listPatternMatchesBrokenSprings(List<String> strings) {
        boolean b = true;
        if(strings.size() != brokenSprings.size()) return false;

        for (int i = 0; i < brokenSprings.size(); i++) {
            if(!b) break;
            b = b && (strings.get(i).length() == brokenSprings.get(i));
        }

        return b;
    }

    private List<String> getHashLists(String string) {
        return Arrays.stream(string.split("(?<=(.))(?!\\1)")).filter(list -> list.contains("#")).toList();
    }

    private Set<String> replaceAtIndex(String pattern, List<Integer> qmlist, int i) {

        var set = new HashSet<String>();
    
        if (i == qmlist.size()) {
            set.add(pattern);
            return set;
        }
    
        int index = qmlist.get(i);
        var x = replaceChar(pattern, '#', index);
        var y = replaceChar(pattern, '.', index);
    
        set.addAll(replaceAtIndex(x, qmlist, i + 1));
        set.addAll(replaceAtIndex(y, qmlist, i + 1));
    
        return set;
    
    }
    


    private List<Integer> getIndicesOfQM() {
        int c = 0;
        int lastIndex = -1;
        var set = new ArrayList<Integer>();
        while (c < pattern.length()) {
            lastIndex = pattern.indexOf('?', lastIndex + 1);
            if (lastIndex != -1) {
                set.add(lastIndex);
            }
            c++;
        }
        return set;
    }


    private String replaceChar(String str, char ch, int index) {
        char[] chars = str.toCharArray();
        chars[index] = ch;
        return String.valueOf(chars);
    }

}
