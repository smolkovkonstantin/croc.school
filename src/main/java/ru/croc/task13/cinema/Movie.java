package ru.croc.task13.cinema;

public class Movie {

    private final int number;
    private final String name;

    public Movie(String[] numberAndName){
        this.number = Integer.parseInt(numberAndName[0]);
        this.name = numberAndName[1];
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("%s: %s", number, name);
    }
}
