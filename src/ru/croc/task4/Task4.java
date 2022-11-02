package ru.croc.task4;

import ru.croc.task3.items.Point;
import ru.croc.task4.items.*;

import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        AnnotatedImage figures = new AnnotatedImage("Some Path",
                new Circle(new Point(10, 10), 1, "pancake"),
                new Rectangle(new Point(0, 0), new Point(7, 7), "phone"),
                new Figure("polygonal", new Point(0, 0), new Point(0, 5),
                        new Point(3, 5), new Point(5, 0)));

        for (var figure: figures.getAnnotations()){
            System.out.println(figure);
        }
    }
}
