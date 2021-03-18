package com.epam.academy.ox;

import static com.epam.academy.ox.Combination.winningCombinations;

/**
 * This class is responsible for the course of the game. It creates players, the board, UI and return the winner.
 * {@link OXGame#play()} is the main method in which the game is played
 */
public class OXGame {
    private final UI ui;
    private final Player[] players;
    private final Player playerX;
    private final Player playerO;
    private final Board board;
    private Player winner;
    private String finalMessage;

    public OXGame() {
        ui = new UiImplementation();
        playerX = new Player('X');
        playerO = new Player('O');
        players = new Player[] {playerX,playerO};
        board = new Board(9);
    }

    /**
     * Controls the game flow: prints welcome message, executes the game loop and prints final message.
     */
    public void play() {
        welcomeMessage();
        gameLoop();
        printFinalMessage();
    }

    /**
     * Is printed at the beginning.
     */
    private void welcomeMessage () {
        ui.showMessage("Hey there! Welcome to 3X3 Tic Tac Toe game!");
        ui.showMessage(board.image());
    }

    /**
     * Continues until the game is over (there is either winner or draw).
     */
    private void gameLoop() {
        while (!isOver()) {
            int input;
            for(Player player: players) {
                ui.showMessage("%s turn, please choose the slot: ", player);
                input = ui.readNumber();
                playerActs(player, input);
                ui.showMessage(board.image());
                if(checkWinner()) {
                    finalMessage = String.format("%s won! Congratulations!",winner);
                    break;
                }
                else if(checkDraw()) {
                    finalMessage = "There is a draw! Game over!";
                    break;
                }
            }
        }
    }

    /**
     * Checks if the game has winner (the player who succeeds in placing three of their marks in a horizontal, vertical or diagonal row)
     * @return true if winner is found
     */
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

    /**
     * @return true if there is a draw (all slots are occupied by players and there is no winner)
     */
    public boolean checkDraw() {
        return board.allSlotsAreOccupied();
    }

    public Board getBoard() {
        return board;
    }

    /**
     * Board is updating depends on the slot chosen by player
     * @param player whose turn is
     * @param slot chosen slot
     */
    public void playerActs(Player player, int slot) {
        board.updateGrid(player,slot);
    }

    /**
     * @return value on the given slot
     */
    public char getValueOnGivenSlot(int slot) {
        return board.getValueOnGivenSlot(slot);
    }

    /**
     * @return true if the game is over (winner found or there is a draw)
     */
    public boolean isOver() {
        return checkDraw() || checkWinner();
    }

    private void printFinalMessage () {
        ui.showMessage(finalMessage);
    }

}
