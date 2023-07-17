package com.SnakesAndLadders.controllers;

import com.SnakesAndLadders.models.*;
import com.SnakesAndLadders.strategies.PlayerMovingStrategy.NormalMoveStrategy;
import com.SnakesAndLadders.strategies.TokenStartingStrategies.NormalStartingStrategy;

import java.util.List;

public class GameController {
    public Game createGame() {
        Game game = Game.create()
                .setBoardDimension(100)
                .setDiceDimension(6)
                .setMaxTokenPerPerson(1)
                .setForeignEntity(new Snake(15, 8))
                .setForeignEntity(new Snake(97, 56))
                .setForeignEntity(new Ladder(12, 78))
                .setForeignEntity(new Ladder(45, 99))
                .setPlayer(new Player(1, 1))
                .setPlayer(new Player(2, 1))
                .setMoveStrategy(new NormalMoveStrategy())
                .setTokenStartingStrategy(new NormalStartingStrategy())
                .build();

        return game;
    }

    public void makeMove(Game game) {
        game.makeMove();
    }

    public GameStatus getGameStatus(Game game) {
        return game.getGameStatus();
    }

    public Player getWinner(Game game) {
        return game.getWinner();
    }
}
