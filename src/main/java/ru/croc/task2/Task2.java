package ru.croc.task2;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        int first, diff, n;

        if (args.length == 0) {
            Scanner scanner = new Scanner(System.in);
            first = scanner.nextInt();
            diff = scanner.nextInt();
            n = scanner.nextInt();
        } else {
            first = Integer.parseInt(args[0]);
            diff = Integer.parseInt(args[1]);
            n = Integer.parseInt(args[2]);
        }

        System.out.println(sumOfProgression(first, diff, n));
    }

    public static int sumOfProgression(int first, int diff, int n) {
        int result = first;
        for (int i = 1; i < n; i++) {
            first += diff;
            result += first;
        }
        return result;
    }

}
