package ru.croc.task4.items.same;

public class InvalidFigure extends Exception {
    public InvalidFigure(){
        super("Such a figure doesn't exist");
    }
}
