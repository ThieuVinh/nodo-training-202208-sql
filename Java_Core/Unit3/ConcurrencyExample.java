package unit3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ConcurrencyExample {
    public static void main(String[] args) {
        ConcurrencyTest3();
    }

    public static void ConcurrencyTest1() {
        List<Integer> list = new ArrayList<Integer>();
        Collections.addAll(list, 1,3,4,2,3,6,3,3,8);
        System.out.println("Before remove: size of list = " + list.size());
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == 3) {
                list.remove(i);
            }
        }
        System.out.println("After remove: size of list = " + list.size());
    }

    public static void ConcurrencyTest2() {
        List<Integer> list = new ArrayList<Integer>();
        Collections.addAll(list, 1,3,4,2,3,6,3,3,8);

        System.out.println("Before remove: size of list = " + list.size());
        list.forEach(v -> {
            if (v == 3) {
                list.remove(v);
            }
        });
        System.out.println("After remove: size of list = " + list.size());
    }

    public static void ConcurrencyTest3() {
        List<Integer> list = new ArrayList<Integer>();
        Collections.addAll(list, 1,3,4,2,3,6,3,3,8);
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            if (iterator.next() == 3) {
                iterator.remove();
            }
        }
    }
}
