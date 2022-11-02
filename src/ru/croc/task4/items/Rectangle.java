package ru.croc.task4.items;

import ru.croc.task3.items.Point;

public class Rectangle extends Annotation {

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
        return String.format("Rectangle (%s, %s), (%s, %s): %s\n", first.getX(), first.getY(),
                second.getX(), second.getY(), signature);
    }

    public Point getFirst() {
        return first;
    }

    public Point getSecond() {
        return second;
    }

    public String getSignature() {
        return signature;
    }
}
