package com.epam.academy.ox;

import org.testng.annotations.Test;

import java.util.Arrays;

import static org.testng.Assert.*;

public class OXTest {
    Board board = new Board(9);
    Game game = new Game();
    Player playerX = new Player('X');
    Player playerO = new Player('O');


    @Test
    public void shouldCreateCertainSizeBoard() {
        assertEquals(board.length(), 9);
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

        assertEquals(board.getValueOnGivenSlot(4), playerX.name);
    }

    @Test
    public void shouldReturnWinnerX() {
        Board board = new Board(9);
        board.updateGrid(playerX,1);
        board.updateGrid(playerX,2);
        board.updateGrid(playerX,3);
        Player winner = game.checkWinner(board);
        assertEquals(winner,playerX);
    }

    @Test
    public void shouldReturnWinnerY() {
        Board board = new Board(9);
        board.updateGrid(playerO,1);
        board.updateGrid(playerO,5);
        board.updateGrid(playerO,9);
        Player winner = game.checkWinner(board);
        assertEquals(winner,playerO);
    }

    @Test
    public void shouldReturnNullIfThereISNoWinner() {
        Board board = new Board(9);
        board.updateGrid(playerO,1);
        board.updateGrid(playerX,5);
        board.updateGrid(playerO,9);
        Player winner = game.checkWinner(board);
        assertNull(winner);
    }

    @Test
    public void shouldReturnTrueIfThereIsDraw() {
        Board board = new Board(9);
        board.updateGrid(playerO,1);
        board.updateGrid(playerO, 2);
        board.updateGrid(playerX, 3);
        board.updateGrid(playerX, 4);
        board.updateGrid(playerX, 5);
        board.updateGrid(playerO, 6);
        board.updateGrid(playerO, 7);
        board.updateGrid(playerX, 8);
        board.updateGrid(playerX, 9);

        boolean draw = game.checkDraw(board);

        assertTrue(draw);
    }
}
