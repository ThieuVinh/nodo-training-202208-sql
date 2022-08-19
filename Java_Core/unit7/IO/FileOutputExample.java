package unit7.IO;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputExample {
    public static void main(String[] args) throws IOException {
        File file = new File("D:\\Temp\\hanoijava.txt");
        FileOutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(file);
            byte[] bytes = ("Hello Ha Noi Java Class").getBytes();
            outputStream.write(bytes);
            System.out.println("Thêm thành công");
        }  catch (Exception e) {
            System.out.println("Thêm thất bại");
            e.printStackTrace();
        } finally {
            if (outputStream != null) {
                outputStream.close();
            }
        }
    }
}
