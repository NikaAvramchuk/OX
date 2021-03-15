package com.epam.academy.ox;

public class Board {
    public char[] grid;

    public Board(int size) {
        grid = new char[size];
        for(int i=0; i<size; i++) {
            grid[i] = (char) (i+49);
        }
    }

    public String image() {
        StringBuilder stringBuilder = new StringBuilder();
        for (char b : grid) {
            stringBuilder.append(b);
            if (b % 3 == 0)
                stringBuilder.append("\n");
            else
                stringBuilder.append(" ");
        }
        return stringBuilder.toString();
    }

    public void updateGrid(Player player, int chosenSlot) {
        grid[chosenSlot-1] = player.name;
    }
}
