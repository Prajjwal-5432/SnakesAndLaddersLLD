package com.SnakesAndLadders.models;

public class Ladder extends ForeignEntity {
    public Ladder(int from, int to) {
        super(Type.LADDER, from, to);
    }
}
