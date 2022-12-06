package ru.croc.task16.drivemobile;

public class Driver {

    private final String name;
    private final String phoneNumber;

    public Driver(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }


    protected String getName() {
        return name;
    }

    protected String getPhoneNumber() {
        return phoneNumber;
    }
}
