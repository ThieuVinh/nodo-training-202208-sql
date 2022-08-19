package unit7.NIO2;

import java.io.IOException;
import java.nio.file.*;

import static java.nio.file.StandardWatchEventKinds.ENTRY_CREATE;

public class WatchFolderExample {
    public static void main(String[] args) {
        Path path = Paths.get("D:\\Temp");
        watch(path);
    }

    public static void watch(Path path) {
        FileSystem fs = path.getFileSystem();
        try (WatchService service = fs.newWatchService()) {
            path.register(service, ENTRY_CREATE);
            while (true) {
                WatchKey key = service.take();
                if (!key.reset()) {
                    break;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
