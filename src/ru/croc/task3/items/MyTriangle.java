package ru.croc.task3.items;

public class MyTriangle {

    private final Point firstPoint;
    private final Point secondPoint;
    private final Point thirdPoint;

    private final double side1;
    private final double side2;
    private final double side3;

    public MyTriangle(Point firstPoint, Point secondPoint, Point thirdPoint) {
        this.firstPoint = firstPoint;
        this.secondPoint = secondPoint;
        this.thirdPoint = thirdPoint;

        this.side1 = sideLength(firstPoint, secondPoint);
        this.side2 = sideLength(firstPoint, thirdPoint);
        this.side3 = sideLength(secondPoint, thirdPoint);
    }

    public boolean isReal() {
        if (side1 + side2 <= side3) {
            return false;
        } else if (side2 + side3 <= side1) {
            return false;
        } else if (side1 + side3 <= side2) {
            return false;
        }
        return true;
    }

    public double square() {

        double halfPerimeter = perimeter() / 2;

        return Math.sqrt(halfPerimeter *
                (halfPerimeter - side1) *
                (halfPerimeter - side2) *
                (halfPerimeter - side3)
        );
    }

    public double perimeter() {
        return side1 + side2 + side3;
    }

    public double sideLength(Point a, Point b) {
        return Math.sqrt(
                Math.pow(a.getX() - b.getX(), 2) +
                        Math.pow(a.getY() - b.getY(), 2)
        );
    }

    public Point getFirstPoint() {
        return firstPoint;
    }

    public Point getSecondPoint() {
        return secondPoint;
    }

    public Point getThirdPoint() {
        return thirdPoint;
    }

    public double getSide1() {
        return side1;
    }

    public double getSide2() {
        return side2;
    }

    public double getSide3() {
        return side3;
    }
}
