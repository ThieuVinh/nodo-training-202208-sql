package unit10;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class SyschronizedExample {
    public static void main(String[] args) {
        List<List<Integer>> values = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            List<Integer> listOfInt = new ArrayList<>();
            new Thread(() -> addData(listOfInt)).start();
            values.add(listOfInt);
        }

        try {
            Thread.sleep(5*1000);
            values.forEach(list -> {
                System.out.println("number items of list ------> " + list.size());
            });
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void addData(List<Integer> listOfInt) {
     IntStream.range(0, 1000).forEach(index -> {
            try {
                listOfInt.add(index);
            } catch (Exception e) {
                System.err.println(e.toString());
            }
        });
    }
}
