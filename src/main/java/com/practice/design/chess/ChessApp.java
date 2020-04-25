package com.practice.design.chess;

import com.practice.design.chess.entity.Player;
import com.practice.design.chess.exception.InvalidMoveException;

import java.util.Scanner;

/**
 * Created by piyush.chhabra on 30/11/2019
 */
public class ChessApp {

    public static void main(String[] args) {
        Player p1 = new Player(true, "Piyush");
        Player p2 = new Player(false, "Chhotu");

        Game game = new Game(p1, p2);
        game.showCurrentGame();

        while(game.isGameOver() == false) {
            Player current = game.getCurrentTurn();
            System.out.println("Turn by "+current+"\nPlease enter x and y coordinate of source and destination for move");
            Scanner sc = new Scanner(System.in);
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            try {
                game.move(current, x1, y1, x2, y2);
                game.showCurrentGame();
            } catch (InvalidMoveException e) {
                System.out.println("Invalid Move:"+e.getMessage());
            }

        }
    }

}
