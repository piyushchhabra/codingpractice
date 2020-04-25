package com.practice.design.chess.entity.piece;

import com.practice.design.chess.entity.Box;

public class Bishop extends Piece {
    public Bishop(boolean white) {
        super(white, Type.BISHOP);
    }

    @Override
    public boolean canMove(Box startBox, Box endBox) {
        if( endBox.getPiece() != null && endBox.getPiece().isWhite() == this.isWhite())
            return false;
        int xDiff = Math.abs(startBox.getX() - endBox.getX());
        int ydiff = Math.abs(startBox.getY() - endBox.getY());
        if(xDiff == ydiff){
            return true;
        }
        return false;
    }
}
