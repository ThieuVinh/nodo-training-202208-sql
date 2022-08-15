package Unit1;

import java.util.Arrays;

public class MyProgram {
    public static void main (String [] args) {
        ArrayExample();
    }

    public static void MyPrgram(String[] args) {
        System.out.println("The number of arguments is " + args.length);
        for (int i = 0; i < args.length; i++) {
            System.out.println("Value at " + i + " is " + args[i]);
        }
    }

    public static void StreamPrgram(String[] args) {
        Arrays.stream(args).forEach((String value) -> {
            System.out.println("Value is " + value);
        });
    }

    public static void NumberExample(String[] args) {
        int number1 = Integer.parseInt(args[0]);
        int number2 = Integer.parseInt(args[1]);

        System.out.println("Subtraction example: " + (number1 - number2));
        System.out.println("Relational example: " + "number1 > number2 = " + (number1 + number2));
    }

    public static void IfElseExample(String[] args) {
        int value = Integer.parseInt(args[0]);
        if (value < 5) {
            System.out.println("Bad");
        } else {
            System.out.println("Good");
        }
    }

    public static void SwitchExample(String[] args) {
        int value = Integer.parseInt(args[0]);
        switch (value) {
            case 0:
                System.out.println("Bad");
                break;
            case 1:
                System.out.println("Good");
                break;
            case 2:
                System.out.println("Invalid");
                break;
        }
    }

    public static void ArrayExample() {
        float[] values = {4.5f, 5.5f};

        float total = 0;
        for (float value : values) {
            total += value;
        }
        System.out.println("The total value of array is " + total);

        float max = values[0];
        for (int i = 0; i < values.length; i++) {
            if (max < values[i]) {
                max = values[i];
            }
        }
        System.out.println("Giá trị lớn nhất: " + max);
    }


}
