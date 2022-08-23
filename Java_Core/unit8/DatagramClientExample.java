package unit8;

import java.io.IOException;
import java.net.*;

public class DatagramClientExample {
    public static void main(String[] args) throws SocketException {
        DatagramSocket socket = new DatagramSocket();
        byte[] bytes = new byte[50];
        try {
            InetAddress address = InetAddress.getByName("localhost");
            bytes = "Client say Xin Chao".getBytes();
            DatagramPacket packet = new DatagramPacket(bytes, bytes.length, address, 4445);
            socket.send(packet);

            packet = new DatagramPacket(bytes, bytes.length);
            socket.receive(packet);

            System.out.println("From server: " + new String(packet.getData(), 0, packet.getLength()));
            socket.close();
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
