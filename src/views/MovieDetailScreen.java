package views;

import java.util.Scanner;

import data.Bookings;
import data.Favorites;
import data.Movies;
import models.Movie;
import utils.CustomFormat;
import utils.Layout;
import utils.Navigator;
import utils.Screen;

public class MovieDetailScreen extends Screen {
    Scanner scanner = new Scanner(System.in);
    Movie movie;

    public MovieDetailScreen(int movieId) {
        movie = Movies.getById(movieId);
    }

    @Override
    public void start() {
        System.out.println();
        System.out.println("=========================================================");
        System.out.println("\t\t   🧩 Movie Detail");
        System.out.println();
        System.out.println("\t🎬 " + movie.title());
        System.out.println("\t⭐ " + movie.rating() + " - " + movie.releaseYear());
        System.out.println("\t🎭 " + String.join(", ", movie.genres()));
        System.out.println("\t🔠 " + movie.language());
        System.out.println();
        System.out.println("\t🎫 " + CustomFormat.toRupiah(movie.price()));
        System.out.println();

        boolean reShowingMenu = false;
        do {
            boolean isFavorited = Favorites.isFavorited(movie.id());
            String[] menus = { "Watch movie", "Save to favorite", "Back" };
            if (isFavorited) {
                menus[1] = "Remove from favorite";
            }
            int selectedmenu = Layout.showMenu(menus, 1);

            switch (selectedmenu) {
                case 1:
                    Bookings.addMovie(movie);
                    Navigator.goTo(new ShowTimeScreen());
                    break;
                case 2:
                    if (isFavorited) {
                        Favorites.remove(movie.id());
                        System.out.println("  ✔️ Removed from favorite!");
                    } else {
                        Favorites.add(movie);
                        System.out.println("  ✔️ Added to favorite!");
                    }
                    reShowingMenu = true;
                    break;
                default:
                    Navigator.back();
                    break;
            }
        } while (reShowingMenu);
    }
}
