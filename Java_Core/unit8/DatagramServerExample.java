package unit8;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class DatagramServerExample {
    public static void main(String[] args) throws SocketException {
        new DatagramServerExample();
    }

    public DatagramServerExample() throws SocketException {
        DatagramSocket socket = new DatagramSocket(4445);
        System.out.println("Data Server listening....");

        byte[] bytes = new byte[100];

        try {
            DatagramPacket packet = new DatagramPacket(bytes, bytes.length);

            socket.receive(packet);
            System.out.println("From Client: " + new String(packet.getData(), 0, packet.getLength()));
            bytes = "Server say hello".getBytes();
            socket.send(new DatagramPacket(bytes,
                    bytes.length, packet.getAddress(), packet.getPort()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            socket.close();
        }
    }

//    public void run() throws SocketException {
//        byte[] bytes = new byte[100];
//
//        try {
//            DatagramPacket packet = new DatagramPacket(bytes, bytes.length);
//
//            socket.receive(packet);
//            System.out.println("From Client: " + new String(packet.getData(), 0, packet.getLength()));
//            bytes = "Server say hello".getBytes();
//            socket.send(new DatagramPacket(bytes,
//                    bytes.length, packet.getAddress(), packet.getPort()));
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        } finally {
//            socket.close();
//        }
//    }
}
