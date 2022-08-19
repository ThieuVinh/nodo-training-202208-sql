package unit7.IO;

import java.io.File;
import java.io.FileInputStream;

public class FileInputExample {
    public static void main(String[] args) {
        fileInput2();
    }

    public static void fileInput1() {
        File file = new File("D:\\Temp\\hanoijava.txt");
        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream(file);
            byte[] bytes = new byte[16];
            inputStream.read(bytes);
            System.out.println(new String(bytes));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void fileInput2() {
        File file = new File("D:\\Temp\\hanoijava.txt");
        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream(file);
            byte[] bytes = new byte[4*1024];
            int read = -1;
            StringBuilder builder = new StringBuilder();
            while ((read = inputStream.read(bytes)) != -1) {
                builder.append(new String(bytes, 0 , read));
            }
            System.out.println("[ " + builder + " ]");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
