package unit8;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class SocketClientExample {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 9245);
        System.out.println("CILENT start sending....");
        try (DataInputStream input = (DataInputStream) socket.getInputStream();
             DataOutputStream output = (DataOutputStream) socket.getOutputStream()) {
            output.writeUTF("Hello Server");
            System.out.println("Server Say: " + input.readUTF());
        } finally {
            socket.close();
        }
    }
}
