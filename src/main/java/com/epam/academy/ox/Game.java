package com.epam.academy.ox;

import java.util.InputMismatchException;
import java.util.Scanner;

import static com.epam.academy.ox.Combination.winningCombinations;

public class Game {
    private final UI ui;
    private Player[] players;
    private final Player playerX;
    private final Player playerO;
    private final Board board;
    private final Scanner scanner;
    private Player winner;

    public Game() {
        ui = new UiImplementation();
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

    public void play() {
        welcomeMessage();
        while (!isOver()) {
            int input;
            for(Player player: players) {
                ui.showMessage("%s turn, please choose the slot: ", player);
                try {
                    input = ui.readNumber();
                    if (!(input > 0 && input <= 9)) {
                       ui.showMessage("Invalid input; re-enter slot number:");
                       continue;
                    }
                } catch (InputMismatchException e) {
                    ui.showMessage( "Invalid input; re-enter slot number:");
                    continue;
                }
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
            ui.showMessage("%s won! Congratulations!",winner);
            return true;
        }
        else if(checkDraw()) {
            ui.showMessage("There is a draw! Game over");;
            return true;
        }
        return false;
    }

    public void welcomeMessage () {
        ui.showMessage("Hey there! Welcome to 3X3 Tic Tac Toe game!%n");
        board.prints();
    }
}
