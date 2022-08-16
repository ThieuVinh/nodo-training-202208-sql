package unit2;

public class TryCatchExample {

    public static void main(String[] args) {
        int number = toNumber("45");
        System.out.println("number = " + number);

        number = toNumber("as");
        System.out.println("number = " + number);
    }

    private static int toNumber(String value) {
        try {
            Integer integer = Integer.parseInt(value);
            return integer.intValue();
        } catch (NumberFormatException e) {
            System.out.println("Có 1 thứ xuất hiện ko phải là số :v");
        }
        return -1;
    }
}
