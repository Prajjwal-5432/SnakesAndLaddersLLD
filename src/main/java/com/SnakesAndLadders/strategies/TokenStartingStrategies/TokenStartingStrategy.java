package com.SnakesAndLadders.strategies.TokenStartingStrategies;

import com.SnakesAndLadders.models.Dice;

public interface TokenStartingStrategy {
    boolean canStart(int rollValue);
}
