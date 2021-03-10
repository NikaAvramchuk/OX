package com.epam.academy.ox;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.testng.Assert.*;

public class OXTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @BeforeMethod
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @AfterMethod
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @Test
    public void shouldCreateCertainSizeBoard() {
        Board board = new Board(9);
        assertEquals(board.grid.length, 9);
    }

    @Test
    public void shouldPrintBoardCorrectly() {
        Board board = new Board(9);
        String expected = "1 2 3\n4 5 6\n7 8 9";

        board.print();

        assertEquals(outContent.toString(),expected);
    }
}
