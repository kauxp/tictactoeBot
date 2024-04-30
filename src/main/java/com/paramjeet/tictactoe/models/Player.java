package com.paramjeet.tictactoe.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Scanner;

@Getter
@Setter

public class Player {
    private String name;
    private Symbol symbol;
    private EPlayer playerType;
    private static Scanner scanner= new Scanner(System.in);

    public Player(String name, Symbol symbol, EPlayer playerType) {
        this.name = name;
        this.symbol = symbol;
        this.playerType = playerType;
    }

    public Move makeMove(Board board){
        //Ask the user where they want to place the symbol
        System.out.println("Please enter the row number where you want to make a move: ");
        int row= scanner.nextInt();

        System.out.println("Please enter the col number where you want to make a move: ");
        int col= scanner.nextInt();

        return new Move(new Cell(row,col), this);
    }
}
