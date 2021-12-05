package net.leibi.adventofcode2021.day4;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class BoardTest {

  @Test
  void testCtor(){
    final String input = """
        22 13 17 11  0
         8  2 23  4 24
        21  9 14 16  7
         6 10  3 18  5
         1 12 20 15 19
        """;
    Board board = new Board(input);
    assertThat(board).isNotNull();
    assertThat(board.boardContent).isNotEmpty();
    assertThat(board.boardContent[0][0]).isEqualTo(22);
    assertThat(board.boardContent[4][4]).isEqualTo(19);
  }

  @Test
  void getBoardContent() {
  }

  @Test
  void markNumberOnBoard() {
  }

  @Test
  void isBoardWinning() {
  }
}
