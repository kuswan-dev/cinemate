package data;

import java.util.ArrayList;

import models.Food;

public class Foods {
    static ArrayList<Food> data = new ArrayList<>();

    static {
        data.add(new Food("Popcorn  ", 30000));
        data.add(new Food("Fries    ", 25000));
        data.add(new Food("Chips    ", 20000));
        data.add(new Food("Nachos   ", 35000));
        data.add(new Food("Sprite   ", 10000));
        data.add(new Food("Coffee   ", 15000));
        data.add(new Food("Milkshake", 18000));
        data.add(new Food("Water    ", 10000));
    }

    public static ArrayList<Food> getAll() {
        return data;
    }
}
