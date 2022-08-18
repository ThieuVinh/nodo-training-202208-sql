package unit10;

public class TestNode {
    public static void main(String[] args) {
        // Example 2
        Node<String> root = new Node<>("Step 1");
        Node<String> node1 = new Node<>("Step 2");
        root.next = node1;

        // Example 3
        Node<Integer> root2;
        root2 = new Node<Integer>(99, new Node<Integer>(23, new Node<>(11)));

        // test
        test(root2);
    }

    private static void test(Node<?> node) {
        while (node != null) {
            System.out.println("Value is " + node.getValue() + "");
            node = node.next;
        }
    }
}
