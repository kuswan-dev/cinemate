package data;

import java.util.ArrayList;

public class Payments {
    static ArrayList<String> data = new ArrayList<>();

    static {
        data.add("Visa");
        data.add("MasterCard");
        data.add("GoPay");
        data.add("Ovo");
        data.add("LinkAja");
    }

    public static ArrayList<String> getAll() {
        return data;
    }
}
