package views;

import java.util.ArrayList;

import data.Bookings;
import models.Booking;
import utils.CustomFormat;
import utils.Layout;
import utils.Navigator;
import utils.Screen;

public class BookingScreen extends Screen {
    @Override
    public void start() {
        System.out.println();
        System.out.println("=========================================================");
        System.out.println("\t\t   ⌛ Booking History");
        System.out.println();

        ArrayList<Booking> bookings = Bookings.getAll();

        if (bookings.isEmpty()) {
            System.out.println("   Empty Data.");
        } else {
            int index = 1;
            for (Booking booking : bookings) {
                System.out.println("\t+───────────────────────────────────────+");
                System.out.println(
                        "    " + index + ".  | 🕒 " + CustomFormat.toLocaleDate(booking.createdAt()) + "\t\t|");
                System.out.println("\t| 🎬 " + booking.movie().title());
                System.out.println("\t| 🎫 " + booking.seats().size() + " Ticket\t\t\t\t|");
                if (booking.paymentStatus() == "paid") {
                    System.out.println("\t| ✅ Already paid\t\t\t|");
                } else {
                    System.out.println("\t| ⏳ Waiting for payment\t\t\t|");
                }
                System.out.println("\t+───────────────────────────────────────+");
                index++;
            }
        }

        String[] menus = { "Back" };
        int selectedMenu = Layout.showMenu(menus, bookings.size() + 1);

        if (selectedMenu <= bookings.size()) {
            int bookingId = bookings.get((selectedMenu - 1)).id();
            Navigator.goTo(new TicketScreen(bookingId));
        } else {
            Navigator.back();
        }
    }
}
