package ru.croc.task16.drivemobile;

import ru.croc.task3.items.Point;

public class Taxi {
    private final Driver driver;
    private final CarModel car;
    private Point location;

    public Taxi(Driver driver, CarModel car, Point location) {
        this.driver = driver;
        this.car = car;
        this.location = location;
    }

    @Override
    public String toString() {
        return String.format("%s-%s-%s", car.getClazz(), driver.getName(), driver.getPhoneNumber());
    }

    public Point getLocation() {
        return location;
    }

    public CarModel getCar(){
        return car;
    }

}
