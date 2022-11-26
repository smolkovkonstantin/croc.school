package ru.croc.task13.cinema;

import java.util.*;

/**
 * Класс предоставляет информацию какие фильмы в кинотеатре
 * @fild poster: key - номер фильма, value - название
 */

public class Films extends Cinema {

    private final Map<Integer, String> poster;

    public Films() {
        poster = new HashMap<>();
    }

    @Override
    public void add(String string) {
        String[] numberAndName = string.split(",");

        int number = Integer.parseInt(numberAndName[0]);
        String name = numberAndName[1];

        poster.put(number, name);
    }

    @Override
    public String toString() {
        return "Films{" +
                "poster=" + poster +
                '}';
    }

    public Map<Integer, String> getPoster() {
        return poster;
    }
}
