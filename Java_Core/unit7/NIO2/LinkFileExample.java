package unit7.NIO2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.StandardOpenOption.APPEND;

public class LinkFileExample {
    public static void main(String[] args) {
        Path source = Paths.get("D:\\Temp2\\test1\\sample2.txt");
        Path target = Paths.get("D:\\Temp\\sample2.txt");

        Charset charset = Charset.forName("utf8");
        try (BufferedWriter writer = Files.newBufferedWriter(source, charset, APPEND)) {
            writer.write("Java NIO 2 example \r\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (BufferedReader reader = Files.newBufferedReader(target, charset)) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
