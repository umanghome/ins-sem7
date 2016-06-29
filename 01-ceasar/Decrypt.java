import java.util.*;

public class Decrypt {

	public static void main (String args[]) {

		// Get terminal
		Scanner terminal = new Scanner(System.in);

		// Get ciphertext
		System.out.print("Cipher: ");
		String cipher = terminal.nextLine();

		// Get key
		System.out.print("Key: ");
		// validate key
		int key = -1;
		while (key < 0 || key > 25) {
			try {
				key = Integer.parseInt(terminal.nextLine());
			} catch (Exception e) {
				// Key isn't parse-able
				System.out.println("Key should be a number! Try again.");
				return;
			}
			
			// Key out of range
			if (key < 0 || key > 26) {
				System.out.println("Key should be between 0 and 25. Try again.");
				return;
			}
		}

		// Get length of cipher
		int length = cipher.length();

		// Initialize plaintext
		String plainText = "";

		// Loop over each character of the string
		for (int i = 0; i < length; i++) {

			// Get first character
			char c = cipher.charAt(i);

			// If the character is an alphabet
			if (Character.isAlphabetic(c)) {

				// Flag for uppercase
				boolean upperCase = Character.isUpperCase(c);

				// Get offset of character from zero
				int temp = -1;
				if (upperCase) {
					temp = (int) c - (int) 'A';
				} else {
					temp = (int) c - (int) 'a';
				}

				// Subtract key from temp
				temp -= key;

				// If subtracting the key results in a negative number,
				// add 26 to get it back in the range of 0-25
				if (temp < 0) {
					temp += 26;
				}

				// Mod 26
				temp %= 26;

				// Generate character with offset of key
				if (upperCase) {
					c = (char) (temp + (int) 'A');
				} else {
					c = (char) (temp + (int) 'a');
				}
			}
			// If the character is a digit
			else if (Character.isDigit(c)) {

				// Get integer from c
				Integer integer = Integer.parseInt(c + "");

				// Subtract key from integer
				int temp = integer.intValue() - key;

				// If subtracting the key results in a negative number,
				// add 10 to get it back in the range of 0-9
				if (temp < 0) {
					temp += 10;
				}

				// Get the last digit
				temp %= 10;

				// Set c as the new digit
				c = (char) ((int) '0' + temp);
			}

			// Add character to plaintext
			plainText += c;

		}

		// Display plaintext
		System.out.println("Plaintext: " + plainText);
	}

}