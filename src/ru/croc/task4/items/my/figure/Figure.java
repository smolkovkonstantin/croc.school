package ru.croc.task4.items.my.figure;

import ru.croc.task3.items.Point;
import ru.croc.task4.items.Annotation;
import ru.croc.task4.items.Movable;

public class Figure implements Annotation, Movable {

    final Point[] points;
    final String signature;

    public Figure(String signature, Point... points){
        this.signature = signature;
        this.points = points;
    }

    @Override
    public String toString() {
        StringBuilder allPointToString = new StringBuilder();

        for (int i = 0; i < points.length; i ++){
            allPointToString.append(String.format(
                    (i == points.length - 1) ? "(%s, %s)" : "(%s, %s), ",
                    points[i].getX(), points[i].getY()));
        }

        return String.format("Same figure %s: %s", allPointToString, signature);

    }

    @Override
    public Point[] getPoints() {
        return points;
    }

    @Override
    public String getSignature() {
        return signature;
    }

    @Override
    public void move(int dx, int dy) {
        for (Point point: points){
            point.setX(point.getX() + dx);
            point.setY(point.getY() + dy);
        }
    }
}
