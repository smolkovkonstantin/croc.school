package ru.croc.task6;

import ru.croc.task6.DeleterComment.FileAnalysis;

public class Task6 {
    public static void main(String[] args) {
        FileAnalysis analysis = new FileAnalysis(".\\src\\ru\\croc\\task6\\DeleterComment\\Test.java");

        analysis.start();

        System.out.println(analysis.getResult());
    }


}
