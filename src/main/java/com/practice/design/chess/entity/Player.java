package com.practice.design.chess.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode
public class Player {
    private String name;
    private boolean whitePlayer;

    public Player(boolean whitePlayer, String name) {
        this.whitePlayer = whitePlayer;
        this.name = name;
    }
}
