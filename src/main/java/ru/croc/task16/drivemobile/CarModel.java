package ru.croc.task16.drivemobile;

import java.util.ArrayList;
import java.util.List;

public class CarModel {

    private final String clazz;
    private final List<String> options;

    public CarModel(String clazz, String... options) {
        this.clazz = clazz;
        this.options = new ArrayList<>(List.of(options));
    }

    protected String getClazz() {
        return clazz;
    }

    public List<String> getOptions() {
        return options;
    }
}
