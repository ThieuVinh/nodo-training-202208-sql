package unit2;

import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class MessageFormatExample {
    public static void main(String[] args) {
        DateDate(new String[]{"Vinh", "Sơn", "Hòa"});
    }

    private static void DateDate(String[] args) {
        Locale locale = new Locale("vi", "VN");
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEEEE, dd MMMMM yyyy", locale);

        String message = MessageFormat.format(
                "Hello {0}! Today is {1}.", args[0],
                dateFormat.format(Calendar.getInstance().getTime()));
        System.out.println(message);
    }
}
