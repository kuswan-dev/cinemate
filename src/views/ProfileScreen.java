package views;

import data.Users;
import models.User;
import utils.Layout;
import utils.Navigator;
import utils.Screen;

public class ProfileScreen extends Screen {
    @Override
    public void start() {
        System.out.println();
        System.out.println("=========================================================");
        System.out.println("\t\t   👤 My Profile");
        System.out.println();

        User user = Users.getCurrentUser();
        System.out.println("   Username: " + user.username());
        System.out.println("   Email: " + user.email());

        String[] menus = { "Back" };
        int selectedMenu = Layout.showMenu(menus);
        if (selectedMenu == 1) {
            Navigator.back();
        }
    }
}
