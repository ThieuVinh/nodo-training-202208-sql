package unit2;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class StreamArrayExample {
    public static void main(String[] args) {
        // Example 1
        Integer[] values = {2,4,7,1,3,5,9,22,3,25};
        Arrays.sort(values, (Integer o1, Integer o2) -> {
            return o2 - o1;
        });
        for (int i = 0; i < values.length; i++) {
            System.out.println(values[i]);
        }
        System.out.println("============================");
        // Example 2
        Stream<Integer> stream = Arrays.stream(values);
        Optional<Integer> max = stream.max((Integer o1, Integer o2) ->{
            return o1 - o2;
        });
        System.out.println("Giá trị lớn nhất: " + max.get());
        System.out.println("==============================");
        // Example 2.2
        Predicate<Integer> predicate = (Integer value) -> {
            return value > 5;
        };
        Stream<Integer> older = stream.filter(predicate);
        older.forEach((Integer value) -> {
            System.out.println(value);
        });
    }
}
