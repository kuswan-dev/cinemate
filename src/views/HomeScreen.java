package views;

import data.Users;
import models.User;
import utils.Layout;
import utils.Navigator;
import utils.Screen;

public class HomeScreen extends Screen {
    @Override
    public void start() {
        System.out.println();
        System.out.println("=========================================================");
        System.out.println(
                "\t  ____ _            __  __       _\n" +
                        "\t / ___(_)_ __   ___|  \\/  | __ _| |_ ___\n" +
                        "\t| |   | | '_ \\ / _ \\ |\\/| |/ _` | __/ _ \\\n" +
                        "\t| |___| | | | |  __/ |  | | (_| | ||  __/\n" +
                        "\t \\____|_|_| |_|\\___|_|  |_|\\__,_|\\__\\___|");
        System.out.println();
        System.out.println();

        User user = Users.getCurrentUser();
        if (user != null) {
            String[] menus = { "Popular", "Search", "Favorite", "Booking", "Profile", "Logout", "Exit" };
            int selectedMenu = Layout.showMenu(menus);
            switch (selectedMenu) {
                case 1:
                    Navigator.goTo(new PopularScreen());
                    break;
                case 2:
                    Navigator.goTo(new SearchScreen());
                    break;
                case 3:
                    Navigator.goTo(new FavoriteScreen());
                    break;
                case 4:
                    Navigator.goTo(new BookingScreen());
                    break;
                case 5:
                    Navigator.goTo(new ProfileScreen());
                    break;
                case 6:
                    Users.logout();
                    Navigator.refresh();
                    break;
                default:
                    break;
            }
        } else {
            String[] menus = { "Login", "Register" };
            int selectedMenu = Layout.showMenu(menus);
            switch (selectedMenu) {
                case 1:
                    Navigator.goTo(new LoginScreen());
                    break;
                case 2:
                    Navigator.goTo(new RegisterScreen());
                    break;
            }
        }
    }
}
