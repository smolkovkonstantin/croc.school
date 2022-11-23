package ru.croc.task12.filter;

import ru.croc.task12.searching.MySearchAlgorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FilterBadWord implements BlackListFilter {

    final static int countThreads = 1;
    private final List<String> allFilteredString = new ArrayList<>();

    @Override
    public void filterComments(List<String> comments, Set<String> blackList) {
        ExecutorService executor = Executors.newFixedThreadPool(countThreads);

        List<Future<String>> futures = new ArrayList<>(comments.size());

        for (int i = 0; i < comments.size(); i++) {

            int finalI = i;

            futures.add(
                    executor.submit(() -> {
                        MySearchAlgorithm algorithm = new MySearchAlgorithm();
                        return algorithm.replaceAllBadWord(blackList, comments.get(finalI));
                    })
            );
        }

        for (Future<String> future : futures) {
            try {
                String filteredString = future.get();

                allFilteredString.add(filteredString);

            } catch (InterruptedException | ExecutionException e) {
//                executor.shutdownNow();
                throw new RuntimeException(e);
            }
        }

        executor.shutdownNow();
    }

    public List<String> getAllFilteredString() {
        return allFilteredString;
    }
}
