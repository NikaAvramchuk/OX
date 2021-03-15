package com.epam.academy.ox;

import java.util.Scanner;

import static com.epam.academy.ox.Combination.winningCombinations;

public class Game {
    private final Player playerX;
    private final Player playerO;
    private final Board board;
    private final Scanner scanner;

    public Game() {
        playerX = new Player('X');
        playerO = new Player('O');
        board = new Board(9);
        scanner = new Scanner(System.in);
    }

    public Player checkWinner() {
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

    public boolean checkDraw() {
        for(int i=0; i<9; i++)
            if(!board.isOccupied(i))
                break;
            else if(i==8)
                return true;

        return false;
    }

    public Board getBoard() {
        return board;
    }

    public void playerActs(Player player, int slot) {
        board.updateGrid(player,slot);
    }
}
