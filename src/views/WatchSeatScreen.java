package views;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import data.Bookings;
import utils.Layout;
import utils.Navigator;
import utils.Screen;

public class WatchSeatScreen extends Screen {
    Scanner scanner = new Scanner(System.in);

    @Override
    public void start() {
        System.out.println();
        System.out.println("=========================================================");
        System.out.println("\t\t   💺 Watch Seat");
        System.out.println();

        ArrayList<String> seats = new ArrayList<>();
        ArrayList<String> seatsPicked = new ArrayList<>();
        ArrayList<String> seatsSelected = new ArrayList<>();
        int rowCount = 6;
        int colCount = 8;

        for (int i = 1; i <= rowCount; i++) {
            for (int j = 1; j <= colCount; j++) {
                String seat = String.format("%c%d", (char) ('A' + i - 1), j);
                seats.add(seat);
            }
        }
        for (int i = 0; i < 10; i++) {
            ArrayList<String> newSeats = new ArrayList<>(seats);
            Collections.shuffle(newSeats);
            seatsPicked.add(newSeats.get(i));
        }

        System.out.println("\t\t   +===============+");
        System.out.println();
        for (int i = 1; i <= rowCount; i++) {
            System.out.print("\t");
            for (int j = 1; j <= colCount; j++) {
                String seat = String.format("%c%d", (char) ('A' + i - 1), j);
                if (seatsPicked.contains(seat)) {
                    System.out.print("[xx] ");
                } else {
                    System.out.print("[" + seat + "] ");
                }
            }
            System.out.println();
            System.out.println();
        }

        String[] menus = { "Select seat", "Back" };
        int selectedMenu = Layout.showMenu(menus);
        if (selectedMenu == 1) {
            int seatCount = Layout.selectOption(rowCount * colCount, "▶ How many seat you wan't to booking? ");
            int currentSeat = 1;
            while (currentSeat <= seatCount) {
                System.out.println();
                System.out.print("▶ Choose seat " + currentSeat + ": ");
                String seat = scanner.nextLine().toUpperCase();
                if (!seats.contains(seat)) {
                    System.out.println("  ✗ Input not valid!");
                } else if (seatsPicked.contains(seat) || seatsSelected.contains(seat)) {
                    System.out.println("  ✗ Seat already selected!");
                } else {
                    seatsSelected.add(seat);
                    System.out.println("  ✔️ Added " + seat);
                    currentSeat++;
                }
            }
            Bookings.addSeats(seatsSelected);
            Navigator.goTo(new FoodScreen());
        } else {
            Navigator.back();
        }
    }
}
