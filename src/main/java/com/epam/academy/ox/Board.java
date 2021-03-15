package com.epam.academy.ox;

public class Board {
    private final char[] grid;

    public Board(int size) {
        grid = new char[size];
        for(int i=0; i<size; i++) {
            grid[i] = (char) (i+49);
        }
    }

    public String image() {
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0; i<grid.length; i++) {
            if(i%3==0) {
                stringBuilder.append("\n-------------\n").append("| ");
            }
            stringBuilder.append(grid[i]).append(" | ");
        }
        stringBuilder.append("\n-------------\n");
        return stringBuilder.toString();
    }

    public void updateGrid(Player player, int chosenSlot) {
        if(!isOccupied(chosenSlot-1)) {
            grid[chosenSlot-1] = player.name;
        }
    }

    public boolean isOccupied(int slot) {
        return grid[slot]=='X' || grid[slot]=='O';
    }

    public boolean allSlotsAreOccupied() {
        for (char slot: grid)
            if(slot!='X' && slot!='O')
                return false;

        return true;

    }

    public char getValueOnGivenSlot(int slot) {
        return grid[slot];
    }

    public int length() {
        return grid.length;
    }

    public void prints() {
        System.out.println(image());
    }
}
