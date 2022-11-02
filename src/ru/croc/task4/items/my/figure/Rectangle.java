package ru.croc.task4.items.my.figure;

import ru.croc.task3.items.Point;
import ru.croc.task4.items.Annotation;
import ru.croc.task4.items.Movable;

public class Rectangle implements Annotation, Movable {

    private final Point first;
    private final Point second;
    private final String signature;

    public Rectangle(Point first, Point second, String signature) {
        this.first = first;
        this.second = second;
        this.signature = signature;
    }

    @Override
    public String toString() {
        return String.format("Rectangle (%s, %s), (%s, %s): %s", first.getX(), first.getY(),
                second.getX(), second.getY(), signature);
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
    public String getSignature() {
        return signature;
    }

    @Override
    public void move(int dx, int dy) {
        first.setX(first.getX() + dx);
        first.setY(first.getY() + dy);

        second.setX(second.getX() + dx);
        second.setY(second.getY() + dy);
    }
}
