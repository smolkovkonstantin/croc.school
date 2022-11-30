package ru.croc.task13.cinema;

import java.util.*;

/**
 * Класс содержит общую статистику всех фильмов и каждого отдельного пользователя
 */

public class InformationUser extends Cinema {

    private final Map<Integer, Integer> statistic;
    private final List<User> users;


    public InformationUser() {
        statistic = new HashMap<>();
        users = new ArrayList<>();
    }

    public void add(String input) {

        User user = new User(input);

        users.add(user);

        for (Integer key: user.getHistoryUser().keySet()){
            statistic.putIfAbsent(key, 0);
            statistic.put(key, statistic.get(key) + user.getHistoryUser().get(key));
        }
    }

    public int mostPopular(){
        int result = 0;
        int max = 0;

        for (int key: statistic.keySet()){
            if (max < statistic.get(key)){
                max = statistic.get(key);
                result = key;
            }
        }

        return result;
    }

    @Override
    public String toString() {
        return "InformationUser{\n" +
                "\tstatistic=" + statistic +
                ",\n\tusers=" + users +
                "\n}";
    }

    protected List<User> getUsers() {
        return users;
    }
}
