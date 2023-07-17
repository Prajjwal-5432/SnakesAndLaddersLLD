package com.SnakesAndLadders.models;

import java.util.Random;

public class Dice {
    private int maxNo;
    private Random random;

    public Dice(int maxNo) {
        this.maxNo = maxNo;
        this.random = new Random();
    }
    public int roll() {
        return random.nextInt(maxNo) + 1;
    }
}
