package ru.croc.task16.test;

import ru.croc.task16.drivemobile.CarModel;
import ru.croc.task16.drivemobile.Driver;
import ru.croc.task16.drivemobile.Taxi;
import ru.croc.task3.items.Point;

public class TaxiPool {
    public static Taxi[] create(){

        CarModel comfort = new CarModel("Comfort", "Child safety seat");

        CarModel economy = new CarModel("Economy");

        CarModel comfort1 = new CarModel("Comfort", "more than 4 place to seat");


        Taxi taxi1 = new Taxi(new Driver("SnezhanaDenisovna", "+79995553535"),
                comfort,
                new Point(5, 1)
        );

        Taxi taxi2 = new Taxi(new Driver("David", "+721321321213"),
                economy,
                new Point(5, 0)
        );

        Taxi taxi3 = new Taxi(new Driver("Stepan", "+72133121213"),
                comfort1,
                new Point(10, 0)
        );

        return new Taxi[]{taxi1, taxi2, taxi3};
    }
}
