package unit8;

import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import static java.nio.file.StandardOpenOption.APPEND;

public class HttpConnectionExample {
    public static void main(String[] args) throws IOException {
        URL url = new URL("https://www.youtube.com/");
        URLConnection connection = url.openConnection();

        Path path = Paths.get("(1392) PHÂN TÍCH T1 vs DK_ BÁN KẾT QUÁ CẢM XÚC, QUÁ ĐIÊN RỒ VÀ NHỮNG PHA CẤM CHỌN BẤT NGỜ _ VĂN TÙNG - YouTube.html");
        int read;
        byte[] bytes = new byte[20];
        try (InputStream inputStream = connection.getInputStream();
            OutputStream outputStream=Files.newOutputStream(path,
                    StandardOpenOption.CREATE,APPEND)){
            while ((read = inputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, read);
            }
        } finally {
            Desktop.getDesktop().open(path.toFile());
        }
    }
}
