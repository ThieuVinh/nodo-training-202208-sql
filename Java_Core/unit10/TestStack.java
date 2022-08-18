package unit10;

public class TestStack {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(23);
        stack.push(45);
        stack.push(12);
        stack.push(98);
        stack.push(11);

        while (stack.hasNext()) {
            System.out.println("data = " + stack.pop());
        }
    }

}
