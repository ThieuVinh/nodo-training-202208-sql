package unit7.NIO2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class CopingAndMovingExample {
    public static void main(String[] args) throws IOException {
        Example3();
    }

    public static void Example1()  throws IOException{
        Path source = Paths.get("D:\\Temp2\\test1\\io_sample.txt");
        Path target = Paths.get("D:\\Temp\\io_sample.txt");
        Files.copy(source, target, REPLACE_EXISTING);
    }

    public static void Example2()  throws IOException{
        Path target = Paths.get("D:\\Temp\\io_sample.txt");
        Files.delete(target);
    }

    public static void Example3()  throws IOException{
        Path source = Paths.get("D:\\Temp2\\test1\\io_sample.txt");
        Path target = Paths.get("D:\\Temp\\io_sample.txt");
        Files.createLink(target, source);
    }
}
