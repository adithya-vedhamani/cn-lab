import java.net.*;
import java.util.Scanner;

public class ex4a_udpdnsclient {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        DatagramSocket clientSocket = new DatagramSocket();
        InetAddress ipAddress = InetAddress.getLocalHost();
        int port = 1362;
        byte[] sendData;
        byte[] receiveData = new byte[1024];
        System.out.print("Enter the hostname: ");
        String sentence = scanner.nextLine();
        sendData = sentence.getBytes();
        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, ipAddress, port);
        clientSocket.send(sendPacket);
        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
        clientSocket.receive(receivePacket);
        String response = new String(receivePacket.getData());
        System.out.println("IP Address: " + response);
        clientSocket.close();
    }
}
