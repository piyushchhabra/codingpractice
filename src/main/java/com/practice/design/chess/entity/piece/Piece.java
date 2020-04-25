package com.practice.design.chess.entity.piece;

import com.practice.design.chess.entity.Box;
import lombok.Data;

@Data
public abstract class Piece {

    private boolean white;
    private boolean killed;
    public Type type;
    public Piece(boolean white, Type type) {
        this.white = white;
        this.type = type;
    }

    public abstract boolean canMove(Box startBox, Box endBox);

    public String showPiece(){
        StringBuilder sb = new StringBuilder("");
        sb.append(isWhite() ? "W-" : "B-");
        sb.append(type.name());
        return sb.toString();
    }
}
