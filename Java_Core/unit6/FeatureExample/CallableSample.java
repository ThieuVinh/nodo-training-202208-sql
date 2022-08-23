package unit6.FeatureExample;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.LongStream;

import static java.util.stream.IntStream.range;

public class CallableSample implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        AtomicInteger total = new AtomicInteger(0);
        range(0, 10).forEach(number -> {
            System.out.println(Thread.currentThread().getName() + "-object " + this + " is running " + total.addAndGet(number));

            Random random = new Random();
            LongStream longStream = random.longs(100, 1000);
            long sleep = longStream.findFirst().getAsLong();
        });
        return total.get();
    }
}
