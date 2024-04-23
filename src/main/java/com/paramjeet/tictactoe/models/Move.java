package com.paramjeet.tictactoe.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Move {
    private Cell cell;
    private Player player;
}
