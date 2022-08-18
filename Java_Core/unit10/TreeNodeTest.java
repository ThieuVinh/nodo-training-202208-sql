package unit10;

import java.util.List;

public class TreeNodeTest {
    public static void main(String[] args) {
        test2();
    }

    public static void test1() {
        TreeNode<String> root = new TreeNode<>("0");
        TreeNode<String> node1 = new TreeNode<>("1.0");
        TreeNode<String> node2 = new TreeNode<>("1.1");
        root.addChild(node1);
        root.addChild(node2);

        node2.addChild("2.0.0");
        node2.addChild("2.1.0");
        node2.addChild("2.1.1");

        node2 = node1.getNextSibling();
        System.out.println("next sibling of " + node1.getValue() + " is " + node2.getValue());
    }

    public static void test2() {
        TreeNode<String> root = new TreeNode<>("0");
        TreeNode<String> node1 = new TreeNode<>("1.0");
        TreeNode<String> node2 = new TreeNode<>("1.1.0");
        root.addChild(node1);
        root.addChild(node2);

        List<String> list = root.chonloc(value -> {
            return value.contains(".0");
        });

        System.out.println("Có tổng số " + list.size() + " chứa '.0'");
        list.forEach(value -> {
            System.out.println("Phần tử lọc ==> " + value);
        });
    }
}
