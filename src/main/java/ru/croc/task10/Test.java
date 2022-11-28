package ru.croc.task10;

public class Test {
    public static void main(String[] args) {
        long i = 1;
        for (int j = 0; j < 1000; j ++){
             i += Math.round(Math.random() * (10000 - i) + i) % 500 + 1;
            System.out.println(i);
        }
    }
}
