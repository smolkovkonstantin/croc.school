package ru.croc.task13.cinema;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Класс содержит информацию о конкретном пользователе:
 * Какие фильмы (по ключу
 */

public class User {

    private final Map<Integer, Integer> historyUser = new HashMap<>();

    public User(String string) {
        String[] stringNumber = string.split(",");

        int[] number = new int[stringNumber.length];

        for (int i = 0; i < number.length; i++) {
            number[i] = Integer.parseInt(stringNumber[i]);

            historyUser.putIfAbsent(number[i], 0);
            historyUser.put(number[i], historyUser.get(number[i]) + 1);
        }
    }

    protected Map<Integer, Integer> getHistoryUser() {
        return historyUser;
    }

    protected Integer getValue(Integer key){
        return historyUser.get(key);
    }

    protected Set<Integer> getKeys(){
        return getHistoryUser().keySet();
    }

    @Override
    public String toString() {
        return historyUser.toString();
    }
}
