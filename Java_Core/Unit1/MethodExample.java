package Unit1;

public class MethodExample {

    public static void main(String[] args) {
        add1(new String[]{"4", "6"});
        System.out.println(add2(4,7,8,9));
    }

    private static int add(int number1, int number2) {
        return number1 + number2;
    }

    private static void add1(String[] args) {
        int value0 = Integer.parseInt(args[0]);
        int value1 = Integer.parseInt(args[1]);
        System.out.println(value0 + " + " + value1 + " = " + add(value0, value1));
    }

    private static int add2(int ...values) {
        int total = 0;
        for (int i = 0; i < values.length; i++) {
            total += values[i];
        }
        return total;
    }
}
