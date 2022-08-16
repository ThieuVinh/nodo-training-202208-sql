package unit9;

public class RunnableTest {
    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " Say hello Java class !");
            }
        };
        new Thread(runnable).start();
    }
}
