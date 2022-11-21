package ru.croc.task7;

import ru.croc.task7.chess.WayHorse;
import ru.croc.task7.chess.exceptions.IllegalMoveException;

import java.util.Scanner;

public class Task7 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        WayHorse wayHorse = new WayHorse(scanner.nextLine());

        try {
            wayHorse.isRightWay();
            System.out.println("OK");
        } catch (IllegalMoveException e) {
            System.out.println(e.getMessage());
        }

    }
}
