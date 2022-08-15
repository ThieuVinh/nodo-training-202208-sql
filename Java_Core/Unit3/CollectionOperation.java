package Unit3;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class CollectionOperation {
    public static void main(String[] args) {
        CollOpera1();
    }

    public static void CollOpera1() {
        List<Integer> list = new ArrayList<>(Arrays.asList(4, 7, 1, 3, 8, 10, 9, 6));
        Comparator<Integer> comparator = Integer::compare;
        Collections.sort(list, comparator);
        list.stream().filter(v -> v > 5).forEach(v -> {
            System.out.println(v);
        });
    }
}
