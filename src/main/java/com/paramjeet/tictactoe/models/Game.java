package com.paramjeet.tictactoe.models;

import com.paramjeet.tictactoe.exception.InvalidMoveException;
import com.paramjeet.tictactoe.stratergies.WinningAlgorithm;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter

public class Game {
    private Board board;
    private int nextPlayerMove;
    private Player winner;
    private List<Move> moves;
    private List<Player> players;
    private GameState gameState;
    private WinningAlgorithm winningAlgorithm;

    public Game(int dimension, List<Player> players){
        this.board= new Board(dimension);
        this.players= players;
        this.moves= new ArrayList<>();
        this.gameState= GameState.IN_PROGRESS;
        this.winner= null;
        this.nextPlayerMove= 0;
        this.winningAlgorithm = new WinningAlgorithm();

    }

    public void printBoard(){
        this.board.printBoard();
    }
    private boolean validateMove(Move move){
        int row= move.getCell().getRow();
        int col= move.getCell().getCol();

        if(row<0 || row >= board.getSize() || col<0 || col>= board.getSize()) return false;

        return board.getBoard().get(row).get(col).getCellState().equals(CellState.EMPTY);
    }

    public void makeMove() throws InvalidMoveException{
        Player currentPlayer= players.get(nextPlayerMove);

        //Move that currPlayer wants to make
        Move move= currentPlayer.makeMove(board);

        //Game will validate the move before exceuting
        if(!validateMove(move)){
            throw new InvalidMoveException("Invalid move made by "+ currentPlayer.getName());
        }

        int row= move.getCell().getRow();
        int col= move.getCell().getCol();

        Cell cellToChange = board.getBoard().get(row).get(col);
        cellToChange.setPlayer(currentPlayer);
        cellToChange.setCellState(CellState.BLOCKED);

        Move finalMove = new Move(cellToChange, currentPlayer);
        moves.add(finalMove);

        //incrementing the current player pointer
        nextPlayerMove = (nextPlayerMove + 1)% players.size();

        //check if the current move is the winning move or not.
        //check for a winner
        if (winningAlgorithm.checkWinner(board, finalMove)) {
            gameState = GameState.ENDED;
            winner = currentPlayer;
        }
        if ( moves.size() == board.getSize() * board.getSize())gameState = GameState.DRAW;
    }
}
