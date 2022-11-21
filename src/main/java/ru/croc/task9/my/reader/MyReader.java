package ru.croc.task9.my.reader;

import java.util.Scanner;

public class MyReader {
    private MyReader() {
    }

    public static String[] readTask9(String[] args) {
        if (args.length > 0) {
            return args;
        } else {
            Scanner scanner = new Scanner(System.in);
            return scanner.nextLine().split(" ");
        }
    }
}
