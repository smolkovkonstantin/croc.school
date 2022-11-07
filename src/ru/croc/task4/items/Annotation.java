package ru.croc.task4.items;


import ru.croc.task4.items.same.Figure;
import ru.croc.task4.items.same.figure.Circle;
import ru.croc.task4.items.same.figure.Rectangle;

public class Annotation {
    private final String signature;
    private final Figure figure;

    public Annotation(Figure figure, String signature) {
        this.signature = signature;
        this.figure = figure;
    }

    @Override
    public String toString() {
        StringBuilder allPointToString = new StringBuilder();

        for (int i = 0; i < figure.getPoints().length; i ++){
            allPointToString.append(String.format(
                    (i == figure.getPoints().length - 1) ? "(%s, %s)" : "(%s, %s), ",
                    figure.getPoints()[i].getX(), figure.getPoints()[i].getY()));
        }

        if (figure instanceof Circle){
            return String.format("%s %s, %s: %s", figure.getName(), allPointToString, ((Circle) figure).getRadius(), signature);
        }
        if (figure instanceof Rectangle){
            return String.format("%s %s: %s", figure.getName(), allPointToString, signature);
        }
        return "Unknown figure";
    }

    public String getSignature() {
        return signature;
    }

    public Figure getFigure() {
        return figure;
    }
}