package com.epam.academy.ox;

import java.util.Arrays;

import static com.epam.academy.ox.Combination.winningCombinations;

public class Game {
    private final Player playerX = new Player('X');
    private final Player playerO = new Player('O');

    public Player checkWinner(Board board) {
        StringBuilder result = new StringBuilder();
        for (int[] winningCombination : winningCombinations) {
            for (int i : winningCombination)
                result.append(board.grid[i]);
            if(result.toString().equals("XXX"))
                return playerX;
            else if(result.toString().equals("OOO"))
                return playerO;
            result = new StringBuilder();
        }
        return null;
    }

}
