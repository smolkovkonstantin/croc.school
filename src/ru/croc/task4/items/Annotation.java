package ru.croc.task4.items;


import ru.croc.task4.items.same.Figure;

public class Annotation {
    private final String signature;
    private final Figure figure;

    public Annotation(Figure figure, String signature) {
        this.signature = signature;
        this.figure = figure;
    }

    @Override
    public String toString() {
        return figure.toString() + signature;
    }

    public String getSignature() {
        return signature;
    }

    public Figure getFigure() {
        return figure;
    }
}