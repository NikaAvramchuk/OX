package com.epam.academy.ox;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UiImplementation implements UI {
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public int readNumber() throws InputMismatchException {
        return scanner.nextInt();
    }

    @Override
    public void showMessage(String message, Object...args) {
        System.out.printf(message, args);
    }
}
