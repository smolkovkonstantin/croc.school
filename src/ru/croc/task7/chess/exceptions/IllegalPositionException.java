package ru.croc.task7.chess.exceptions;

import ru.croc.task7.chess.ChessPosition;

/**
 * Throw if position of figure outside from chess board 8x8
 */

public class IllegalPositionException extends RuntimeException{
    public IllegalPositionException(ChessPosition e){
        super(String.format("The figure with this coordinate cannot be set at the board: %s", e.toString()));
    }
}
