package com.epam.academy.ox;

/**
 * Responsible for the communication with the user
 */
public interface UI {
    /**
     * Reads the slot number from the player
     * @return slot number chosen by player
     */
    int readNumber();

    /**
     * Prints message to the console
     * @param message to be printed
     * @param args used in the  message formatting
     */
    void showMessage (String message, Object...args);
}
