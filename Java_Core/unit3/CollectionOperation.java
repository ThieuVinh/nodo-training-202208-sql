package unit3;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class CollectionOperation {
    public static void main(String[] args) {
        CollOpera5();
    }

    public static void CollOpera1() {
        // Example 1
        List<Integer> list = new ArrayList<>(Arrays.asList(4, 7, 1, 3, 8, 10, 9, 6));
        Comparator<Integer> comparator = Integer::compare;
        Collections.sort(list, comparator);
        list.stream().filter(v -> v > 5).forEach(v -> {
            System.out.println(v);
        });
    }

    public static void CollOpera2() {
        // Example 2
        List<Integer> list = new ArrayList<>(Arrays.asList(4, 7, 1, 3, 8, 10, 9, 6));
        Collector<Integer, ?, IntSummaryStatistics> collector = Collectors.summarizingInt(Integer::intValue);
        IntSummaryStatistics summaryStatistics = list.stream().collect(collector);
        System.out.println("Total = " + summaryStatistics.getSum());
        System.out.println("Overage = " + summaryStatistics.getAverage());
    }

    public static void CollOpera3() {
        // Example 3
        List<Integer> list = new ArrayList<>(Arrays.asList(4, 7, 1, 3, 8, 10, 9, 6));
        Consumer<Integer> myConsumer = n -> {
            System.out.println("User input value = " + n);
            if (n < 5) {
                System.out.println("Invalid value !");
                return;
            }
            list.add(n);
            System.out.println("Value: ");
            list.forEach(x -> {
                System.out.println(x + "-");
            });
        };
        myConsumer.accept(12);
    }

    public static void CollOpera4() {
        // Example 4
        List<Integer> list = new ArrayList<>(Arrays.asList(4, 7, 1, 3, 8, 10, 9, 6));
        Consumer<Integer> myConsumer = n -> {
            System.out.println("User input value = " + n);
            if (n < 5) {
                System.out.println("Invalid value !");
                return;
            }
            list.add(n);
            System.out.println("Value: ");
            list.forEach(x -> {
                System.out.println(x + "-");
            });
        };
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.printf("Please input a number ");
            int value = scanner.nextInt();
            myConsumer.accept(value);
            System.out.println();
        }
    }

    public static void CollOpera5() {
        // Example 5
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        Predicate<Integer> tester = v -> v > 5;
        Consumer<Integer> myConsumer = n -> list.add(n);
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.printf("Please input a number ");
            int value = scanner.nextInt();
            if (value < 0) {
                break;
            }
            if (tester.test(value)) {
                myConsumer.accept(value);
            }
        }
        list.forEach(x -> System.out.printf(x + " - "));
    }

}
