package models;

import java.util.ArrayList;
import java.util.Date;

public record Booking(
        int id,
        Date createdAt,
        ArrayList<Food> foods,
        Movie movie,
        String payment,
        String paymentStatus,
        ArrayList<String> seats,
        Date showTime) {
}
