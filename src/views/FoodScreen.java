package views;

import java.util.ArrayList;
import java.util.Scanner;

import data.Bookings;
import data.Foods;
import models.Food;
import utils.CustomFormat;
import utils.Layout;
import utils.Navigator;
import utils.Screen;

public class FoodScreen extends Screen {
    Scanner scanner = new Scanner(System.in);

    @Override
    public void start() {
        System.out.println();
        System.out.println("=========================================================");
        System.out.println("\t\t   🍿 Snack & Drink");
        System.out.println();

        ArrayList<Food> foods = Foods.getAll();
        int number = 1;
        for (Food food : foods) {
            System.out.println("\t" + number + ". " + food.name() + "\t\t" + CustomFormat.toRupiah(food.price()));
            number++;
        }

        String[] menus = { "Continue Booking", "Back" };
        int selectedMenu = Layout.showMenu(menus, foods.size() + 1);
        if (selectedMenu <= foods.size()) {
            ArrayList<Food> foodsSelected = new ArrayList<>();
            Food food = foods.get(selectedMenu - 1);
            foodsSelected.add(food);
            System.out.println("  ✔️ Added " + food.name());
            boolean addOtherMenu = false;

            do {
                System.out.println();
                System.out.print("▶ Add other snack & drink? (yes/no) ");
                String answer = scanner.nextLine();
                if (answer.equalsIgnoreCase("no")) {
                    Bookings.addFoodsSelected(foodsSelected);
                    Navigator.goTo(new PaymentScreen());
                } else {
                    System.out.println();
                    int foodNumber = Layout.selectOption(foods.size(), "▶ Choose snack & drink: ");
                    Food otherFood = foods.get(foodNumber - 1);
                    foodsSelected.add(otherFood);
                    System.out.println("  ✔️ Added " + otherFood.name());
                    addOtherMenu = true;
                }
            } while (addOtherMenu);
        } else if (selectedMenu == foods.size() + 1) {
            Navigator.goTo(new PaymentScreen());
        } else {
            Navigator.back();
        }
    }
}
