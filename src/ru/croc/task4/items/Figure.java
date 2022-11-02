package ru.croc.task4.items;

import ru.croc.task3.items.Point;

public class Figure extends Annotation{

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
                    (i == points.length - 1) ? "(%s %s)" : "(%s %s), ",
                    points[i].getX(), points[i].getY()));
        }

        return String.format("Same figure %s: %s", allPointToString, signature);

    }

}
