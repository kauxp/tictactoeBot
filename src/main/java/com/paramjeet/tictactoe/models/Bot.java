package com.paramjeet.tictactoe.models;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter

public class Bot extends Player {
    private DifficultyLevel botDifficulty;

    public Bot(String name, Symbol symbol, EPlayer playerType, DifficultyLevel botDifficulty) {
        super(name, symbol, playerType);
        this.botDifficulty = botDifficulty;
    }

    @Override
    public Move makeMove(Board board) {
        // Finds the first empty cell and makes the move there
        for (List<Cell> rowCell : board.getBoard()) {
            for (Cell cell : rowCell) {
                if (cell.getCellState().equals(CellState.EMPTY)) {
                    return new Move(cell, this);
                }
            }
        }
        return null;
    }
}