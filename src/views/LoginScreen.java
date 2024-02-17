package views;

import java.util.Scanner;

import data.Users;
import utils.Navigator;
import utils.Screen;

public class LoginScreen extends Screen {
    Scanner scanner = new Scanner(System.in);

    @Override
    public void start() {
        System.out.println();
        System.out.println("=========================================================");
        System.out.println("\t\t   👋 Login");
        System.out.println();

        System.out.println("Please login to continue!");
        System.out.println();

        boolean success = false;
        do {
            System.out.println();
            System.out.print("▶ Enter email: ");
            String email = scanner.nextLine();
            System.out.print("▶ Enter password: ");
            String password = scanner.nextLine();

            success = Users.login(email, password);
            if (success) {
                System.out.println("  ✔️ User logged");
                Navigator.replace(new HomeScreen());
                ;
            } else {
                System.out.println("  ✗ Username or password incorrect");
            }
        } while (!success);
    }
}
