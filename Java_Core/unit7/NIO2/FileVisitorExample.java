package unit7.NIO2;

import java.nio.file.*;

import static java.nio.file.FileVisitResult.CONTINUE;

public class FileVisitorExample {
    public static void main(String[] args) throws Exception {
        Path path = Paths.get("D:\\Temp");
        Files.walkFileTree(path, new PrintFiles());
    }
    
    public static class PrintFiles extends SimpleFileVisitor<Path> {
        public FileVisitResult visitResult(Path path) {
            System.out.println(path + " is file !");
            return CONTINUE;
        }

        public FileVisitResult postVisitDirectory(DirectoryStream<Path> dir) {
            System.out.println(dir + " is directory !");
            return CONTINUE;
        }
    }
}
