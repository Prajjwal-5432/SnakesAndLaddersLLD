package com.SnakesAndLadders;

import com.SnakesAndLadders.controllers.GameController;
import com.SnakesAndLadders.models.Game;
import com.SnakesAndLadders.models.GameStatus;

public class GameSimulator {
    public static void main(String[] args) {
        GameController gameController = new GameController();
        Game game = gameController.createGame();

        while(gameController.getGameStatus(game).equals(GameStatus.IN_PROGRESS)) {
            game.makeMove();
        }

        System.out.println("Game won by Player with ID " + gameController.getWinner(game).getPlayerID());
    }
}
