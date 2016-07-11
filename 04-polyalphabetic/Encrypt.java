import java.util.*;

public class Encrypt {

	public static void main (String args[]) {

		Scanner terminal = new Scanner(System.in);
		System.out.print("Key: ");
		String key = terminal.nextLine();
		System.out.print("Plaintext: ");
		String plaintext = terminal.nextLine();

		int keyLength = key.length();

		int plaintextLength = plaintext.length();

		String plaintextWithoutSpaces = plaintext.replace(" ", "");

		String longerKey = "";
		if (keyLength < plaintextWithoutSpaces.length()) {
			int multiply = (int) Math.floor(plaintextWithoutSpaces.length() / keyLength);
			for (int i = 0; i < multiply; i++) {
				longerKey += key;
			}
			int longerKeyLength = longerKey.length();
			for (int i = 0; i < (plaintextWithoutSpaces.length() - longerKeyLength); i++) {
				longerKey += key.charAt(i);
			}
		}

		System.out.println("Key is: " + longerKey);


		String ciphertext = "";

		int counter = 0;
		for (int i = 0; i < plaintextLength; i++) {

			char c = plaintext.charAt(i);
			if (c == ' ') {
				ciphertext += ' ';
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

			c = (char) ((int) c + (int) shift);
			c = (char) ((int) c % 26);

			if (isUpperCase)
				c = (char) ((int) c + (int) 'A');
			else
				c = (char) ((int) c + (int) 'a');
			
			ciphertext += c;

		}

		System.out.println("Ciphertext: " + ciphertext);

	}

}