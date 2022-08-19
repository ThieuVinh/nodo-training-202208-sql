package unit7.NIO2;

import unit9.Filter;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathExample {
    public static void main(String[] args) {
        PathExample3();
    }

    public static void PathExample1() {
        Path path = Paths.get("D:\\Temp");
        System.out.println("This is " + (Files.isDirectory(path) ? "file" : "folder") + " !");
        System.out.println(Files.exists(path));
    }

    public static void PathExample2() {
        Path path = Paths.get("D:\\Temp");
        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(path)) {
            for (Path p : directoryStream) {
                System.out.println(p.getFileName());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void PathExample3() {
        Path path = Paths.get("D:\\Temp\\hanoijava.txt");
        Path path2 = path.resolve("hanoijava.txt");

        Charset charset = Charset.forName("utf8");
        try (BufferedReader reader = Files.newBufferedReader(path2, charset)) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
