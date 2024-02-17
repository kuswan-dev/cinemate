package views;

import java.util.stream.Collectors;

import data.Bookings;
import models.Booking;
import utils.CustomFormat;
import utils.Layout;
import utils.Navigator;
import utils.Screen;

public class TicketScreen extends Screen {
    Booking booking;

    public TicketScreen(int bookingId) {
        booking = Bookings.getById(bookingId);
    }

    @Override
    public void start() {
        System.out.println();
        System.out.println("=========================================================");
        System.out.println("\t\t   🎫 Your Ticket");

        String foodNames = booking.foods().stream().map(food -> food.name().replace(" ", ""))
                .collect(Collectors.joining(", "));

        for (String seat : booking.seats()) {
            System.out.println();
            System.out.println("\t+=======================================+");
            System.out.println("\t|          WELCOME TO CINEMATE          |");
            System.out.println("\t+=======================================+");
            System.out.println("\t|\t\t\t\t\t|");
            System.out.println("\t|  Movie : " + booking.movie().title());
            System.out.println("\t|  Seat\t : " + seat + "\t\t\t\t|");
            System.out.println("\t|  Time\t : " + CustomFormat.toLocaleDate(booking.showTime()) + "\t|");
            System.out.println("\t|\t\t\t\t\t|");
            System.out.println("\t )-------------------------------------(");
            System.out.println("\t|\t\t\t\t\t|");
            System.out.println("\t  " + foodNames);
            System.out.println("\t|\t\t\t\t\t|");
            System.out.println("\t+=======================================+");
        }

        System.out.println();
        String[] menus = { "Home", "Back" };
        int selectedMenu = Layout.showMenu(menus);
        if (selectedMenu == 1) {
            Navigator.replace(new HomeScreen());
        } else {
            Navigator.back();
        }
    }
}
