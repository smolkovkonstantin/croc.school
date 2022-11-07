package ru.croc.task4.items.same.figure;

import ru.croc.task3.items.Point;
import ru.croc.task4.items.same.Figure;
import ru.croc.task4.items.same.InvalidFigure;

public class Circle extends Figure {

    private final Point centre;
    private final double radius;
    final static String NAME = "Circle";

    public Circle(Point centre, double radius) {
        super(centre);
        this.centre = centre;
        this.radius = radius;

        try {
            isReal();
        } catch (InvalidFigure e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean isInsidePoint(Point point) {

        double r = Math.sqrt( Math.pow(centre.getX() - point.getX(), 2) + Math.pow(centre.getY() - point.getY(), 2));

        return r <= radius;

    }

    @Override
    public void isReal() throws InvalidFigure {
        if (radius <= 0){
            throw new InvalidFigure();
        }
    }

    @Override
    public String getName() {
        return NAME;
    }

    public Point[] getPoints() {
        return new Point[]{centre};
    }

    public double getRadius() {
        return radius;
    }
}
