package unit6.FeatureExample;

import javax.xml.transform.Result;
import java.util.concurrent.*;

public class FeatureExampleTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        CallableSample callableSample = new CallableSample();
        ExecutorService executor = Executors.newFixedThreadPool(1);
        Future future = executor.submit(callableSample);
        System.out.println("Future Done ? " + future.isDone());
        Result result = (Result) future.get();
        System.out.println("Future Done ? " + future.isDone() + "-result = " + result);
    }
}
