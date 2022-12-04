package ru.croc.task13.cinema;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Recommendation {
    private Recommendation() {
    }

    public static String get(List<Visitor> statistic, Visitor newVisitor) {
        Map<Movie, Double> suitableMovies = new HashMap<>();


        statistic.forEach(oldVisitor -> {

            double weight = Utility.correlation(oldVisitor.getViewedMovies(), newVisitor.getViewedMovies());
            if (weight > 0) {
                oldVisitor.getViewedMovies().forEach(movie -> {
                    if (!newVisitor.seenBefore(movie)) {
                        Utility.add(suitableMovies, movie, weight * oldVisitor.getViewOfMovie(movie));
                    }
                });

            }

        });

        return mostSuitableMovie(suitableMovies);
    }

    private static String mostSuitableMovie(Map<Movie, Double> suitableMovies) {
        double mx = 0.0;
        String result = null;

        for (Movie movie : suitableMovies.keySet()) {
            if (suitableMovies.get(movie) > mx) {
                mx = suitableMovies.get(movie);
                result = movie.getName();
            }
        }
        return result;
    }

}
