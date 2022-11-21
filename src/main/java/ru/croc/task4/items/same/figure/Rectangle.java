package ru.croc.task4.items.same.figure;

import ru.croc.task3.items.Point;
import ru.croc.task4.items.same.Figure;
import ru.croc.task4.items.same.InvalidFigure;

public class Rectangle extends Figure {

    private final Point first;
    private final Point second;
    final static String NAME = "Rectangle";


    public Rectangle(Point first, Point second) {
        super(first, second);
        this.first = first;
        this.second = second;

        {
            isReal();
        }
    }

    @Override
    public boolean isInsidePoint(Point point) {

        boolean onTheXAxis = Math.min(first.getX(), second.getX()) <= point.getX() && point.getX() <= Math.max(first.getX(), second.getX());
        boolean onTheYAxis = Math.min(first.getY(), second.getY()) <= point.getY() && point.getY() <= Math.max(first.getY(), second.getY());

        return (onTheXAxis && onTheYAxis);
    }

    @Override
    public void isReal() throws InvalidFigure {
        if (!(first.getX() < second.getX() && first.getY() < second.getY())) {
            throw new InvalidFigure();
        }
    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public Point[] getPoints() {
        return new Point[]{first, second};
    }

    public Point getFirst() {
        return first;
    }

    public Point getSecond() {
        return second;
    }

    @Override
    public String toString() {
        return String.format("%s %s, %s: ", NAME, first, second);
    }
}
