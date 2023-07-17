package com.SnakesAndLadders.models;

public class Snake extends ForeignEntity {
    public Snake(int from, int to) {
        super(Type.SNAKE, from, to);
    }
}
