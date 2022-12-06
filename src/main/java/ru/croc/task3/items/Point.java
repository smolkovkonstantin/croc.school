package ru.croc.task3.items;

import ru.croc.task16.drivemobile.SelectionCar;

import java.util.Objects;

public class Point implements Comparable<Point> {
    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return Double.compare(point.x, x) == 0 && Double.compare(point.y, y) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return String.format("(%s, %s)", x, y);
    }

    @Override
    public int compareTo(Point o) {
        if (o.getX() == x && y == o.getY()) {
            return 0;
        }

        double r = Math.sqrt(Math.pow(o.getX() - x, 2) + Math.pow(o.getY() - y, 2));

        return Math.toIntExact(Math.round(r * SelectionCar.accuracyOfApproximation));
    }
}
