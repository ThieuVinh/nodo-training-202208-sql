package unit6.RunableExample;

public class ThreadTest {
    public static void main(String[] args) {
//        PrintMessage message = new PrintMessage("Say hello to everyone");
//        new Thread(message).start();
        new Thread(new PrintMessage("Say hello to everyone")).start();
    }
}
