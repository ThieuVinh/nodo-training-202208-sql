package unit6;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ReadWriteLockExample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        Map<String, String> map = new HashMap<>();

        executor.submit(() -> {
            System.out.println("start writing");
            try {
                TimeUnit.SECONDS.sleep(10);
                map.put("too", "bar");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                System.out.println("end writing");
            }
        });
    }
}
