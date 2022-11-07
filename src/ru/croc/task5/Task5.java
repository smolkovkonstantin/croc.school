package ru.croc.task5;

import ru.croc.task3.items.Point;
import ru.croc.task4.items.AnnotatedImage;
import ru.croc.task4.items.Annotation;
import ru.croc.task4.items.same.figure.Circle;
import ru.croc.task4.items.same.Figure;
import ru.croc.task4.items.same.figure.Rectangle;

public class Task5 {
    public static void main(String[] args) {
        Figure circle = new Circle(new Point(100, 100), 25);
        Figure rectangle = new Rectangle(new Point(10, 10), new Point(20, 20));

        AnnotatedImage annotatedImage = new AnnotatedImage("Same path",
                new Annotation(circle, "pizza"),
                new Annotation(rectangle, "phone"));

        for (Annotation annotation : annotatedImage.getAnnotations()) {
            System.out.println(annotation);
        }

        circle.move(10, 10);
        rectangle.move(-10, 5);

        for (Annotation annotation : annotatedImage.getAnnotations()) {
            System.out.println(annotation);
        }

        Point first = new Point(110, 85);
        Point second = new Point(110, 84);
        Point third = new Point(5, 18);
        Point fourth = new Point(0, 15);

        System.out.println(annotatedImage.findByPoint(first));
        System.out.println(annotatedImage.findByPoint(second));
        System.out.println(annotatedImage.findByPoint(third));
        System.out.println(annotatedImage.findByPoint(fourth));
        System.out.println(annotatedImage.findByPoint(-1, 15));



    }
}
