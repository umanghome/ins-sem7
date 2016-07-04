import java.util.Scanner;

public class Encrypt {
	public static void main (String args[]) {

		Scanner terminal = new Scanner(System.in);

		char[] keys = {'i', 'f', 'p', 's', 'w', 'k', 'd', 'a', 't', 'g', 'z', 'y', 'e', 'm', 'x', 'u', 'r', 'v', 'j', 'b', 'n', 'h', 'l', 'q', 'o', 'c'};

		System.out.print("Plaintext: ");
		String plaintext = terminal.nextLine();

		int length = plaintext.length();

		String ciphertext = "";

		for (int i = 0; i < length; i++) {
			char c = plaintext.charAt(i);
			if (!Character.isAlphabetic(c)) {
				ciphertext += c;
				continue;
			}
			boolean isUpperCase = false;
			if (Character.isUpperCase(c)) {
				isUpperCase = true;
				c = (char) ((int) c - (int) 'A' + (int) 'a');
			}
			if (isUpperCase) {
				ciphertext += (char) ((int) keys[c - 'a'] - (int) 'a' + (int) 'A');
			} else {
				ciphertext += keys[c - 'a'];
			}
		}

		System.out.println(ciphertext);

	}
}