package com.epam.academy.ox;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class OXTest {

    @Test
    public void shouldCreateCertainSizeBoard() {
        Board board = new Board(9);
        assertEquals(board.grid.length, 9);
    }
}
