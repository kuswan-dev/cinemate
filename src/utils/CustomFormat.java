package utils;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class CustomFormat {
    public static String toLocaleDate(Date date) {
        Locale indonesiaLocale = new Locale.Builder().setLanguage("id").setRegion("ID").build();
        return new SimpleDateFormat("hh.mm, dd MMMM YYYY", indonesiaLocale).format(date);
    }

    public static String toRupiah(int price) {
        Locale indonesiaLocale = new Locale.Builder().setLanguage("id").setRegion("ID").build();
        NumberFormat rupiahFormat = NumberFormat.getCurrencyInstance(indonesiaLocale);
        String priceFormated = rupiahFormat.format(price);
        return priceFormated.substring(0, priceFormated.length() - 3);
    }
}
