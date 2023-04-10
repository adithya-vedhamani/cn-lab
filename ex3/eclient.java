import java.io.*;
import java.net.*;
import java.util.Scanner;

public class eclient {
    public static void main(String[] args) throws IOException {
        try (Socket socket = new Socket("localhost", 8080);
             Scanner scanner = new Scanner(System.in);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            while (true) {
                String inputLine = scanner.nextLine();
                out.println(inputLine);
                if (inputLine.equals("exit")) {
                    break;
                }
                System.out.println("server: " + in.readLine());
            }
        }
    }
}
