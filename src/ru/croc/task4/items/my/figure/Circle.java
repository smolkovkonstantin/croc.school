package ru.croc.task4.items.my.figure;

import ru.croc.task3.items.Point;
import ru.croc.task4.items.Annotation;
import ru.croc.task4.items.Movable;

public class Circle implements Annotation, Movable {

    private final Point centre;
    private final double radius;
    private final String signature;

    public Circle(Point centre, double radius, String signature){
        this.centre = centre;
        this.radius = radius;
        this.signature = signature;
    }


    @Override
    public String toString() {
        return String.format("Circle (%s, %s), %s: %s", centre.getX(), centre.getY(), radius, signature);
    }

    public Point[] getPoints() {
        return new Point[]{centre};
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public String getSignature() {
        return signature;
    }

    @Override
    public void move(int dx, int dy) {
        centre.setX(centre.getX() + dx);
        centre.setY(centre.getY() + dy);
    }
}
