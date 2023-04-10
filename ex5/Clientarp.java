import java.io.*;
import java.net.*;

class Clientarp {
  public static void main(String[] args) {
    try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         Socket socket = new Socket("127.0.0.1", 26732);
         DataInputStream din = new DataInputStream(socket.getInputStream());
         DataOutputStream dout = new DataOutputStream(socket.getOutputStream())) {
      System.out.println("Enter the Logical address (IP):");
      dout.writeBytes(in.readLine() + '\n');
      System.out.println("The Physical Address is: " + din.readLine());
    } catch (IOException e) {
      System.err.println(e);
    }
  }
}
