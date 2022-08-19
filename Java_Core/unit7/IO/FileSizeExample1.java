package unit7.IO;

import java.io.File;

public class FileSizeExample1 {
    public static void main(String[] args) {
        File file = new File("C:\\Temp");
        System.out.println("Size: " + getSize(file)/(1024*1024) + "MB");
    }

    private static long getSize(File file) {
        if (file.isFile()) {
            return file.length();
        }

        File[] files = file.listFiles();
        int length = 0;
        for (int i = 0; i < files.length; i++) {
            if (files[i].isFile()) {
                length += getSize(files[i]);
                continue;
            }
            length += files[i].length();
        }
        return length;
    }
}
