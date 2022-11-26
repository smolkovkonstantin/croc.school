package ru.croc.task13.cinema;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Recommendation {

    public static String get(User newUser, InformationUser information, Films films) {
        Map<Integer, Double> recommendDict = new HashMap<>();
        for (User user : information.getUsers()) {
            double weight = sameFilms(newUser, user);
            if (weight != 0) {
                anotherFilms(newUser, user).forEach(key -> {
                    recommendDict.putIfAbsent(key, 0.0);
                    recommendDict.put(key, recommendDict.get(key) + weight);
                });
            }
        }

        int result = max(recommendDict);

        if (result == -1){
            result = information.mostPopular();
        }

        return films.getPoster().get(result);
    }

    private static int max(Map<Integer, Double> map) {
        int numberFilm = -1;
        double weight = 0;
        for (Integer key : map.keySet()) {
            if (weight < map.get(key)) {
                numberFilm = key;
                weight = map.get(key);
            }
        }
        return numberFilm;
    }

    private static List<Integer> anotherFilms(User newUser, User oldUser) {
        List<Integer> result = new ArrayList<>();
        for (int key : oldUser.getKeys()) {
            if (newUser.getValue(key) == null) {
                result.add(key);
            }
        }
        return result;
    }

    private static double sameFilms(User newUser, User oldUser) {
        int result = 0;
        int count = 0;

        for (int key : newUser.getKeys()) {
            if (oldUser.getValue(key) != null) {
                result += 1;
            }
            count++;
        }
        if (result == 0) {
            return 0;
        }
        if (count == result) {
            return 1;
        }
        if (result > count / 2) {
            return 0.7;
        }
        if (result == count / 2) {
            return 0.5;
        }
        return 0;
    }
}
