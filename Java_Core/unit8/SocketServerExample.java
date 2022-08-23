package unit8;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServerExample {
    public static void main(String[] args) throws IOException {
        new SocketServerExample(9245);
    }

    public SocketServerExample(int serverPort) throws IOException {
        ServerSocket serverSocket = new ServerSocket(serverPort);
        System.out.println("SERVER Listening....");
        while (true) {
            Socket socket = serverSocket.accept();
            new Thread(() ->{
                try (DataInputStream input = new DataInputStream(socket.getInputStream());
                 DataOutputStream output = (DataOutputStream) socket.getOutputStream()) {
                    System.out.println("Client Say: " + input.readUTF());
                    output.writeUTF("I'm a socket server !");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }).start();
        }
    }
}
