package views;

import java.util.Scanner;

import data.Users;
import utils.Navigator;
import utils.Screen;

public class RegisterScreen extends Screen {
    Scanner scanner = new Scanner(System.in);

    @Override
    public void start() {
        System.out.println();
        System.out.println("=========================================================");
        System.out.println("\t\t   👇 Register");
        System.out.println();

        System.out.println("Please register to create account!");
        System.out.println();
        System.out.print("▶ Enter username: ");
        String username = scanner.nextLine();
        System.out.print("▶ Enter email: ");
        String email = scanner.nextLine();
        System.out.print("▶ Enter password: ");
        String password = scanner.nextLine();

        Users.register(email, password, username);
        System.out.println("  ✔️ User registered");
        Navigator.replace(new LoginScreen());
        ;
    }
}
