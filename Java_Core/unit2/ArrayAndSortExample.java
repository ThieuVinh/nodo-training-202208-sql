package unit2;

import java.util.Arrays;
import java.util.Comparator;

public class ArrayAndSortExample {
    public static void main(String[] args) {
        SortArrayExample(new Integer[]{2,4,1,5,6,3,8,7});
    }

    private static void SortArrayExample(Integer[] args) {
        Arrays.sort(args);
        for (int i = 0; i < args.length; i++) {
            System.out.println(args[i]);
        }
        System.out.println("======================");

        Arrays.sort(args, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        for (int i = 0; i < args.length; i++) {
            System.out.println(args[i]);
        }
    }
}
