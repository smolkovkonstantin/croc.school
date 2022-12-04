package ru.croc.task13.cinema;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Visitor {

    private final Map<Movie, Double> visitorStatistic = new HashMap<>();

    private final int[] viewedFilms;

    public Visitor(String string) {
        String[] strings = string.split(",");

        viewedFilms = new int[strings.length];

        for (int i = 0; i < viewedFilms.length; i++) {
            viewedFilms[i] = Integer.parseInt(strings[i]);
        }
    }

    public void compileStatistics(Poster poster) {
        for (int number : viewedFilms) {
            Movie movie = poster.findFilmByNumber(number);
            Utility.add(visitorStatistic, movie, 1.0);
        }
    }

    protected Set<Movie> getViewedMovies() {
        return visitorStatistic.keySet();
    }

    protected Double getViewOfMovie(Movie movie) {
        return visitorStatistic.get(movie);
    }

    protected boolean seenBefore(Movie movie){
        return getViewOfMovie(movie) != null;
    }

    @Override
    public String toString() {
        return "Visitor{" +
                "visitorStatistic=" + visitorStatistic +
                "}\n";
    }
}
