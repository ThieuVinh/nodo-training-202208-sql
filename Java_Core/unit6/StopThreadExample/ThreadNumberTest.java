package unit6.StopThreadExample;

public class ThreadNumberTest {
    public static void main(String[] args) throws InterruptedException {
        PrintNumber number = new PrintNumber();

        Thread thread1 = new Thread(number);
        thread1.setName("Fsort_Thread 1");
        thread1.start();

        Thread thread2 = new Thread(number);
        thread2.setName("Fsort_Thread 2");
        thread2.start();

        // Example 1
//        while (thread.isAlive()) {
//            if (number.getNumber() % 10 == 0) {
//                number.setAlive(false);
//            }
//            Thread.sleep(1000);
//        }

        // Example 2
//        Thread.currentThread().join();
//        while (thread.isAlive()) {
//            if (number.getNumber() % 10 == 0) {
//                number.setAlive(false);
//            }
//            TimeUnit.SECONDS.sleep(1);
//        }

        // Example 3
//        Thread.currentThread().join();
//        System.out.println("Main Thread say hello");
//        System.out.println("Main Thread say goodbye");
    }
}
