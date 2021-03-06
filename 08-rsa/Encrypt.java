import java.util.Scanner;

public class Encrypt {

	public static void main (String args[]) {

		Scanner terminal = new Scanner(System.in);

		System.out.print("p: ");
		int p = Integer.parseInt(terminal.nextLine());
		System.out.print("q: ");
		int q = Integer.parseInt(terminal.nextLine());

		int publicKey = KeyGenerator.getPublicKey(p, q);

		System.out.print("Message: ");
		int message = Integer.parseInt(terminal.nextLine());

		int encrypted = (int) (Math.pow(message, publicKey) % (double) ((p - 1) * (q - 1)));

		System.out.println("Ciphertext: " + encrypted);

	}

}