package com.epam.academy.ox;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class OXTest {
    Board board = new Board(9);

    @Test
    public void shouldCreateCertainSizeBoard() {
        assertEquals(board.grid.length, 9);
    }

    @Test
    public void shouldPrintBoardCorrectly() {
        String expected = "1 2 3\n4 5 6\n7 8 9\n";

        String image = board.image();

        assertEquals(image,expected);
    }

    @Test
    public void playerChoosesSlot() {
        Player player = new Player('X');

        int chosenSlot = player.chooseSlot();
        board.updateGrid(chosenSlot);

        assertEquals(board.grid[chosenSlot - 1], player.name);

    }
}
