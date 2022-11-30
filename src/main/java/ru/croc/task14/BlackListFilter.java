package ru.croc.task14;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Predicate;

public interface BlackListFilter<T> {

    /**
     * From the given list of comments removes ones
     * that contain words from the black list.
     *
     * @param comments  list of comments; every comment is an Object
     * @param condition the condition by which it is established that this object fits the condition
     */

    default Collection<?> filterComments(Iterable<T> comments, Predicate<T> condition) {
        Collection<T> result = new ArrayList<>();

        comments.forEach(comment -> {
            if (!condition.test(comment)) {
                result.add(comment);
            }
        });

        return result;
    }
}
