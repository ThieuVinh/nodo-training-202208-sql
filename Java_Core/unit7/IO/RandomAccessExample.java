package unit7.IO;

import java.awt.*;
import java.io.File;
import java.io.RandomAccessFile;

public class RandomAccessExample {
    public static void main(String[] args) {
        File file = new File("C:\\Temp\\hanoijava.txt");
        try {
            RandomAccessFile randomAccess = new RandomAccessFile(file, "rw");
            randomAccess.seek(9);
            byte[] bytes = new byte[4*102];
            int read = randomAccess.read(bytes);
            System.out.println(new String(bytes, 0, read, "utf8"));

            randomAccess.seek(file.length());
            randomAccess.write("\r\n".getBytes());
            randomAccess.writeChars("Hello Co Can");

            Desktop.getDesktop().open(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
