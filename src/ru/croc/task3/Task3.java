package ru.croc.task3;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {

        Point first, second, third;

        if (args.length == 0){
            Scanner scanner = new Scanner(System.in);
            first = new Point(scanner.nextDouble(), scanner.nextDouble());
            second = new Point(scanner.nextDouble(), scanner.nextDouble());
            third = new Point(scanner.nextDouble(), scanner.nextDouble());
        } else {
            first = new Point(Double.parseDouble(args[0]), Double.parseDouble(args[1]));
            second = new Point(Double.parseDouble(args[2]), Double.parseDouble(args[3]));
            third = new Point(Double.parseDouble(args[4]), Double.parseDouble(args[5]));
        }

        MyTriangle triangle = new MyTriangle(first, second, third);

        DecimalFormat df = new DecimalFormat("#.####"); // выбираю точность округления
        df.setRoundingMode(RoundingMode.HALF_EVEN); // округляю по математическим правилам: 0.[5-9] -> 1; 0.[1-4] -> 0.0

        System.out.println("Площадь треугольника: " + df.format(triangle.square())); // выводит с ","
        // System.out.println(df.format(triangle.square()).replace(',', '.')); // выводит с "."

    }
}
