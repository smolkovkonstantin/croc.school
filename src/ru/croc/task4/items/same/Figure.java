package ru.croc.task4.items.same;

import ru.croc.task3.items.Point;
import ru.croc.task5.Movable;

public class Figure implements Movable {

    private final Point[] points;

    public Figure(Point... points) {
        this.points = points;
    }

    public void isReal() throws InvalidFigure {}

    public boolean isInsidePoint(Point point) {
        return false;
    }

    public String getName() {
        return "Same figure";
    }

    public void move(int dx, int dy) {
        for (Point point : points) {
            point.setX(point.getX() + dx);
            point.setY(point.getY() + dy);
        }
    }

    public Point[] getPoints() {
        return points;
    }
}
