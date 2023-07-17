package com.SnakesAndLadders.models;

public abstract class ForeignEntity {
    private Type type;
    private int from;
    private int to;

    public ForeignEntity(Type type, int from, int to) {
        this.type = type;
        this.from = from;
        this.to = to;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public int getFrom() {
        return from;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public int getTo() {
        return to;
    }

    public void setTo(int to) {
        this.to = to;
    }
}
