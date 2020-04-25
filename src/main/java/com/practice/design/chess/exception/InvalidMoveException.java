package com.practice.design.chess.exception;

public class InvalidMoveException extends ChessException {
    public InvalidMoveException(String msg) {
        super(msg);
    }
}
