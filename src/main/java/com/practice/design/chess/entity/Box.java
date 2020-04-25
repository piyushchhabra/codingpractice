package com.practice.design.chess.entity;

import com.practice.design.chess.entity.piece.Piece;
import lombok.Data;

@Data
public class Box {

    private int x;
    private int y;
    private Piece piece;

    public Box(int x, int y, Piece piece) {
        this.x = x;
        this.y = y;
        this.piece = piece;
    }

    public String showBox(){
       if(piece == null)
           return "     ";
        return piece.showPiece();
    }
}

