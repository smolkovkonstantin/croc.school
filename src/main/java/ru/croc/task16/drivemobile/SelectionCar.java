package ru.croc.task16.drivemobile;

import ru.croc.task3.items.Point;

import java.util.Comparator;
import java.util.List;

public class SelectionCar implements Comparator<Point> {

    public final static int accuracyOfApproximation = 10000;

    public static void nearestTaxis(List<Taxi> taxis, Point locationUser) {
        taxis.sort((t1, t2) -> {
            int r1 = t1.getLocation().compareTo(locationUser);

            int r2 = t2.getLocation().compareTo(locationUser);

            return Integer.compare(r1, r2);
        });
    }

    public static Taxi select(List<Taxi> taxis, String clazz, List<String> options) {

        for (Taxi taxi : taxis) {
            if (taxi.getCar().getClazz().equalsIgnoreCase(clazz) &&
                    areAllOptions(taxi.getCar().getOptions(), options)) {
                return taxi;
            }
        }
        System.out.println("Sorry there is no such car in the our company");
        return null;
    }

    private static boolean areAllOptions(List<String> optionsCar, List<String> options) {
        for (String option : options) {
            if (!optionsCar.contains(option)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int compare(Point o1, Point o2) {
        return o1.compareTo(o2);
    }
}
