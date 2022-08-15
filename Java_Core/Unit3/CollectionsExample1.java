package Unit3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionsExample1 {
    public static void main(String[] args) {
        Short[] values = {1,2,4,5,7,8,9};
        List<Short> list = new ArrayList<>();
        Collections.addAll(list, values);
        Collections.reverse(list);
        list.toArray(values);
        for (int i = 0; i < values.length; i++) {
            System.out.printf(values[i] + ", ");
        }
    }
}
