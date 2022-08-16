package unit2;

import java.util.Calendar;
import java.util.Locale;

public class StringSwitchStatement {

    public static void main(String[] args) {
        StringSwitchStatement statement = new StringSwitchStatement();
        Calendar calendar = Calendar.getInstance();
        System.out.println("Today is " + statement.getTypeOfDay(calendar));

        calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) + 1);
        System.out.println("Tomorow is " + statement.getTypeOfDay(calendar));
    }

    String getTypeOfDay(Calendar calendar) {
        String type = calendar.getDisplayName(Calendar.DAY_OF_WEEK,
                Calendar.SHORT, new Locale("vi"));
        switch (type) {
            case "Th 2":
                return "Start of work week";
            case "Th 3":
                return "Start of work week 2";
            case "Th 4":
                return "Start of work week 3";
            case "Th 5":
                return "Start of work week 4";
            case "Th 6":
                return "Start of work week 5";
            case "Th 7":
                return "Start of work week 6";
            case "CN":
                return "Weekend";
        }
        return "Unknown";
    }

}
