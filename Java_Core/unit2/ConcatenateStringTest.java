package unit2;

public class ConcatenateStringTest {
    public static void main(String[] args) {
        int max = 100000;//Khai báo điều kiện

        StringBuilder builder = new StringBuilder();// nối chuỗi
        long start = System.currentTimeMillis();
        for (int i = 0; i < max; i++) {
            builder.append(String.valueOf(i));
        }
        System.out.println("time 1 = " + (System.currentTimeMillis() - start));

        StringBuffer buffer = new StringBuffer();
        start = System.currentTimeMillis();
        for (int i = 0; i < max; i++) {
            buffer.append(String.valueOf(i));
        }
        System.out.println("time 2 = " + (System.currentTimeMillis() - start));

        String text = "";
        start = System.currentTimeMillis();
        for (int i = 0; i < max; i++) {
            text += String.valueOf(i);
        }
        System.out.println("time 3 = " + (System.currentTimeMillis() - start));
    }
}
