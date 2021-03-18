package com.epam.academy.ox;

/**
 * Prepares the environment and launches the OX game.
 * OX Game (also known as "Tic-tac-toe") is a game for two players, X and O, who take turns making the spaces in a 3x3 grid.
 * The player who succeeds in placing three of their marks in a horizontal, vertical or diagonal row wins the game.
 * @see OXGame
 */
public class Main {
    public static void main(String[] args) {
        OXGame game = new OXGame();
        game.play();
    }
}
