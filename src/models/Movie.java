package models;

public record Movie(
        int id,
        String[] genres,
        String language,
        int price,
        double rating,
        int releaseYear,
        String title) {
}
