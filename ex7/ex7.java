import java.math.BigInteger;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ex7 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Get generator and data from user
        System.out.println("Enter Generator:");
        String generator = br.readLine();
        System.out.println("Enter Data:");
        String data = br.readLine();

        // Pad data with zeros
        StringBuilder paddedData = new StringBuilder(data);
        for (int i = 0; i < generator.length() - 1; i++) {
            paddedData.append("0");
        }

        // Compute the CRC code
        String code = paddedData.toString();
        String remainder = divide(code, generator);
        code = data + remainder;

        System.out.println("The transmitted Code Word is: " + code);
        System.out.println("Please enter the received Code Word: ");
        String receivedCode = br.readLine();

        // Check if the received code has errors
        String remainder2 = divide(receivedCode, generator);
        if (Integer.parseInt(remainder2) == 0) {
            System.out.println("The received code word contains no errors.");
        } else {
            System.out.println("The received code word contains errors.");
        }
    }
//Compute the remainder of the division of num1 by num2
   static String divide(String num1, String num2) {
    BigInteger dividend = new BigInteger(num1, 2);
    BigInteger divisor = new BigInteger(num2, 2);
    BigInteger[] quotientAndRemainder = dividend.divideAndRemainder(divisor);
    return quotientAndRemainder[1].toString(2);
}

}