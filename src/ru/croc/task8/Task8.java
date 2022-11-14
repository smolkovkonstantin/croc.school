package ru.croc.task8;

import java.text.NumberFormat;
import java.util.Scanner;

public class Task8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Double money = scanner.nextDouble();

        NumberFormat format = NumberFormat.getCurrencyInstance();

        System.out.println(format.format(money));
        
    }
}
