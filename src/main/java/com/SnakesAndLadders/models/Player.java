package com.SnakesAndLadders.models;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private List<Token> tokens;
    private int playerID;

    public Player(int playerID, int numberOfTokens) {
        this.playerID = playerID;
        this.tokens = new ArrayList<>();
        for(int i = 0; i < numberOfTokens; i++) {
            tokens.add(new Token());
        }
    }

    public Token getToken() {
        return this.tokens.get(0);
    }

    public int getPlayerID() {
        return playerID;
    }
}
