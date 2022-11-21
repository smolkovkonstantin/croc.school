package ru.croc.task7.chess;

import ru.croc.task7.chess.exceptions.IllegalMoveException;

import java.util.Arrays;
import java.util.Set;

public class WayHorse {

    private static final Set<Integer> DELTA_MOVE = Set.of(1, 2);

    private ChessPosition[] sequence;

    public WayHorse(ChessPosition... sequence) {
        this.sequence = sequence;
    }

    public WayHorse(String sequence) {
        String[] positions = sequence.split(" ");
        this.sequence = ChessPosition.setOfSequence(positions);
    }

    public void isRightWay() throws IllegalMoveException {
        for (int i = 1; i < sequence.length; i++) {
            if (!DELTA_MOVE.equals(sequence[i].compare(sequence[i - 1]))) {
                throw new IllegalMoveException(sequence[i - 1], sequence[i]);
            }
        }
    }

    public ChessPosition[] getSequence() {
        return sequence;
    }

    public void setSequence(ChessPosition[] sequence) {
        this.sequence = sequence;
    }

    @Override
    public String toString() {
        return "WayHorse{" +
                "sequence=" + Arrays.toString(sequence) +
                '}';
    }
}
