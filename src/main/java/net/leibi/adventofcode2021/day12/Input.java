package net.leibi.adventofcode2021.day12;

public class Input {

  public static final String SHORT_INPUT =
      """
      start-A
      start-b
      A-c
      A-b
      b-d
      A-end
      b-end
      """;

  public static final String SHORT_RESULT = """
      start,A,b,A,c,A,end
      start,A,b,A,end
      start,A,b,end
      start,A,c,A,b,A,end
      start,A,c,A,b,end
      start,A,c,A,end
      start,A,end
      start,b,A,c,A,end
      start,b,A,end
      start,b,end
      """;
}
