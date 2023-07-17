package com.SnakesAndLadders.strategies.PlayerMovingStrategy;

import com.SnakesAndLadders.models.Board;
import com.SnakesAndLadders.models.Token;

public interface MoveStrategy {
    void move(Token token, int rollValue, Board board);
}
