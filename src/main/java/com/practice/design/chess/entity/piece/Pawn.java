package com.practice.design.chess.entity.piece;

import com.practice.design.chess.entity.Box;

public class Pawn extends Piece {
    public Pawn(boolean white) {
        super(white, Type.PAWN);
    }

    @Override
    public boolean canMove(Box startBox, Box endBox) {
        if (endBox.getPiece() != null && endBox.getPiece().isWhite() == this.isWhite())
            return false;

        int yDiff = 0;
        int xDiff = Math.abs(startBox.getX() - endBox.getX());
        if (isWhite()) {
            yDiff = startBox.getY() - endBox.getY();
        } else {
            yDiff = endBox.getY() - startBox.getY();
        }

        if (xDiff > 1 || yDiff > 1)
            return false;
        if(yDiff == 0 && xDiff == 1)
            return true;
        if (yDiff == 1 && xDiff == 1 && endBox.getPiece() != null)
            return true;
        return false;
    }
}
