package ru.croc.task5;

import ru.croc.task3.items.Point;
import ru.croc.task4.items.AnnotatedImage;
import ru.croc.task4.items.my.figure.Circle;
import ru.croc.task4.items.my.figure.Figure;
import ru.croc.task4.items.my.figure.Rectangle;

public class Task5 {
    public static void main(String[] args) {
        AnnotatedImage figures = new AnnotatedImage("Some Path",
                new Circle(new Point(10, 10), 1, "pancake"),
                new Rectangle(new Point(0, 0), new Point(7, 7), "phone"),
                new Figure("polygonal", new Point(0, 0), new Point(0, 5),
                        new Point(3, 5), new Point(5, 0)));

        for (var figure: figures.getAnnotations()){
            System.out.println(figure);
        }

        System.out.println(figures.findByPoint(10, 10));
        System.out.println(figures.findByPoint(new Point(7, 7)));
        System.out.println(figures.findByLabel("polygonal"));

        figures.getAnnotations()[1].move(10, 10);

        System.out.println(figures.getAnnotations()[1]);

    }
}
