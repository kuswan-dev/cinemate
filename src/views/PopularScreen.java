package views;

import java.util.ArrayList;
import java.util.Scanner;

import data.Movies;
import models.Movie;
import utils.Layout;
import utils.Navigator;
import utils.Screen;

public class PopularScreen extends Screen {
    Scanner scanner = new Scanner(System.in);

    @Override
    public void start() {
        System.out.println();
        System.out.println("=========================================================");
        System.out.println("\t\t   ✨ Popular Movies");
        System.out.println();

        ArrayList<Movie> movies = Movies.getPopular();
        Layout.showMovieCard(movies);

        String[] menus = { "Back" };
        int selectedMenu = Layout.showMenu(menus, movies.size() + 1);

        if (selectedMenu <= movies.size()) {
            int movieId = movies.get(selectedMenu - 1).id();
            Navigator.goTo(new MovieDetailScreen(movieId));
        } else {
            Navigator.back();
        }
    }
}
