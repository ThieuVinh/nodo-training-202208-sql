package unit7.IO;

import java.awt.*;
import java.io.*;

public class ReaderWriterExample {
    public static void main(String[] args) {
        fileWriter();
    }

    public static void fileWriter() {
        File file = new File("D:\\Temp\\hanoijava.txt");
        boolean append;
        try {
            FileWriter writer = new FileWriter(file, append = true);
            writer.write("\r\n");
            writer.write("Tran Thi B");
            Desktop.getDesktop().open(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void fileReader() {
        File file = new File("D:\\Temp\\hanoijava.txt");
        try {
            FileReader reader = null;
            reader = new FileReader(file);
            char[] buffer = new char[4*1024];
            int read = -1;
            StringBuilder builder = new StringBuilder();
            while ((read = reader.read(buffer)) != -1) {
                builder.append(buffer, 0, read);
            }
            System.out.println(builder);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
