package com.epam.academy.ox;

public class Board {
    public byte[] grid;

    public Board(int size) {
        grid = new byte[size];
        for(byte i=0; i<size; i++) {
            grid[i] = (byte) (i+1);
        }
    }

    public String image() {
        StringBuilder stringBuilder = new StringBuilder();
        for (byte b : grid) {
            stringBuilder.append(b);
            if (b % 3 == 0)
                stringBuilder.append("\n");
            else
                stringBuilder.append(" ");
        }
        return stringBuilder.toString();
    }
}
