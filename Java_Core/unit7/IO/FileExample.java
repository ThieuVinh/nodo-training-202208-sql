package unit7.IO;

import java.io.File;

public class FileExample {
    public static void main(String[] args) {
        checkFileOrFolder2();
    }

    public static void checkFileOrFolder1() {
        File file = new File("C:\\Temp");
        if (file.isDirectory()) {
            System.out.println("This is folder !");
        } else {
            System.out.println("This is file !");
        }
    }

    public static void checkFileOrFolder2() {
        File file = new File("C:\\Temp");
        System.out.println("This is " + (file.isFile() ? "file" : "folder") + "!");

        File[] files = file.listFiles();
        for (File f : files) {
            System.out.println(f.getName() + ": " + f.length() + " bytes");
        }


    }
}
