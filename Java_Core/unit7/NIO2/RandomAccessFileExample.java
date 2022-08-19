package unit7.NIO2;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.StandardOpenOption.READ;
import static java.nio.file.StandardOpenOption.WRITE;

public class RandomAccessFileExample {
    public static void main(String[] args) {
        Path path = Paths.get("D:\\Temp\\hanoijava2.txt");
        ByteBuffer buffer = ByteBuffer.allocate(14);
        try (FileChannel fc = FileChannel.open(path, READ, WRITE)) {
            fc.read(buffer);
            System.out.println(new String(buffer.array()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
