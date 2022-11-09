package ru.croc.task4.items.same;

public class InvalidFigure extends RuntimeException {
    public InvalidFigure(){
        super("Such a figure doesn't exist");
    }
}
