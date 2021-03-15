package com.epam.academy.ox;

import java.util.Scanner;

import static com.epam.academy.ox.Combination.winningCombinations;

public class Game {
    private Player[] players;
    private final Player playerX;
    private final Player playerO;
    private final Board board;
    private final Scanner scanner;
    private Player winner;

    public Game() {
        playerX = new Player('X');
        playerO = new Player('O');
        players = new Player[] {playerX,playerO};
        board = new Board(9);
        scanner = new Scanner(System.in);
    }

    public Player checkWinner() {
        StringBuilder result = new StringBuilder();
        for (int[] winningCombination : winningCombinations) {
            for (int i : winningCombination)
                result.append(board.getValueOnGivenSlot(i));
            if (result.toString().equals("XXX"))
                return playerX;
            else if (result.toString().equals("OOO"))
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

    public char getValueOnGivenSlot(int slot) {
        return board.getValueOnGivenSlot(slot);
    }

    public boolean isOver() {
        return checkDraw() || checkWinner()!=null;
    }

    public void game() {
        System.out.println("Hey there! Welcome to 3X3 Tic Tac Toe game");
        board.prints();
        while (!isOver()) {
            int input;
            for(Player player: players) {
                System.out.printf("%s turn, please choose the slot: ", player);
                input = scanner.nextInt();
                playerActs(player, input);
                board.prints();
                if(checkIfPlayerIsWinner()){
                    break;
                }
            }
        }
    }

    private boolean checkIfPlayerIsWinner() {
        winner = checkWinner();
        if(winner!=null) {
            System.out.printf("%s won! Congratulations!",winner);
            return true;
        }
        else if(checkDraw()) {
            System.out.println("There is a draw! Game over");
            return true;
        }
        return false;
    }
}
