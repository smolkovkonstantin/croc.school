package ru.croc.task7.chess;

import ru.croc.task7.chess.exceptions.IllegalPositionException;

import java.util.Set;

public class ChessPosition {


    private int x;
    private int y;
    private String position;


    private ChessPosition(int x, int y, String position) {
        this.x = x;
        this.y = y;
        this.position = position;
        if ((x > 8 | x < 1) | (y > 8 | y < 1)) {
            throw new IllegalPositionException(this);
        }
    }

    public static ChessPosition set(String str) {

        int x = str.charAt(0) - 'a' + 1;
        int y = str.charAt(1) - '0';

        return new ChessPosition(x, y, str);
    }

    public static ChessPosition[] setOfSequence(String[] sequence) {
        ChessPosition[] chessPositions = new ChessPosition[sequence.length];
        for (int i = 0; i < sequence.length; i++) {
            chessPositions[i] = ChessPosition.set(sequence[i]);
        }
        return chessPositions;
    }

    public Set<Integer> compare(ChessPosition to) {
        return Set.of(Math.abs(this.x - to.x), Math.abs(this.y - to.y));
    }


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return String.format("%s", position);
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
