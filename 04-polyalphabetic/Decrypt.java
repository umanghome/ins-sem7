import java.util.*;

public class Decrypt {

	public static void main (String args[]) {

		Scanner terminal = new Scanner(System.in);
		System.out.print("Key: ");
		String key = terminal.nextLine();
		System.out.print("Ciphertext: ");
		String ciphertext = terminal.nextLine();

		int keyLength = key.length();

		int ciphertextLength = ciphertext.length();

		String ciphertextWithoutSpaces = ciphertext.replace(" ", "");

		String longerKey = "";
		if (keyLength < ciphertextWithoutSpaces.length()) {
			int multiply = (int) Math.floor(ciphertextWithoutSpaces.length() / keyLength);
			for (int i = 0; i < multiply; i++) {
				longerKey += key;
			}
			int longerKeyLength = longerKey.length();
			for (int i = 0; i < (ciphertextWithoutSpaces.length() - longerKeyLength); i++) {
				longerKey += key.charAt(i);
			}
		}

		System.out.println("Key is: " + longerKey);


		String plaintext = "";

		int counter = 0;
		for (int i = 0; i < ciphertextLength; i++) {

			char c = ciphertext.charAt(i);
			if (c == ' ') {
				plaintext += ' ';
				continue;
			}

			char shift = key.charAt(counter++ % keyLength);


			if (Character.isUpperCase(shift))
				shift = (char) ((int) shift - (int) 'A');
			else
				shift = (char) ((int) shift - (int) 'a');


			boolean isUpperCase = Character.isUpperCase(c);

			if (isUpperCase)
				c = (char) ((int) c - (int) 'A');
			else
				c = (char) ((int) c - (int) 'a');

			int temp = (int) c;
			temp -= (int) shift;

			c = (char) ((int) c - (int) shift);

			if (temp < 0) {
				c = (char) ((int) c + 26);
			}
			c = (char) ((int) c % 26);

			if (isUpperCase)
				c = (char) ((int) c + (int) 'A');
			else
				c = (char) ((int) c + (int) 'a');
			
			plaintext += c;

		}

		System.out.println("Plaintext: " + plaintext);

	}

}