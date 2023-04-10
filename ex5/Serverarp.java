import java.io.*;
import java.net.*;

class Serverarp {
  public static void main(String[] args) throws IOException {
    String[] ips = {"165.165.80.80", "165.165.79.1"};
    String[] macs = {"6A:08:AA:C2", "8A:BC:E3:FA"};
    while (true) {
      try (ServerSocket server = new ServerSocket(5604);
           Socket socket = server.accept();
           DataInputStream din = new DataInputStream(socket.getInputStream());
           DataOutputStream dout = new DataOutputStream(socket.getOutputStream())) {
        String str = din.readLine();
        for (int i = 0; i < ips.length; i++) {
          if (str.equals(ips[i])) {
            dout.writeBytes(macs[i] + '\n');
            break;
          }
        }
      } catch (IOException e) {
        System.err.println(e);
      }
    }
  }
}
