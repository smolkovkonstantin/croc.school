package ru.croc.task12;

import ru.croc.task12.filter.FilterBadWord;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Task12 {
    public static void main(String[] args) {
        List<String> comments = new ArrayList<>(List.of(
                "there is a deep meaning in this string",
                "This a random string that doesn't make any sense",
                "morgenstern's tracks are very good"
        ));

        Set<String> badWords = new HashSet<>(Set.of(
                "Morgenstern",
                "string",
                "this",
                "th"
        ));

        FilterBadWord blackListFilter = new FilterBadWord();

        blackListFilter.filterComments(comments, badWords);

        blackListFilter.getAllFilteredString().forEach(System.out::println);
    }
}
