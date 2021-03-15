package com.epam.academy.ox;

import static com.epam.academy.ox.Combination.winningCombinations;

public class Game {
    private final UI ui;
    private final Player[] players;
    private final Player playerX;
    private final Player playerO;
    private final Board board;
    private Player winner;

    public Game() {
        ui = new UiImplementation();
        playerX = new Player('X');
        playerO = new Player('O');
        players = new Player[] {playerX,playerO};
        board = new Board(9);
    }
    public void play() {
        welcomeMessage();
        while (!isOver()) {
            int input;
            for(Player player: players) {
                ui.showMessage("%s turn, please choose the slot: ", player);
                input = ui.readNumber();
                playerActs(player, input);
                board.prints();
                if(checkWinner()) {
                    ui.showMessage("%s won! Congratulations!",winner);
                    break;
                }
                else if(checkDraw()) {
                    ui.showMessage("There is a draw! Game over");
                    break;
                }
            }
        }
    }

    public boolean checkWinner() {
        StringBuilder result = new StringBuilder();
        for (int[] winningCombination : winningCombinations) {
            for (int i : winningCombination)
                result.append(board.getValueOnGivenSlot(i));
            if (result.toString().equals("XXX")) {
                winner = playerX;
                return true;
            }

            else if (result.toString().equals("OOO")) {
                winner = playerO;
                return true;
            }
            result = new StringBuilder();
        }
        return false;
    }

    public boolean checkDraw() {
        return board.allSlotsAreOccupied();
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
        return checkDraw() || checkWinner();
    }


    public void welcomeMessage () {
        ui.showMessage("Hey there! Welcome to 3X3 Tic Tac Toe game!");
        board.prints();
    }
}
