package unit6.StopThreadExample;

public class PrintNumber implements Runnable {

    private int number = 1;
    private boolean alive = true;

    public int getNumber() {
        return number;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    // Example 1
//    @Override
//    public void run() {
//        Thread current = Thread.currentThread();
//        while (alive) {
//            number++;
//            System.out.println(current.getName() + " number is \"" + number + "\"");
//            try {
//                Thread.sleep(800);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        }
//        System.out.println(current.getName() + " is stoped !");
//    }

    // Example 2
//    @Override
//    public void run() {
//        Thread current = Thread.currentThread();
//        while (number < 10) {
//            number++;
//            System.out.println(current.getName() + " number is \"" + number + "\"");
//            try {
//                Thread.sleep(300);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        }
//        System.out.println(current.getName() + " is stoped !");
//    }

    // Example 3
    @Override
    public void run() {
        Thread current = Thread.currentThread();
        while (number < 30) {
            number++;
            System.out.println(current.getName() + " number is \"" + number + "\"");
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(current.getName() + " is stoped !");
    }
}
