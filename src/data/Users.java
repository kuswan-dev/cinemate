package data;

import java.util.ArrayList;
import java.util.Optional;

import models.User;

public class Users {
    static ArrayList<User> data = new ArrayList<>();
    static User currentUser;

    public static User getCurrentUser() {
        return currentUser;
    }

    public static boolean login(String email, String password) {
        Optional<User> userData = data.stream().filter(
                user -> user.email().equalsIgnoreCase(email) && user.password().equalsIgnoreCase(password))
                .findAny();
        if (userData.isPresent()) {
            currentUser = userData.get();
            return true;
        } else {
            return false;
        }
    }

    public static void logout() {
        currentUser = null;
    }

    public static void register(String email, String password, String username) {
        User newUser = new User(data.size() + 1, email, password, username);
        data.add(newUser);
        currentUser = newUser;
    }
}
