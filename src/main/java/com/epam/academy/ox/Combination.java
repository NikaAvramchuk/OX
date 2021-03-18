package com.epam.academy.ox;

/**
 * Holds all possible winning combinations on the 3X3 {@link Board}.
 */
public class Combination {
    static int[][] winningCombinations = new int[][] {
            {0,1,2},
            {0,4,8},
            {0,3,6},
            {2,5,8},
            {2,4,6},
            {6,7,8},
            {3,4,5}
    };

}
