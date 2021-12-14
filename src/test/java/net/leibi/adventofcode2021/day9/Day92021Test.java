package net.leibi.adventofcode2021.day9;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import net.leibi.adventofcode2021.day9.Day92021.LowPoint;
import net.leibi.helpers.InputHelper;
import org.junit.jupiter.api.Test;

class Day92021Test {

  @Test
  void solveBonus() {
    assertThat(Day92021.solveBonus(Input.SHORT_INPUT)).isEqualTo(1134);
  }

  @Test
  void solveBonusLarge() {
    assertThat(Day92021.solveBonus(Input.LONG_INPUT)).isEqualTo(902880);
  }

  @Test
  void getBasinForLowPoint() {

    int[][] matrix = InputHelper.getIntMatrixFromInput(Input.SHORT_INPUT);
    List<LowPoint> lowPoints = Day92021.getLowPoints(matrix);
    List<LowPoint> basin = new ArrayList<>();
    assertThat(Day92021.getBasinForLowPoint(matrix,lowPoints.get(0), basin)).hasSize(3);//.contains(2,1,3);
    basin.clear();
    assertThat(Day92021.getBasinForLowPoint(matrix,lowPoints.get(1),basin)).hasSize(9);//.contains(4,3,2,1,0,4,2,1,2);
    basin.clear();
    assertThat(Day92021.getBasinForLowPoint(matrix,lowPoints.get(2),basin)).hasSize(14);//.contains(8,7,8,8,5,6,7,8,8,7,6,7,8);
    basin.clear();
    assertThat(Day92021.getBasinForLowPoint(matrix,lowPoints.get(3),basin)).hasSize(9);//.contains(8,6,7,8,6,5,6,7,8);

  }

  @Test
  void solve() {
    assertThat(Day92021.solve(Input.SHORT_INPUT)).isEqualTo(15);
  }

  @Test
  void solveLong() {
    assertThat(Day92021.solve(Input.LONG_INPUT)).isEqualTo(496);
  }

  @Test
  void getLowPoints() {
    int[][] matrix = InputHelper.getIntMatrixFromInput(Input.SHORT_INPUT);
    List<LowPoint> lowPoints = Day92021.getLowPoints(matrix);

    assertThat(lowPoints)
        .hasSize(4)
        .anySatisfy(lowPoint -> assertThat(lowPoint.value).isIn(1, 0, 5, 5));
  }

  @Test
  void parseInput() {

    int[][] matrix = InputHelper.getIntMatrixFromInput(Input.SHORT_INPUT);
    assertThat(matrix).hasDimensions(5,10);
    assertThat(matrix[0][0]).isEqualTo(2);
    assertThat(matrix[4][9]).isEqualTo(8);

  }
}
