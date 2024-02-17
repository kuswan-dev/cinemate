package views;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import data.Bookings;
import models.Movie;
import utils.CustomFormat;
import utils.Layout;
import utils.Navigator;
import utils.Screen;

public class ShowTimeScreen extends Screen {
    @Override
    public void start() {
        System.out.println();
        System.out.println("=========================================================");
        System.out.println("\t\t   🕒 Show Time Movie");
        System.out.println();

        Movie movie = Bookings.getMovie();
        System.out.println("Show time for " + movie.title() + ":");

        ArrayList<Date> dates = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        for (int i = 0; i < 5; i++) {
            calendar.add(Calendar.HOUR_OF_DAY, i * 2);
            dates.add(calendar.getTime());
        }

        int number = 1;
        for (Date date : dates) {
            System.out.println("   " + number + ". " + CustomFormat.toLocaleDate(date));
            number++;
        }

        String[] menus = { "Back" };
        int selectedMenu = Layout.showMenu(menus, dates.size() + 1);
        if (selectedMenu <= dates.size()) {
            Date date = dates.get(selectedMenu - 1);
            Bookings.addShowTime(date);
            Navigator.goTo(new WatchSeatScreen());
        } else {
            Navigator.back();
        }
    }
}
