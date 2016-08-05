import java.util.Scanner;

public class Decrypt {

	public static void main (String args[]) {

		Scanner terminal = new Scanner(System.in);

		System.out.print("p: ");
		int p = Integer.parseInt(terminal.nextLine());
		System.out.print("q: ");
		int q = Integer.parseInt(terminal.nextLine());

		int privateKey = KeyGenerator.getPrivateKey(p, q);

		System.out.print("Message: ");
		int message = Integer.parseInt(terminal.nextLine());


		int decrypted = (int) (Math.pow(message, privateKey) % (double) ((p - 1) * (q - 1)));

		System.out.println("Plaintext: " + decrypted);

	}

}