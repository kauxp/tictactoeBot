package com.paramjeet.tictactoe;

import com.paramjeet.tictactoe.controllers.GameController;
import com.paramjeet.tictactoe.models.*;

import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        GameController gameController = new GameController();
        List<Player> playerList = List.of(
                new Player("KORO",new Symbol('X'), EPlayer.HUMAN),
                new Player("Lelouch",new Symbol('O'), EPlayer.BOT)
        );
        Game game = gameController.startGame(3,playerList);
        while(gameController.checkState(game).equals(GameState.IN_PROGRESS)){
            //Print the board
            gameController.printBoard(game);
            //Player makes move
            gameController.makeMove(game);
        }
        if(gameController.checkState(game).equals(GameState.DRAW)){
            System.out.println("Game Draw");
        } else if (gameController.checkState(game).equals(GameState.ENDED)) {
            System.out.println("Player " + gameController.getWinner(game).getName()+" is the winner!!" );
        }
    }
}