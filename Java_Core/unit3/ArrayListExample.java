package unit3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayListExample {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("Vinh");
        list.add("Hòa");
        list.add("Sơn");
        Collections.addAll(list, args);

        for (int i = 0; i < list.size(); i++) {
            System.out.println("Element at " + i + " is " + "get value from list by index");
        }
    }
}
