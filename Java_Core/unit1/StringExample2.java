package unit1;

public class StringExample2 {
    public static void main(String[] args) {
        String4();
    }

    public static void String1() {
        char[] chars = {'h', 'e', 'l', 'l', 'o'};
        String text = new String(chars);
        System.out.println(text);
    }

    public static void String2() {
        String text = "Absolute Value";
        byte[] bytes = text.getBytes();
        System.out.println("Byte values are ");

        for (int i = 0; i < bytes.length; i++) {
            System.out.println((int) bytes[i] + ", ");
        }
    }

    public static void String3() {
        String text = "say hello to everyone";
        System.out.println("Length of text is " + text.length());

        int i = 0;
        while (i < text.length()) {
            char c = text.charAt(i);
            if (c == ' ') {
                i++;
                continue;
            }
            System.out.println("Character at " + i + " is " + c);
            i++;
        }
    }

    public static void String4() {
        byte[] bytes = {99,-58,-80,-31,-69,-101,112,44,32,104,105,-31,
                            -70,-65,112,44,32,103,105,-31,-70,-65,116};
        try {
            System.out.println(new String(bytes, "utf8"));
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
