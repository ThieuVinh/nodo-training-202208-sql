package unit7.NIO2;

import java.nio.file.*;

import static java.nio.file.FileVisitResult.CONTINUE;

public class FileFinderExample {

    public static void main(String[] args) throws Exception {
        Files.walkFileTree(Path.of("D:\\Temp"), new Finder());
    }

    public static class Finder extends SimpleFileVisitor {
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:*.{txt}");

        public FileVisitResult visitFile(Path path) {
            if (matcher.matches(path.getFileName())) {
                System.out.println("found: " + path);
            }
            ;
            return CONTINUE;
        }
    }
}
