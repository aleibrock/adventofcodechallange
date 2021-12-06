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
    assertThat(board.getBoardContent()).isNotEmpty();
    assertThat(board.getBoardContent()[0][0]).isEqualTo(22);
    assertThat(board.getBoardContent()[4][4]).isEqualTo(19);

    for(int i=0;i<5;i++){
      for(int j=0;j<5;j++){
        assertThat(board.getMarkedBoard()[i][i]).isFalse();
      }
    }

  }

   @Test
  void markNumberOnBoard() {
     final String input = """
        22 13 17 11  0
         8  2 23  4 24
        21  9 14 16  7
         6 10  3 18  5
         1 12 20 15 19
        """;
     Board board = new Board(input);

     board.markNumberOnBoard(23);
     assertThat(board.getLastNumberMarked()).isEqualTo(23);
     assertThat(board.getMarkedBoard()[1][2]).isTrue();
     assertThat(board.getMarkedBoard()[0][0]).isFalse();


     board.markNumberOnBoard(99);
     assertThat(board.getLastNumberMarked()).isEqualTo(-1);
     assertThat(board.getMarkedBoard()[1][2]).isTrue();
     assertThat(board.getMarkedBoard()[0][0]).isFalse();
  }

  @Test
  void isBoardWinning() {

    final String input = """
        22 13 17 11  0
         8  2 23  4 24
        21  9 14 16  7
         6 10  3 18  5
         1 12 20 15 19
        """;
    Board board = new Board(input);
    assertThat(board.isBoardWinning()).isFalse();
    board.markNumberOnBoard(21);
    assertThat(board.isBoardWinning()).isFalse();
    board.markNumberOnBoard(9);
    assertThat(board.isBoardWinning()).isFalse();
    board.markNumberOnBoard(14);
    assertThat(board.isBoardWinning()).isFalse();
    board.markNumberOnBoard(16);
    assertThat(board.isBoardWinning()).isFalse();
    board.markNumberOnBoard(4);
    assertThat(board.isBoardWinning()).isFalse();
    board.markNumberOnBoard(7);
    assertThat(board.isBoardWinning()).isTrue();
  }
}
