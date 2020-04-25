package com.practice.design.chess.entity.piece;

import com.practice.design.chess.entity.Box;

public class Queen extends Piece {

    public Queen(boolean white){
        super(white, Type.QUEEN);
    }

    @Override
    public boolean canMove(Box startBox, Box endBox) {
        if (endBox.getPiece() != null && endBox.getPiece().isWhite() == this.isWhite())
            return false;
        int xDiff = Math.abs(startBox.getX() - endBox.getX());
        int ydiff = Math.abs(startBox.getY() - endBox.getY());

        if(xDiff == 0 || ydiff == 0) {
            return true;
        }

        if(xDiff == ydiff) {
            return true;
        }
        return false;
    }
}
