package data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

import models.Movie;

public class Movies {
        static ArrayList<Movie> data = new ArrayList<>();

        static {
                data.add(new Movie(
                                1,
                                new String[] { "Adventure", "Drama", "Science Fiction" },
                                "English",
                                40000,
                                8.4,
                                2014,
                                "Interstellar"));
                data.add(new Movie(
                                2,
                                new String[] { "Drama", "Adventure", "Science Fiction" },
                                "English",
                                40000,
                                7.6,
                                2015,
                                "The Martian"));
                data.add(new Movie(
                                3,
                                new String[] { "Science Fiction", "Thriller", "Drama" },
                                "English",
                                40000,
                                7.2,
                                2013,
                                "Gravity"));
                data.add(new Movie(
                                4,
                                new String[] { "Adventure", "Science Fiction", "Action" },
                                "English",
                                40000,
                                8.2,
                                2019,
                                "Avengers: Endgame"));
                data.add(new Movie(
                                5,
                                new String[] { "Action", "Adventure", "Science Fiction" },
                                "English",
                                40000,
                                6.3,
                                2023,
                                "Ant-Man and the Wasp: Quantumania"));
                data.add(new Movie(
                                6,
                                new String[] { "Action", "Adventure", "Science Fiction" },
                                "English",
                                40000,
                                6.9,
                                2013,
                                "Iron Man 3"));
                data.add(new Movie(
                                7,
                                new String[] { "Science Fiction", "Adventure", "Action" },
                                "English",
                                40000,
                                6.4,
                                2019,
                                "Terminator: Dark Fat"));
                data.add(new Movie(
                                8,
                                new String[] { "Action", "Adventure", "Science Fiction" },
                                "English",
                                40000,
                                7.3,
                                2023,
                                "Transformers: Rise of the Beasts"));
                data.add(new Movie(
                                9,
                                new String[] { "Action", "Adventure", "Science Fiction" },
                                "English",
                                40000,
                                7.4,
                                2019,
                                "Spider-Man: Far From Home"));
                data.add(new Movie(
                                10,
                                new String[] { "Action", "Crime", "Drama" },
                                "English",
                                40000,
                                6.4,
                                2014,
                                "Need for Speed"));
                data.add(new Movie(
                                11,
                                new String[] { "Action", "Adventure" },
                                "English",
                                40000,
                                7.4,
                                2018,
                                "Mission: Impossible - Fallout"));
                data.add(new Movie(
                                12,
                                new String[] { "Action", "War", "History" },
                                "English",
                                40000,
                                7.3,
                                2001,
                                "Black Hawk Down"));
                data.add(new Movie(
                                13,
                                new String[] { "War", "Drama", "Action" },
                                "English",
                                40000,
                                7.5,
                                2014,
                                "Fury"));
                data.add(new Movie(
                                14,
                                new String[] { "Comedy", "Family", "Fantasy" },
                                "English",
                                40000,
                                7.2,
                                2023,
                                "Wonka"));
                data.add(new Movie(
                                15,
                                new String[] { "Action", "Thriller" },
                                "English",
                                40000,
                                6.6,
                                2024,
                                "One More Shot"));
                data.add(new Movie(
                                16,
                                new String[] { "Science Fiction", "Adventure", "Action" },
                                "English",
                                40000,
                                6.2,
                                2023,
                                "The Marvels"));
                data.add(new Movie(
                                17,
                                new String[] { "Action", "Comedy", "Crime" },
                                "English",
                                40000,
                                6.5,
                                2024,
                                "Lift"));
                data.add(new Movie(
                                18,
                                new String[] { "Horror", "Thriller" },
                                "English",
                                40000,
                                6.6,
                                2023,
                                "Evil Dead Rise"));
                data.add(new Movie(
                                19,
                                new String[] { "Action", "Crime", "Thriller" },
                                "English",
                                40000,
                                6.9,
                                2023,
                                "Silent Night"));
                data.add(new Movie(
                                20,
                                new String[] { "Action", "Adventure", "Fantasy" },
                                "English",
                                40000,
                                6.9,
                                2023,
                                "Aquaman and the Lost Kingdom"));
        }

        public static ArrayList<Movie> getAll() {
                return data;
        }

        public static Movie getById(int id) {
                return data.stream().filter(item -> item.id() == id).toArray(Movie[]::new)[0];
        }

        public static ArrayList<Movie> getPopular() {
                Collections.shuffle(data);
                return new ArrayList<>(data.subList(0, 5));
        }

        public static ArrayList<Movie> searchMovie(String keyword) {
                return data.stream()
                                .filter(movie -> movie.title().toLowerCase().contains(keyword.toLowerCase()))
                                .collect(Collectors.toCollection(ArrayList::new));
        }
}
