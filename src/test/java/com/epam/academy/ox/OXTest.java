package com.epam.academy.ox;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class OXTest {
    Board board = new Board(9);
    Game game = new Game();
    Player playerX = new Player('X');
    Player playerY = new Player('Y');


    @Test
    public void shouldCreateCertainSizeBoard() {
        assertEquals(board.grid.length, 9);
    }

    @Test (priority = 1)
    public void shouldPrintBoardCorrectly() {
        String expected = "1 2 3\n4 5 6\n7 8 9\n";

        String image = board.image();

        assertEquals(image,expected);
    }

    @Test (priority = 2)
    public void playerXChoosesSlot() {
        board.updateGrid(playerX, 5);

        assertEquals(board.grid[4], playerX.name);
    }

    @Test (priority = 3)
    public void shouldReturnWinner() {
        board.updateGrid(playerX,1);
        board.updateGrid(playerX,2);
        board.updateGrid(playerX,3);
        Player winner = game.checkWinner();
        assertEquals(playerX,winner);
    }
}
