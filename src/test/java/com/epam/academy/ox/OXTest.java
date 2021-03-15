package com.epam.academy.ox;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class OXTest {
    Player playerX = new Player('X');
    Player playerO = new Player('O');


    @Test
    public void shouldCreateCertainSizeBoard() {
        Game game = new Game();
        assertEquals(game.getBoard().length(), 9);
    }

    @Test
    public void shouldPrintBoardCorrectly() {
        Game game = new Game();
        String expected = "1 2 3\n4 5 6\n7 8 9\n";

        String image = game.getBoard().image();

        assertEquals(image,expected);
    }

    @Test
    public void playerXChoosesSlot() {
        Game game = new Game();
        game.getBoard().updateGrid(playerX, 5);

        assertEquals(game.getValueOnGivenSlot(4), playerX.name);
    }

    @Test
    public void shouldReturnWinnerX() {
        Game game = new Game();
        game.playerActs(playerX,1);
        game.playerActs(playerX,2);
        game.playerActs(playerX,3);

        Player winner = game.checkWinner();

        assertEquals(winner,playerX);
    }

    @Test
    public void shouldReturnWinnerO() {
        Game game = new Game();
        game.playerActs(playerO,1);
        game.playerActs(playerO,5);
        game.playerActs(playerO,9);

        Player winner = game.checkWinner();

        assertEquals(winner,playerO);
    }

    @Test
    public void shouldReturnNullIfThereISNoWinner() {
        Game game = new Game();
        game.playerActs(playerO,1);
        game.playerActs(playerX,5);
        game.playerActs(playerO,9);

        Player winner = game.checkWinner();

        assertNull(winner);
    }

    @Test
    public void shouldReturnTrueIfThereIsDraw() {
        Game game = new Game();
        game.playerActs(playerO,1);
        game.playerActs(playerO, 2);
        game.playerActs(playerX, 3);
        game.playerActs(playerX, 4);
        game.playerActs(playerX, 5);
        game.playerActs(playerO, 6);
        game.playerActs(playerO, 7);
        game.playerActs(playerX, 8);
        game.playerActs(playerX, 9);

        boolean draw = game.checkDraw();

        assertTrue(draw);
    }

    @Test
    public void gameShouldEndWhenDrawIs() {
        Game game = new Game();
        game.playerActs(playerO,1);
        game.playerActs(playerO, 2);
        game.playerActs(playerX, 3);
        game.playerActs(playerX, 4);
        game.playerActs(playerX, 5);
        game.playerActs(playerO, 6);
        game.playerActs(playerO, 7);
        game.playerActs(playerX, 8);
        game.playerActs(playerX, 9);

        assertTrue(game.isOver());

    }

    @Test
    public void gameShouldEndWhenWinnerIs() {
        Game game = new Game();
        game.playerActs(playerO,1);
        game.playerActs(playerO,5);
        game.playerActs(playerO,9);

        assertTrue(game.isOver());
    }
}
