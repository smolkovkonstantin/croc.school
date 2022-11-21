package ru.croc.task4;

import ru.croc.task3.items.Point;
import ru.croc.task4.items.*;
import ru.croc.task4.items.same.figure.Circle;
import ru.croc.task4.items.same.Figure;
import ru.croc.task4.items.same.figure.Rectangle;

public class Task4 {
    public static void main(String[] args) {
        Figure circle = new Circle(new Point(100, 100), 25);
        Figure rectangle = new Rectangle(new Point(10, 10), new Point(20, 20));

        AnnotatedImage annotatedImage = new AnnotatedImage("Same path",
                new Annotation(circle, "pizza"),
                new Annotation(rectangle, "phone"));

        for (Annotation annotation : annotatedImage.getAnnotations()) {
            System.out.println(annotation);
        }
    }
}
