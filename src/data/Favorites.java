package data;

import java.util.ArrayList;

import models.Movie;

public class Favorites {
    static ArrayList<Movie> data = new ArrayList<>();

    public static void add(Movie movie) {
        data.add(movie);
    }

    public static ArrayList<Movie> getAll() {
        return data;
    }

    public static boolean isFavorited(int movieId) {
        return data.stream().anyMatch(movie -> movie.id() == movieId);
    }

    public static void remove(int movieId) {
        data.removeIf(movie -> movie.id() == movieId);
    }
}
