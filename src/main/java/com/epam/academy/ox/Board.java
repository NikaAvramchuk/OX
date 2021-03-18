package com.epam.academy.ox;

/**
 * Represents 3X3 board for the Tic Tac Toe game.
 */
public class Board {
    private final char[] grid;

    public Board(int size) {
        grid = new char[size];
        for(int i=0; i<size; i++) {
            grid[i] = (char) (i+49);
        }
    }

    /**
     * Creates the appearance of the board using StringBuilder.
     * @return board image that is used by {@link UI}
     */
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

    /**
     * Method for changing value of the given slot
     * @param player X or O
     * @param chosenSlot given slot that gonna be changed
     */
    public void updateGrid(Player player, int chosenSlot) {
        if(!isOccupied(chosenSlot-1)) {
            grid[chosenSlot-1] = player.name;
        }
    }

    /**
     * Checks if slot is already occupied by X or O
     * @param slot number on the board
     * @return true if the slot value is X or O
     */
    public boolean isOccupied(int slot) {
        return grid[slot]=='X' || grid[slot]=='O';
    }

    /**
     * Checks if all slots are booked by players
     * @return true if there is no free slots
     */
    public boolean allSlotsAreOccupied() {
        for(int i=0; i<grid.length; i++) {
            if(!isOccupied(i))
                return false;
        }
        return true;
    }

    /**
     * @return value on the given slot
     */
    public char getValueOnGivenSlot(int slot) {
        return grid[slot];
    }

    /**
     * @return board length
     */
    public int length() {
        return grid.length;
    }

}
