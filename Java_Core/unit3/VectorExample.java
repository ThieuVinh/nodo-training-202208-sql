package unit3;

import java.util.Vector;

public class VectorExample {
    public static void main(String[] args) {
        Vector<Integer> vector = new Vector<>();
        vector.add(1);
        vector.add(14);
        vector.add(8);
        vector.add(3);
        vector.add(12);

        System.out.println("Size of vector: " + vector.size());
        System.out.println("Element at 2: " + vector.get(2));
    }
}
