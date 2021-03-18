package com.epam.academy.ox;

import java.util.Objects;

/**
 * Represents the player in the OX game.
 * {@link #name} could be X or O
 */
public class Player {
    char name;

    public Player(char name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return name == player.name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return String.valueOf(name);
    }
}
