package utils;

import java.util.Stack;

public class Navigator {
    static Stack<Screen> history = new Stack<>();

    public static void back() {
        history.pop();
        Screen previousScreen = history.peek();
        previousScreen.start();
    }

    public static void goTo(Screen screen) {
        history.push(screen);
        screen.start();
    }

    public static void refresh() {
        Screen currentScreen = history.peek();
        currentScreen.start();
    }

    public static void replace(Screen screen) {
        history.clear();
        history.push(screen);
        screen.start();
    }
}
