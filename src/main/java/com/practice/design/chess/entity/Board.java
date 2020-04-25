package com.practice.design.chess.entity;


import com.practice.design.chess.entity.piece.*;

public class Board {
    public Box[][] boxes = new Box[8][8];

    public Board(){
        this.init();
    }

    private void init(){
        //initialise a chess board
        boxes[0][0] = new Box(0, 0, new Rook(false));
        boxes[0][1] = new Box(0, 1, new Knight(false));
        boxes[0][2] = new Box(0, 2, new Bishop(false));
        boxes[0][3] = new Box(0, 3, new King(false));
        boxes[0][4] = new Box(0, 4, new Queen(false));
        boxes[0][5] = new Box(0, 5, new Bishop(false));
        boxes[0][6] = new Box(0, 6, new Knight(false));
        boxes[0][7] = new Box(0, 7, new Rook(false));

        boxes[1][0] = new Box(1, 0, new Pawn(false));
        boxes[1][1] = new Box(1, 1, new Pawn(false));
        boxes[1][2] = new Box(1, 2, new Pawn(false));
        boxes[1][3] = new Box(1, 3, new Pawn(false));
        boxes[1][4] = new Box(1, 4, new Pawn(false));
        boxes[1][5] = new Box(1, 5, new Pawn(false));
        boxes[1][6] = new Box(1, 6, new Pawn(false));
        boxes[1][7] = new Box(1, 7, new Pawn(false));

        boxes[6][0] = new Box(6, 0, new Pawn(true));
        boxes[6][1] = new Box(6, 1, new Pawn(true));
        boxes[6][2] = new Box(6, 2, new Pawn(true));
        boxes[6][3] = new Box(6, 3, new Pawn(true));
        boxes[6][4] = new Box(6, 4, new Pawn(true));
        boxes[6][5] = new Box(6, 5, new Pawn(true));
        boxes[6][6] = new Box(6, 6, new Pawn(true));
        boxes[6][7] = new Box(6, 7, new Pawn(true));

        boxes[7][0] = new Box(0, 0, new Rook(true));
        boxes[7][1] = new Box(0, 1, new Knight(true));
        boxes[7][2] = new Box(0, 2, new Bishop(true));
        boxes[7][3] = new Box(0, 3, new Queen(true));
        boxes[7][4] = new Box(0, 4, new King(true));
        boxes[7][5] = new Box(0, 5, new Bishop(true));
        boxes[7][6] = new Box(0, 6, new Knight(true));
        boxes[7][7] = new Box(0, 7, new Rook(true));

        for(int x = 2; x<= 5; x ++ ){
            for(int y =0; y<=7; y++) {
                boxes[x][y] = new Box(x, y, null);
            }
        }
    }

    public void show(){
        for(Box[] boxLine : boxes) {
            for(Box box: boxLine) {
                System.out.print(box.showBox() + " ");
            }
            System.out.println();
        }
    }
}
