package com.SnakesAndLadders.models;

public class Token {
    private int position;
    private TokenStatus tokenStatus;

    public Token() {
        this.position = -1;
        this.tokenStatus = TokenStatus.LOCKED;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public TokenStatus getTokenStatus() {
        return tokenStatus;
    }

    public void setTokenStatus(TokenStatus tokenStatus) {
        this.tokenStatus = tokenStatus;
    }
}
