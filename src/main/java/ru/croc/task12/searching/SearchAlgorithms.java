package ru.croc.task12.searching;


/**
 * Интерфейс указывает, что расширяемый класс должен
 * быть алгоритмом поиска
 */

public interface SearchAlgorithms {
    int find(String subString, String string);
    default boolean subStringLongerString(String subString, String string){
        return subString.length() > string.length();
    }
}
