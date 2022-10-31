package ru.croc.task3;

public class MyTriangle {

    private final Point firstPoint;
    private final Point secondPoint;
    private final Point thirdPoint;

    public MyTriangle(Point firstPoint, Point secondPoint, Point thirdPoint) {
        this.firstPoint = firstPoint;
        this.secondPoint = secondPoint;
        this.thirdPoint = thirdPoint;
    }

    public double square() {

        double halfPerimeter = perimeter() / 2;

        return Math.sqrt(halfPerimeter *
                (halfPerimeter - sideLength(firstPoint, secondPoint)) *
                (halfPerimeter - sideLength(firstPoint, thirdPoint)) *
                (halfPerimeter - sideLength(thirdPoint, secondPoint))
        );
    }

    public double perimeter() {
        return sideLength(firstPoint, secondPoint) +
                sideLength(firstPoint, thirdPoint) +
                sideLength(secondPoint, thirdPoint);
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
}
