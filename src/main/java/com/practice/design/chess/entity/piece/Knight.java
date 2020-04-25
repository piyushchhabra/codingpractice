package com.practice.design.chess.entity.piece;

        import com.practice.design.chess.entity.Box;

public class Knight extends Piece {

    public Knight(boolean white) {
        super(white, Type.KNIGHT);
    }

    @Override
    public boolean canMove(Box startBox, Box endBox) {
        if (endBox.getPiece() != null && endBox.getPiece().isWhite() == this.isWhite())
            return false;
        int xDiff = Math.abs(startBox.getX() - endBox.getX());
        int ydiff = Math.abs(startBox.getY() - endBox.getY());
        if (xDiff * ydiff == 2) {
            return true;
        }
        return false;
    }
}
