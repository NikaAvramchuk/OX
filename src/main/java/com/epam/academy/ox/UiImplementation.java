package com.epam.academy.ox;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Implementations of the {@link UI} interface.
 */
public class UiImplementation implements UI {
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public int readNumber() {
        int input = 0;
        while (input==0) {
            try {
                input = scanner.nextInt();
                if (!(input > 0 && input < 10)) {
                    showMessage("Invalid input; please choose the number from 1 to 9: ");
                    input = 0;
                }
            } catch (InputMismatchException e) {
                showMessage("Invalid input; re-enter slot number: ");
                scanner.next();
            }
        }
        return input;
    }

    @Override
    public void showMessage(String message, Object...args) {
        System.out.printf(message, args);
    }
}
