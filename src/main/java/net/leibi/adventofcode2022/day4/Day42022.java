package net.leibi.adventofcode2022.day4;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import net.leibi.helpers.InputHelper;

public class Day42022 {

  static long getCompleteOverlaps(final String input){
    return getListOfPairs(input).stream().filter(ElfePair::hasCompleteOverlap).count();
  }

  static long getPartialOverlaps(final String input){
    return getListOfPairs(input).stream().filter(ElfePair::hasPartialOverlap).count();
  }

  static List<ElfePair> getListOfPairs(final String input) {
    return InputHelper.getRowListFromInput(input).stream().map(s -> s.split(","))
        .map(a -> new ElfePair(a[0], a[1])).toList();

  }

  record ElfePair(List<Integer> firstSection, List<Integer> secondSection) {

    public boolean hasPartialOverlap() {
      if(hasCompleteOverlap())
        return true;

      return firstSection.stream().filter(i -> secondSection.contains(i)).count() > 0;

    }

    Boolean hasCompleteOverlap(){
      return firstSection.containsAll(secondSection) || secondSection.containsAll(firstSection);
    }

    public ElfePair(String firstSection, String secondSection) {
      this(new ArrayList<>(), new ArrayList<>());
      this.firstSection.addAll(getIntegerListFromSectionString(firstSection));
      this.secondSection.addAll(getIntegerListFromSectionString(secondSection));

    }

    private List<Integer> getIntegerListFromSectionString(String sectionString) {
      String[] split = sectionString.split("-");
      return IntStream.range(Integer.parseInt(split[0]), Integer.parseInt(split[1])+1).boxed().toList();
    }
  }

}
