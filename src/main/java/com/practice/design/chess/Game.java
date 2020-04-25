package com.practice.design.chess;


import com.practice.design.chess.entity.Board;
import com.practice.design.chess.entity.Box;
import com.practice.design.chess.entity.Player;
import com.practice.design.chess.exception.ChessException;
import com.practice.design.chess.entity.piece.Type;
import com.practice.design.chess.exception.InvalidMoveException;
import lombok.Getter;

public class Game {

    private Board board;
    private Player player1;
    private Player player2;

    @Getter
    private Player currentTurn;
    @Getter
    private boolean gameOver;

    public Game(Player player1, Player player2) {
        this.board = new Board();
        this.player1 = player1;
        this.player2 = player2;
        if (this.player1.isWhitePlayer() == this.player2.isWhitePlayer()) {
            throw new RuntimeException("Both players can not be of same color");
        }

        if (player1.isWhitePlayer())
            this.currentTurn = player1;
        else
            this.currentTurn = player2;
        System.out.println("Game is initialised. White player has got to move first:" + currentTurn);
    }

    public void move(Player player, int startX, int startY, int destX, int destY) throws InvalidMoveException {
        if (!validCoordinate(startX, startY) || !validCoordinate(destX, destY)) {
            throw new InvalidMoveException("Invalid source or destination coordinates given");
        }

        if (startX == destX && startY == destY) {
            System.out.println("Source and destination can not be same");
            return;
        }

        if (player.equals(currentTurn)) {
            Box start = board.boxes[startX][startY];
            Box end = board.boxes[destX][destY];
            if (start.getPiece() == null || start.getPiece().isWhite() != player.isWhitePlayer()) {
                throw new ChessException("No piece is available at given source for player: Box=" + start + " player=" + player);
            }

            if (start.getPiece().canMove(start, end)) {
                movePiece(start, end);
                changeCurrentTurn();
            } else {
                throw new InvalidMoveException("Invalid move for piece:" + start.getPiece() + " from- "+start + " to-"+end);
            }

        } else {
            throw new ChessException("This is another player's turn");
        }
    }

    private boolean validCoordinate(int x, int y) {
        if (x >= 0 && x < 8 && y >= 0 && y < 8)
            return true;
        return false;
    }

    private void movePiece(Box start, Box end) {
        if (end.getPiece() != null) {
            end.getPiece().setKilled(true);
            if (end.getPiece().type.equals(Type.KING))
                gameOver = true;
        }
        end.setPiece(start.getPiece());
        start.setPiece(null);
    }

    private void changeCurrentTurn() {
        if (this.currentTurn.equals(player1))
            this.currentTurn = player2;
        else
            this.currentTurn = player1;
    }

    public void showCurrentGame() {
        System.out.println("------------------------------------------------");
        board.show();
        System.out.println("------------------------------------------------");
    }
}
