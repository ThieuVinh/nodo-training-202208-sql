package unit2;

import java.util.Calendar;
import java.util.Locale;

public class EnumExample {

    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        System.out.println("Hôm này là " + VnDay.valueOf(calendar));
    }

    public enum VnDay {
        THU_HAI, THU_BA, CHU_NHAT, THU_BAY, KHONG_BIET;
        static VnDay valueOf(Calendar calendar) {
            String type = calendar.getDisplayName(Calendar.DAY_OF_WEEK,
                    Calendar.SHORT, new Locale("vi"));
            switch (type) {
                case "Th 2":
                    return THU_HAI;
                case "Th 3":
                    return THU_BA;
                case "Th 7":
                    return THU_BAY;
                case "CN":
                    return CHU_NHAT;
            }
            return KHONG_BIET;
        }
    }
}
