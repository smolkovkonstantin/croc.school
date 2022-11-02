package ru.croc.task4.items;

import ru.croc.task3.items.Point;

public class Circle extends Annotation {

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
        return String.format("Circle (%s, %s), %s: %s\n", centre.getX(), centre.getY(), radius, signature);
    }

    public Point getCentre() {
        return centre;
    }

    public double getRadius() {
        return radius;
    }

    public String getSignature() {
        return signature;
    }
}
