package ru.croc.task13;


import ru.croc.reader.MyReader;
import ru.croc.task13.cinema.Poster;
import ru.croc.task13.cinema.Recommendation;
import ru.croc.task13.cinema.Visitor;

import java.util.List;
import java.util.Scanner;

public class Task13 {

    final static String POSTER = ".\\src\\main\\java\\ru\\croc\\task13\\poster.txt";
    final static String CLIENT_HISTORY = ".\\src\\main\\java\\ru\\croc\\task13\\client history.txt";

    public static void main(String[] args) {
        Poster poster = new Poster(MyReader.readTask13(POSTER));

        List<Visitor> statistics = MyReader.readTask13(CLIENT_HISTORY, poster);

        Scanner scanner = new Scanner(System.in);

        Visitor visitor = new Visitor(scanner.nextLine());
        visitor.compileStatistics(poster);

        System.out.println(Recommendation.get(statistics, visitor));

    }
}
