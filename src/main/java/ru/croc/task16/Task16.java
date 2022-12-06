package ru.croc.task16;

import ru.croc.task16.drivemobile.SelectionCar;
import ru.croc.task16.drivemobile.Taxi;
import ru.croc.task16.test.TaxiPool;
import ru.croc.task3.items.Point;

import java.util.*;
import java.util.stream.Stream;

public class Task16 {

    public static void main(String[] args) {

        List<Taxi> taxis = new ArrayList<>(List.of(TaxiPool.create()));

        Scanner scanner = new Scanner(System.in);

        System.out.print("Write your location: ");

        Double[] location = Stream.of(scanner.nextLine().split(", ")).map(Double::parseDouble).toArray(Double[]::new);

        Point locationUser = new Point(location[0], location[1]);

        System.out.print("Write a comfort class: economy or comfort\n>");

        String clazz = scanner.nextLine();

        List<String> options = new ArrayList<>();

        Set<String> stringSet = new HashSet<>();

        taxis.forEach(taxi -> stringSet.addAll(taxi.getCar().getOptions()));

        System.out.printf("We have these options: %s\n", stringSet);

        System.out.println("Add option if you need \nwhen you're done write: start");

        String now;

        while (!(now = scanner.nextLine()).equalsIgnoreCase("start")) {
            options.add(now);
        }

        SelectionCar.nearestTaxis(taxis, locationUser);

        Taxi result = SelectionCar.select(taxis, clazz, options);

        if (result != null) {
            System.out.println(result);
        }
    }
}
