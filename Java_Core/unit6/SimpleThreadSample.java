package unit6;

import java.util.Arrays;

public class SimpleThreadSample {
    public static void main(String[] args) {
        new Thread(
                () -> {
                    Arrays.stream(args).forEach(ele -> System.out.println(ele));
                }
        ).start();
    }
}
