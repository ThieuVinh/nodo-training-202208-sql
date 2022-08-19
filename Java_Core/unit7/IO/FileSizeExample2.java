package unit7.IO;

import java.io.File;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicLong;

public class FileSizeExample2 {
    public static void main(String[] args) {
        File file = new File("C:\\Temp");
        System.out.println("Size: " + getSize(file)/(1024*1024) + "MB");
    }

    private static long getSize(File file) {
        if (file.isFile()) {
            return file.length();
        }
        AtomicLong length = new AtomicLong(0);
        Arrays.stream(file.listFiles()).forEach(f -> {
            length.getAndSet(length.longValue() + (f.isFile() ? getSize(f) : f.length()));
        });
        return length.longValue();
    }
}
