package com.practice.design.chess.entity.piece;

import com.practice.design.chess.entity.Box;

public class King extends Piece {
    public King(boolean white) {
        super(white, Type.KING);
    }

    @Override
    public boolean canMove(Box startBox, Box endBox) {
        if( endBox.getPiece() != null && endBox.getPiece().isWhite() == this.isWhite())
            return false;
        int xDiff = Math.abs(startBox.getX() - endBox.getX());
        int ydiff = Math.abs(startBox.getY() - endBox.getY());

        if(xDiff <= 1 && ydiff <= 1) {
            return true;
        }
        return false;
    }
}
