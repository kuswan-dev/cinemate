package views;

import java.util.ArrayList;
import java.util.Scanner;

import data.Movies;
import models.Movie;
import utils.Layout;
import utils.Navigator;
import utils.Screen;

public class SearchScreen extends Screen {
    Scanner scanner = new Scanner(System.in);

    @Override
    public void start() {
        System.out.println();
        System.out.println("=========================================================");
        System.out.println("\t\t   🔎 Search Movie");
        System.out.println();

        boolean reSearching = false;

        do {
            System.out.println();
            System.out.print("▶ Insert movie name: ");
            String keyword = scanner.nextLine();
            ArrayList<Movie> movies = Movies.searchMovie(keyword);
            if (movies.isEmpty()) {
                System.out.println("  ✗ Movie not found!");
                reSearching = true;
            } else {
                reSearching = false;
                System.out.println("  ✔️ " + movies.size() + " movies found!");
                Layout.showMovieCard(movies);

                String[] menus = { "Search another movie", "Back" };
                int selectedMenu = Layout.showMenu(menus, movies.size() + 1);

                if (selectedMenu <= movies.size()) {
                    int movieId = movies.get(selectedMenu - 1).id();
                    Navigator.goTo(new MovieDetailScreen(movieId));
                } else if (selectedMenu == movies.size() + 1) {
                    reSearching = true;
                } else {
                    Navigator.back();
                }
            }
        } while (reSearching);
    }
}
