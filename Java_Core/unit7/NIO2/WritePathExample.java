package unit7.NIO2;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.StandardOpenOption.APPEND;
import static java.nio.file.StandardOpenOption.CREATE;

public class WritePathExample {
    public static void main(String[] args) {
        Charset charset = Charset.forName("utf8");
        Path path = Paths.get("D:\\Temp\\hanoijava2.txt");
        try (BufferedWriter writer = Files.newBufferedWriter(path,
                charset, CREATE, APPEND)) {
            for (int i = 0; i < 10; i++) {
                writer.write("Nguyên Văn " + i + "\r\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
