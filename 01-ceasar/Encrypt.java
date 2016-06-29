import java.util.*;

public class Encrypt {

	public static void main (String args[]) {

		// Create scanner
		Scanner terminal = new Scanner(System.in);

		// Get plaintext
		System.out.print("Plaintext: ");
		String plainText = terminal.nextLine();

		// Get key
		System.out.print("Key: ");
		// Validate key
		int key = -1;
		while (key < 0 || key > 25) {
			try {
				key = Integer.parseInt(terminal.nextLine());
			} catch (Exception e) {
				// key isn't parse-able
				System.out.println("Key should be a number! Try again.");
				return;
			}

			// Key out of range
			if (key < 0 || key > 26) {
				System.out.println("Key should be between 0 and 25. Try again.");
				return;
			}
		}

		// Length of plainText
		int length = plainText.length();

		// Initialize ciphertext to be empty
		String cipher = "";

		// Loop over each character in plainText
		for (int i = 0; i < length; i++) {

			// Get character at i-th position
			char c = plainText.charAt(i);

			// If the character is an alphabet
			if (Character.isAlphabetic(c)) {

				// Boolean flag for uppercase
				boolean upperCase = Character.isUpperCase(c);

				// Get offset of character from zero
				if (upperCase) {
					c = (char) ((int) c - (int) 'A');
				} else {
					c = (char) ((int) c - (int) 'a');
				}

				// Add key
				c += (char) key;

				// Mod 26
				c %= 26;

				// Generate character with offset of key
				if (upperCase) {
					c += 'A';		
				} else {
					c += 'a';
				}
			}
			// If the character is a number
			else if (Character.isDigit(c)) {

				// Get integer from c
				Integer integer = Integer.parseInt(c + "");

				// Add key to integer
				int temp = integer.intValue() + key;

				// Get a single digit
				temp %= 10;

				// Set c as the new digit
				c = (char) ((int) '0' + temp);
			}

			// Add character to cipher
			cipher += c;
		}

		// Display cipher
		System.out.println("Ciphertext: " + cipher);

	}

}