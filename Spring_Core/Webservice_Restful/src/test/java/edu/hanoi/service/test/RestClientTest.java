package edu.hanoi.service.test;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class RestClientTest {

    public static void main(String[] args) throws Exception {
        URL url = new URL("http://localhost:8080/list/users");
        URLConnection connection = url.openConnection();

        connection.setRequestProperty("Accept", "application/json");
        InputStream inputStream = connection.getInputStream();

        byte[] bytes = new byte[4 * 1024];
        int read = -1;

        try {
            while ((read = inputStream.read(bytes)) != -1) {
                System.out.println(new String(bytes, 0, read));
            }
        } finally {
            inputStream.close();
        }
    }
}
