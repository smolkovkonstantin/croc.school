package ru.croc.task13;


import ru.croc.reader.MyReader;
import ru.croc.task13.cinema.Films;
import ru.croc.task13.cinema.InformationUser;
import ru.croc.task13.cinema.Recommendation;
import ru.croc.task13.cinema.User;

import java.util.Scanner;

public class Task13 {

    final static String POSTER = ".\\src\\main\\java\\ru\\croc\\task13\\poster.txt";
    final static String CLIENT_HISTORY = ".\\src\\main\\java\\ru\\croc\\task13\\client history.txt";

    public static void main(String[] args) {
        Films films = MyReader.readTask13(POSTER);

        InformationUser users = MyReader.readTask13User(CLIENT_HISTORY);

        Scanner scanner = new Scanner(System.in);

        User user = new User(scanner.nextLine());

        System.out.println(Recommendation.get(user, users, films));

    }
}
