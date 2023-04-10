import java.net.*;

public class ex4a_udpdnsserver{
    private static final String[] HOSTS = {"yahoo.com", "gmail.com", "cricinfo.com", "facebook.com"};
    private static final String[] IP = {"68.180.206.184", "209.85.148.19", "80.168.92.140", "69.63.189.16"};

    public static void main(String[] args) throws Exception {
        DatagramSocket serverSocket = new DatagramSocket(1362);
        byte[] receiveData = new byte[1021];
        byte[] sendData;

        while (true) {
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            serverSocket.receive(receivePacket);
            String sentence = new String(receivePacket.getData()).trim();
            InetAddress ipAddress = receivePacket.getAddress();
            int port = receivePacket.getPort();
            sendData = (indexOf(HOSTS, sentence) != -1) ? IP[indexOf(HOSTS, sentence)].getBytes() : "Host Not Found".getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, ipAddress, port);
            serverSocket.send(sendPacket);
        }
    }

    private static int indexOf(String[] array, String str) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(str)) {
                return i;
            }
        }
        return -1;
    }
}
