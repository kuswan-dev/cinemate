package views;

import java.util.ArrayList;

import data.Favorites;
import models.Movie;
import utils.Layout;
import utils.Navigator;
import utils.Screen;

public class FavoriteScreen extends Screen {
    @Override
    public void start() {
        System.out.println();
        System.out.println("=========================================================");
        System.out.println("\t\t   ⭐ Favorite Movies");
        System.out.println();

        ArrayList<Movie> movies = Favorites.getAll();
        if (movies.isEmpty()) {
            System.out.println("  ✗ Empty data.");
        } else {
            Layout.showMovieCard(movies);
        }

        String[] menus = { "Back" };
        int selectedMenu = Layout.showMenu(menus, movies.size() + 1);
        if (selectedMenu <= movies.size()) {
            System.out.println();
            int movieId = movies.get(selectedMenu - 1).id();
            Navigator.goTo(new MovieDetailScreen(movieId));
        } else {
            Navigator.back();
        }
    }
}
