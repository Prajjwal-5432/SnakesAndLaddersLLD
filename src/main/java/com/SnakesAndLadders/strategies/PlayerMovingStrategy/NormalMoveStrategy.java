package com.SnakesAndLadders.strategies.PlayerMovingStrategy;

import com.SnakesAndLadders.models.Board;
import com.SnakesAndLadders.models.ForeignEntity;
import com.SnakesAndLadders.models.Token;
import com.SnakesAndLadders.models.TokenStatus;

public class NormalMoveStrategy implements MoveStrategy {
    public void printPosition(int position) {
        System.out.println("Current Position " + position);
    }
    @Override
    public void move(Token token, int rollValue, Board board) {
        //check overflow
        //update snake and ladder
        //update status of the button
        int nextPosition = token.getPosition() + rollValue;

        if(nextPosition > board.getSize()) {
            printPosition(token.getPosition());
            return;
        }

        if(nextPosition == board.getSize()) {
            token.setPosition(board.getSize());
            token.setTokenStatus(TokenStatus.ENDED);
            printPosition(token.getPosition());
            return;
        }

        ForeignEntity foreignEntity = board.getForeignEntity(nextPosition);

        if(foreignEntity != null) {
            token.setPosition(foreignEntity.getTo());
        } else {
            token.setPosition(nextPosition);
        }

        printPosition(token.getPosition());
    }
}
