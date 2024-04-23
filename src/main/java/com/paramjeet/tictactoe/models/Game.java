package com.paramjeet.tictactoe.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter

public class Game {
    private Board board;
    private int currIndex;
    private Player winner;
    private List<Move> moves;
    private List<Player> players;
    private GameState gameState;
}
