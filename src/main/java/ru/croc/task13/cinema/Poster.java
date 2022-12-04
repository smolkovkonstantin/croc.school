package ru.croc.task13.cinema;

import java.util.List;

public class Poster {

    private final List<Movie> poster;

    public Poster(List<Movie> poster) {
        this.poster = poster;
    }

    public Movie findFilmByNumber(int number){
        Movie result = null;

        for (Movie film: poster){
            if (number == film.getNumber()){
                result = film;
            }
        }

        if (result == null){
            throw new NullPointerException();
        }

        return result;
    }

    @Override
    public String toString() {
        return "Poster{" +
                "poster=" + poster +
                '}';
    }
}
