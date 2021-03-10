package com.epam.academy.ox;

public class Board {
    public byte[] grid;

    public Board(int size) {
        grid = new byte[size];
        for(byte i=0; i<size; i++) {
            grid[i] = (byte) (i+1);
        }
    }

    public void print() {
        System.out.print("1 2 3\n4 5 6\n7 8 9");
    }
}
