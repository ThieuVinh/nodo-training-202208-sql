package unit3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionsExample2 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("Vinh");
        list.add("Sơn");
        list.add("Hòa");
        list.add("Hiên");
        Collections.addAll(list);
        Collections.sort(list);

        for (int i = 0; i < list.size(); i++) {
            System.out.printf(list.get(i) + ", ");
        }
        System.out.println();
        System.out.println("Vị trí thứ: " + Collections.binarySearch(list,"Sơn"));
    }
}
