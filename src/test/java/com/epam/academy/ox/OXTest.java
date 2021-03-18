package com.epam.academy.ox;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class OXTest {
    Player playerX = new Player('X');
    Player playerO = new Player('O');


    @Test
    public void shouldCreateCertainSizeBoard() {
        OXGame game = new OXGame();
        assertEquals(game.getBoard().length(), 9);
    }

    @Test
    public void playerXChoosesSlot() {
        OXGame game = new OXGame();
        game.playerActs(playerX, 5);

        assertEquals(game.getValueOnGivenSlot(4), playerX.name);
    }

    @Test
    public void shouldReturnWinnerX() {
        OXGame game = new OXGame();
        game.playerActs(playerX,1);
        game.playerActs(playerX,2);
        game.playerActs(playerX,3);

        boolean winner = game.checkWinner();

        assertTrue(winner);
    }


    @Test
    public void shouldReturnNullIfThereISNoWinner() {
        OXGame game = new OXGame();
        game.playerActs(playerO,1);
        game.playerActs(playerX,5);
        game.playerActs(playerO,9);

        boolean winner = game.checkWinner();

        assertFalse(winner);
    }

    @Test
    public void shouldReturnTrueIfThereIsDraw() {
        OXGame game = new OXGame();
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
        OXGame game = new OXGame();
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
        OXGame game = new OXGame();
        game.playerActs(playerO,1);
        game.playerActs(playerO,5);
        game.playerActs(playerO,9);

        assertTrue(game.isOver());
    }

    @Test
    public void playerChooseBookedSlot() {
        OXGame game = new OXGame();
        game.playerActs(playerO,1);
        game.playerActs(playerX,1);

        char valueOnGivenSlot = game.getValueOnGivenSlot(0);

        assertEquals(valueOnGivenSlot, 'O');
    }
}
