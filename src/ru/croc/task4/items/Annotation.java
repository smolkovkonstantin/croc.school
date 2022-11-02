package ru.croc.task4.items;

import ru.croc.task3.items.Point;

public interface Annotation extends Movable{
    String toString();
    Point[] getPoints();
    String getSignature();
}
