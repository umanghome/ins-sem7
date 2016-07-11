import java.util.*;

public class Encrypt {
	public static void main (String args[]) {

		Scanner terminal = new Scanner(System.in);
		System.out.print("Key is a NxN matrix. Enter N: ");
		int n = Integer.parseInt(terminal.nextLine());

		int matrix[][] = new int[n][n];

		System.out.println("Enter the elements of the key..");
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				matrix[i][j] = Integer.parseInt(terminal.nextLine());
			}
		}

		System.out.print("Plaintext: ");
		String plaintext = terminal.nextLine();
		plaintext = plaintext.replace(" ", "");

		if (plaintext.length() > n);
		int diff = (plaintext.length() % n);

		for (int i = 0; i < diff; i++)
			plaintext += 'x';

		System.out.println("Plaintext is: " + plaintext);
		System.out.println("Key is: ");
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(matrix[i][j] + "\t");
			}
			System.out.println("");
		}

		int div = (int) Math.floor(plaintext.length() / n);

		int plaintextMatrix[][] = new int[div][n];

		int counter = 0;
		for (int i = 0; i < div; i++) {
			for (int j = 0; j < n; j++) {
				plaintextMatrix[i][j] = (int) plaintext.charAt(counter++);
				plaintextMatrix[i][j] -= (int) 'a';
			}
		}

		System.out.println("Plaintext Matrix: ");
		for (int i = 0; i < div; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(plaintextMatrix[i][j] + "\t");
			}
			System.out.println("");
		}

		int result[][] = new int[div][n];

		for (int i = 0; i < div; i++) {
			for (int j = 0; j < n; j++) {
				result[i][j] = 0;
				for (int k = 0; k < n; k++) {
					result[i][j] += (plaintextMatrix[i][k] * matrix[k][j]);
				}
				result[i][j] %= 26;
			}
		}

		// System.out.println("Result Matrix: ");
		// for (int i = 0; i < div; i++) {
		// 	for (int j = 0; j < n; j++) {
		// 		System.out.print(result[i][j] + "\t");
		// 	}
		// 	System.out.println("");
		// }

		String ciphertext = "";

		for (int i = 0; i < div; i++) {
			for (int j = 0; j < n; j++) {
				ciphertext += ((char) (result[i][j] + (int) 'a'));	
			}
		}

		System.out.println("Ciphertext: " + ciphertext);

	}

}