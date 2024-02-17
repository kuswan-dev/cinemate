package views;

import java.util.ArrayList;

import data.Bookings;
import data.Payments;
import utils.Layout;
import utils.Navigator;
import utils.Screen;

public class PaymentScreen extends Screen {

    @Override
    public void start() {
        System.out.println();
        System.out.println("=========================================================");
        System.out.println("\t\t   💸 Payment Method");
        System.out.println();

        System.out.println("💸 Payment available:");
        ArrayList<String> payments = Payments.getAll();
        int number = 1;
        for (String payment : payments) {
            System.out.println("   " + number + ". " + payment);
            number++;
        }

        String[] menus = { "Back" };
        int selectedMenu = Layout.showMenu(menus, payments.size() + 1);
        if (selectedMenu <= payments.size()) {
            String payment = payments.get(selectedMenu - 1);
            Bookings.addPaymentSelected(payment);
            Bookings.createBooking();
            Navigator.goTo(new ConfirmPaymentScreen());
        } else {
            Navigator.back();
        }
    }
}
