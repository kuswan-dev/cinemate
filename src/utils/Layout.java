package utils;

import java.util.ArrayList;
import java.util.Scanner;

import models.Movie;

public class Layout {
    public static int showMenu(String[] menus) {
        Scanner scanner = new Scanner(System.in);
        int selectedNumber = 0;
        boolean isValid = false;

        System.out.println();
        System.out.println("☰ Menu");
        for (int i = 0; i < menus.length; i++) {
            System.out.println("   " + (i + 1) + ". " + menus[i]);
        }
        System.out.println();
        System.out.print("▶ Choose menu: ");

        while (!isValid) {
            if (scanner.hasNextInt()) {
                selectedNumber = scanner.nextInt();
                if (selectedNumber <= menus.length && selectedNumber > 0) {
                    isValid = true;
                } else {
                    System.out.println("  ✗ Input not valid!");
                    System.out.println();
                    System.out.print("▶ Choose menu: ");
                }
            } else {
                System.out.println("  ✗ Input not valid!");
                System.out.println();
                System.out.print("▶ Choose menu: ");
                scanner.next();
            }
        }
        return selectedNumber;
    }

    public static int showMenu(String[] menus, int startNumber) {
        Scanner scanner = new Scanner(System.in);
        int selectedNumber = 0;
        boolean isValid = false;

        System.out.println();
        System.out.println("☰ Menu");
        for (int i = 0; i < menus.length; i++) {
            System.out.println("   " + (i + startNumber) + ". " + menus[i]);
        }
        System.out.println();
        System.out.print("▶ Choose menu: ");

        while (!isValid) {
            if (scanner.hasNextInt()) {
                selectedNumber = scanner.nextInt();
                if (selectedNumber > 0 && selectedNumber < (menus.length + startNumber)) {
                    isValid = true;
                } else {
                    System.out.println("  ✗ Input not valid!");
                    System.out.println();
                    System.out.print("▶ Choose menu: ");
                }
            } else {
                System.out.println("  ✗ Input not valid!");
                System.out.println();
                System.out.print("▶ Choose menu: ");
                scanner.next();
            }
        }
        return selectedNumber;
    }

    public static int selectOption(int optionCount, String instruction) {
        Scanner scanner = new Scanner(System.in);
        int input = 0;
        boolean isValid = false;

        System.out.print(instruction);
        while (!isValid) {
            if (scanner.hasNextInt()) {
                input = scanner.nextInt();
                if (input <= optionCount && input > 0) {
                    isValid = true;
                } else {
                    System.out.println("  ✗ Input not valid!");
                    System.out.println();
                    System.out.print(instruction);
                }
            } else {
                System.out.println("  ✗ Input not valid!");
                System.out.println();
                System.out.print(instruction);
                scanner.next();
            }
        }
        return input;
    }

    public static void showMovieCard(ArrayList<Movie> movies) {
        int index = 1;
        for (Movie movie : movies) {
            System.out.println("\t+───────────────────────────────────────+");
            System.out.println("    " + index + ".  | 🎬 " + movie.title());
            System.out.println("\t| ⭐ " + movie.rating() + " - " + movie.releaseYear() + "\t\t\t\t|");
            System.out.println("\t| 🎭 " + String.join(", ", movie.genres()));
            System.out.println("\t| 🔠 " + movie.language() + "\t\t\t\t|");
            System.out.println("\t+───────────────────────────────────────+");
            index++;
        }
    }
}
