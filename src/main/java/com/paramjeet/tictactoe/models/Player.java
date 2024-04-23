package com.paramjeet.tictactoe.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Player {
    private String name;
    private Symbol symbol;
    private EPlayer playerType;
}
