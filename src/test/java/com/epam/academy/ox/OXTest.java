package com.epam.academy.ox;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class OXTest {

    @Test
    public void shouldCreateCertainSizeBoard() {
        Board board = new Board(9);
        assertEquals(board.grid.length, 9);
    }

    @Test
    public void shouldPrintBoardCorrectly() {
        Board board = new Board(9);
        String expected = "1 2 3\n4 5 6\n7 8 9\n";

        String print = board.image();

        assertEquals(print,expected);
    }
}
