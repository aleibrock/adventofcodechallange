package net.leibi.adventofcode2021.day5;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LineTest {

  @Test
  void testCtor(){

    Line line = new Line(1,2,3,4);
    assertThat(line.from).isEqualTo(new Line.Point(2,1));
    assertThat(line.to).isEqualTo(new Line.Point(4,3));

  }

}
