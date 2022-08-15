package Unit3;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

public class MapExample {
    public static void main(String[] args) {
        Map<Integer, String> map = new Hashtable<>();
        map.put(3, "Thiều Quang Vinh");
        map.put(1, "Đỗ Tất Hòa");
        map.put(4, "Nguyễn Hồng Sơn");
        map.put(2, "Nguyễn Viết Hiên");

        Iterator<Map.Entry<Integer, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, String> entry = iterator.next();
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
