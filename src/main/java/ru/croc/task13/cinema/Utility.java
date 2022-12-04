package ru.croc.task13.cinema;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Класс выполняет необходимый функционал
 */
public class Utility {
    /**
     *
     * @param first входящее множетсво
     * @param second множество, по которому определяется степень совпадения
     * @return возрващает значение корреляции: 1 - полное совпадение, 0.7 - совпадение в интервале (50%:100%), 0.5 - совпадение на половину, 0 - менее чем на половину
     */

    public static <T> double correlation(Set<T> first, Set<T> second) {

        Set<?> sameFilm = new HashSet<>(first);

        sameFilm.retainAll(second);

        int size = second.size();

        if (sameFilm.size() == size) {
            return 1;
        } else if (sameFilm.size() > size / 2) {
            return 0.7;
        } else if (sameFilm.size() == size / 2) {
            return 0.5;
        } else {
            return 0;
        }
    }

    /**
     * @param map словарь, который будет изменён
     * @param key ключ по которому нужно добавлять value
     * @param value значение которое нужно добавлять
     */

    public static <K> void add(Map<K, Double> map, K key, Double value) {
        map.putIfAbsent(key, 0.0);
        map.put(key, map.get(key) + value);
    }
}
