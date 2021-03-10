package com.epam.academy.ox;

public class Board {
    public byte[] grid;

    public Board(int size) {
        grid = new byte[9];
        for(byte i=0; i<size; i++) {
            grid[i] = (byte) (i+1);
        }
    }
}
