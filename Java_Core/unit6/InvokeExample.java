package unit6;

import unit6.FeatureExample.CallableSample;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Stream;

import static java.util.Arrays.stream;

public class InvokeExample {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newWorkStealingPool();
        List<CallableSample> callables = Arrays.asList(
                new CallableSample(), new CallableSample(), new CallableSample(), new CallableSample()
        );

        Stream<Future<Integer>> stream = executor.invokeAll(callables).stream();
        Stream<Integer> resultStream = stream.map(future -> {
            try {
                return future.get();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
        });
        Integer[] result = resultStream.toArray(Integer[]::new);
        stream(result).forEach(System.out::println);

        System.out.println("----------------> " + executor.invokeAny(callables));
    }
}
