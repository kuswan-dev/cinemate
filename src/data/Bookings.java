package data;

import java.util.ArrayList;
import java.util.Date;

import models.Booking;
import models.Food;
import models.Movie;

public class Bookings {
    static ArrayList<Booking> data = new ArrayList<>();

    static Movie movieSelected;
    static Date showTimeSelected;
    static ArrayList<String> seatsSelected;
    static ArrayList<Food> foodsSelected = new ArrayList<>();
    static String paymentSelected;

    public static void addMovie(Movie movie) {
        movieSelected = movie;
    }

    public static void addShowTime(Date showTime) {
        showTimeSelected = showTime;
    }

    public static void addSeats(ArrayList<String> seats) {
        seatsSelected = seats;
    }

    public static void addFoodsSelected(ArrayList<Food> foods) {
        foodsSelected = foods;
    }

    public static void addPaymentSelected(String payment) {
        paymentSelected = payment;
    }

    public static Booking createBooking() {
        Booking booking = new Booking(
                0,
                new Date(),
                foodsSelected,
                movieSelected,
                paymentSelected,
                "unpaid",
                seatsSelected,
                showTimeSelected);
        data.add(booking);
        return booking;
    }

    public static ArrayList<Booking> getAll() {
        return data;
    }

    public static Booking getById(int id) {
        return data.stream().filter(item -> item.id() == id).toArray(Booking[]::new)[0];
    }

    public static Booking getLastBooking() {
        return data.get(data.size() - 1);
    }

    public static Movie getMovie() {
        return movieSelected;
    }

    public static void payLastBooking() {
        int lastIndex = data.size() - 1;
        Booking lastBooking = data.get(lastIndex);
        Booking newBooking = new Booking(
                lastBooking.id(),
                lastBooking.createdAt(),
                lastBooking.foods(),
                lastBooking.movie(),
                lastBooking.payment(),
                "paid",
                lastBooking.seats(),
                lastBooking.showTime());
        data.set(lastIndex, newBooking);
    }
}
