package com.epam.academy.ox;

import static com.epam.academy.ox.Combination.winningCombinations;

public class Game {
    private final Player playerX = new Player('X');
    private final Player playerO = new Player('O');

    public Player checkWinner(Board board) {
        StringBuilder result = new StringBuilder();
        for (int[] winningCombination : winningCombinations) {
            for (int i : winningCombination)
                result.append(board.getValueOnGivenSlot(i));
            if(result.toString().equals("XXX"))
                return playerX;
            else if(result.toString().equals("OOO"))
                return playerO;
            result = new StringBuilder();
        }
        return null;
    }

    public boolean checkDraw(Board board) {
        for(int i=0; i<9; i++)
            if(!board.isOccupied(i))
                break;
            else if(i==8)
                return true;

        return false;
    }
}
