package views;

import data.Bookings;
import models.Booking;
import models.Food;
import utils.CustomFormat;
import utils.Layout;
import utils.Navigator;
import utils.Screen;

public class ConfirmPaymentScreen extends Screen {
    @Override
    public void start() {
        System.out.println();
        System.out.println("=========================================================");
        System.out.println("\t\t   🧾 Confirm Payment");
        System.out.println();

        Booking booking = Bookings.getLastBooking();
        int ticketPrice = booking.movie().price() * booking.seats().size();
        int foodsPrice = 0;

        System.out.println();
        System.out.println("\t========================================");
        System.out.println("\t\t   🧾 Payment Receipt");
        System.out.println("\t========================================");
        System.out.println();
        System.out.println("\t Ticket (" + booking.seats().size() + ")\t\t: " + CustomFormat.toRupiah(ticketPrice));
        for (Food food : booking.foods()) {
            System.out.println("\t " + food.name() + "\t\t: " + CustomFormat.toRupiah(food.price()));
            foodsPrice += food.price();
        }
        System.out.println();
        System.out.println("\t========================================");
        System.out.println("\t Payment\t\t: " + booking.payment());
        System.out.println("\t Total Price\t\t: " + CustomFormat.toRupiah(ticketPrice + foodsPrice));
        System.out.println();
        if (booking.paymentStatus() == "paid") {
            System.out.println("\t ✅ Already paid");
        } else {
            System.out.println("\t ⏳ Waiting for payment");
        }
        System.out.println("\t========================================");

        String[] menus = { "Continue Pay", "Back" };
        int selectedMenu = Layout.showMenu(menus);
        if (selectedMenu == 1) {
            Bookings.payLastBooking();
            Navigator.goTo(new TicketScreen(booking.id()));
        } else {
            Navigator.back();
        }
    }
}
