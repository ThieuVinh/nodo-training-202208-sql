package unit3;

import java.util.Set;
import java.util.TreeSet;

public class SetExample {
    public static void main(String[] args) {
        Set<Integer> numbers = new TreeSet<Integer>();
        numbers.add(1);
        numbers.add(10);
        numbers.add(15);
        numbers.add(3);
        numbers.add(8);
        numbers.add(12);

        System.out.println("Size of set: " + numbers.size());
    }
}
