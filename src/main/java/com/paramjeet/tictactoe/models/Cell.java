package com.paramjeet.tictactoe.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Cell {
    private int row;
    private int col;
    private Player player;
    private CellState cellState;
}
