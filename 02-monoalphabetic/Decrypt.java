import java.util.Scanner;

public class Decrypt {
	public static void main (String args[]) {

		Scanner terminal = new Scanner(System.in);

		char[] keys = {'i', 'f', 'p', 's', 'w', 'k', 'd', 'a', 't', 'g', 'z', 'y', 'e', 'm', 'x', 'u', 'r', 'v', 'j', 'b', 'n', 'h', 'l', 'q', 'o', 'c'};

		System.out.print("Ciphertext: ");
		String ciphertext = terminal.nextLine();

		int length = ciphertext.length();

		String plaintext = "";

		for (int i = 0; i < length; i++) {
			char c = ciphertext.charAt(i);
			if (!Character.isAlphabetic(c)) {
				plaintext += c;
				continue;
			}
			boolean isUpperCase = false;
			if (Character.isUpperCase(c)) {
				isUpperCase = true;
				c = (char) ((int) c - (int) 'A' + (int) 'a');
				plaintext += (char) (findIndex(keys, c) + (int) 'A');
			} else {
				plaintext += (char) (findIndex(keys, c) + (int) 'a');
			}
		}

		System.out.println(plaintext);
	}

	public static int findIndex (char arr[], char key) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == key) return i;
		}
		return -1;
	}
}