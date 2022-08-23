package unit8;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

public class HttpServerExample {
    public static void main(String[] args) {
        try {
            TestHandle testHandle = new TestHandle();
            HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
            server.createContext("/test", testHandle);
            server.setExecutor(Executors.newFixedThreadPool(5));
            server.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
