package com.SnakesAndLadders.strategies.TokenStartingStrategies;

import com.SnakesAndLadders.models.Dice;

public class NormalStartingStrategy implements TokenStartingStrategy {
    public boolean canStart(int rollValue) {
        return rollValue == 1 || rollValue == 6;
    }
}
