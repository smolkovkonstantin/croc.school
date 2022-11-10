package ru.croc.task7.chess.exceptions;

import ru.croc.task7.chess.ChessPosition;

public class IllegalMoveException extends Exception {
    public IllegalMoveException(ChessPosition from, ChessPosition to) {
        super(String.format("Конь так не ходит: %s -> %s", from, to));
    }
}
