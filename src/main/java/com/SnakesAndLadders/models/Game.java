package com.SnakesAndLadders.models;

import com.SnakesAndLadders.strategies.PlayerMovingStrategy.MoveStrategy;
import com.SnakesAndLadders.strategies.TokenStartingStrategies.TokenStartingStrategy;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Board board;
    private Dice dice;
    private List<Player> players;
    private int maxTokenPerPerson;
    private List<Player> rankings;
    private int lastPlayerIndex;
    private MoveStrategy moveStrategy;
    private GameStatus gameStatus;
    private TokenStartingStrategy tokenStartingStrategy;
    private Player winner;

    private Game() {
        this.players = new ArrayList<>();
        this.rankings = new ArrayList<>();
        this.lastPlayerIndex = -1;
        this.gameStatus = GameStatus.IN_PROGRESS;
    }

    public Board getBoard() {
        return board;
    }

    public Dice getDice() {
        return dice;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public int getMaxTokenPerPerson() {
        return maxTokenPerPerson;
    }

    public List<Player> getRankings() {
        return rankings;
    }

    public int getLastPlayerIndex() {
        return lastPlayerIndex;
    }

    public MoveStrategy getMoveStrategy() {
        return moveStrategy;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public TokenStartingStrategy getTokenStartingStrategy() {
        return tokenStartingStrategy;
    }

    public Player getWinner() {
        return winner;
    }

    public void makeMove() {
        this.lastPlayerIndex += 1;
        this.lastPlayerIndex %= this.players.size();

        System.out.println("Player id: " + this.players.get(lastPlayerIndex).getPlayerID());

        List<Integer> rollValues = new ArrayList<>();
        for(int i = 0; ; i++) {
            int rollValue = dice.roll();
            if(rollValues.isEmpty() || rollValue == 6) {
                rollValues.add(rollValue);
                if(rollValue != 6) break;
            } else {
                rollValues.add(rollValue);
                break;
            }
            if(rollValues.size() == 3) return;
        }

        Token token = this.players.get(lastPlayerIndex).getToken();

        if(token.getTokenStatus().equals(TokenStatus.LOCKED) &&
                tokenStartingStrategy.canStart(rollValues.get(0))) {
            System.out.println("Player Entered");
            System.out.println("Roll Value: " + rollValues.get(0));
            token.setTokenStatus(TokenStatus.IN_GAME);
            token.setPosition(1);
        } else if(token.getTokenStatus().equals(TokenStatus.IN_GAME)) {
            for(int rollValue: rollValues) {
                System.out.println("Roll Value: " + rollValue);
                moveStrategy.move(token, rollValue, board);
            }
        }

        if(token.getTokenStatus().equals(TokenStatus.ENDED)) {
            this.winner = this.players.get(this.lastPlayerIndex);
            this.gameStatus = GameStatus.COMPLETED;
        }
    }

    public static Builder create() {
        return new Builder();
    }
    public static class Builder {
        private int boardDimension;
        private int diceDimension;
        private List<Player> players;
        private int maxTokenPerPerson;
        private MoveStrategy moveStrategy;
        private TokenStartingStrategy tokenStartingStrategy;
        private List<ForeignEntity> foreignEntities;

        public Builder() {
            this.players = new ArrayList<>();
            this.foreignEntities = new ArrayList<>();
        }

        public Builder setBoardDimension(int boardDimension) {
            this.boardDimension = boardDimension;
            return this;
        }

        public Builder setDiceDimension(int diceDimension) {
            this.diceDimension = diceDimension;
            return this;
        }

        public Builder setMaxTokenPerPerson(int maxTokenPerPerson) {
            this.maxTokenPerPerson = maxTokenPerPerson;
            return this;
        }

        public Builder setForeignEntities(List<ForeignEntity> foreignEntities) {
            this.foreignEntities.addAll(foreignEntities);
            return this;
        }
        public Builder setForeignEntity(ForeignEntity foreignEntity) {
            this.foreignEntities.add(foreignEntity);
            return this;
        }

        public Builder setPlayers(List<Player> players) {
            this.players.addAll(players);
            return this;
        }
        public Builder setPlayer(Player player) {
            this.players.add(player);
            return this;
        }

        public Builder setMoveStrategy(MoveStrategy moveStrategy) {
            this.moveStrategy = moveStrategy;
            return this;
        }

        public Builder setTokenStartingStrategy(TokenStartingStrategy tokenStartingStrategy) {
            this.tokenStartingStrategy = tokenStartingStrategy;
            return this;
        }

        public Game build() {
            Game game = new Game();

            game.board = new Board(this.boardDimension, this.foreignEntities);
            game.dice = new Dice(diceDimension);
            game.players.addAll(this.players);
            game.maxTokenPerPerson = this.maxTokenPerPerson;
            game.moveStrategy = this.moveStrategy;
            game.tokenStartingStrategy = this.tokenStartingStrategy;

            return game;
        }
    }
}
