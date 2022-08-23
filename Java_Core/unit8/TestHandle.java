package unit8;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;

public class TestHandle implements HttpHandler {

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String message = "<html><h2>This is the response</h2></html>";
        exchange.sendResponseHeaders(200, message.length());
        OutputStream out = exchange.getResponseBody();
        try {
            out.write(message.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
