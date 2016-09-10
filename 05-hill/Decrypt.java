import java.util.*;

public class Decrypt {
	public static void main (String args[]) {

		Scanner terminal = new Scanner(System.in);
		System.out.print("Key is a NxN matrix, where N = 2 or 3. Enter N: ");
		int n = Integer.parseInt(terminal.nextLine());

		int matrix[][] = new int[n][n];

		System.out.println("Enter the elements of the key..");
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				matrix[i][j] = Integer.parseInt(terminal.nextLine());
			}
		}

		if (n == 2) {
			int adjugateMatrix[][] = new int[2][2];
			adjugateMatrix[0][0] = matrix[1][1];
			adjugateMatrix[1][1] = matrix[0][0];
			adjugateMatrix[0][1] = matrix[0][1] * (-1);
			adjugateMatrix[1][0] = matrix[1][0] * (-1);

			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < 2; j++) {
					matrix[i][j] = adjugateMatrix[i][j];
					if (matrix[i][j] < 0) {
						matrix[i][j] += 26;
					}
				}
			}

		} else {
			int adjugateMatrix[][] = new int[3][3];
			adjugateMatrix = getAdjugateMatrix(matrix);

			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					matrix[j][i] = adjugateMatrix[i][j];
				}
			}

			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					System.out.print(matrix[i][j] + "\t");
				}
				System.out.println("");
			}

		}

		System.out.print("Ciphertext: ");
		String ciphertext = terminal.nextLine();
		ciphertext = ciphertext.replace(" ", "");

		if (ciphertext.length() > n);
		int diff = (ciphertext.length() % n);

		for (int i = 0; i < diff; i++)
			ciphertext += 'x';

		System.out.println("Ciphertext is: " + ciphertext);
		
		System.out.println("Key is: ");
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(matrix[i][j] + "\t");
			}
			System.out.println("");
		}

		int div = (int) Math.floor(ciphertext.length() / n);

		int ciphertextMatrix[][] = new int[div][n];

		int counter = 0;
		for (int i = 0; i < div; i++) {
			for (int j = 0; j < n; j++) {
				ciphertextMatrix[i][j] = (int) ciphertext.charAt(counter++);
				ciphertextMatrix[i][j] -= (int) 'a';
			}
		}

		System.out.println("Ciphertext Matrix: ");
		for (int i = 0; i < div; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(ciphertextMatrix[i][j] + "\t");
			}
			System.out.println("");
		}

		int result[][] = new int[div][n];


		for (int i = 0; i < div; i++) {
			for (int j = 0; j < n; j++) {
				result[i][j] = 0;
				for (int k = 0; k < n; k++) {
					result[i][j] += (matrix[i][k] * ciphertextMatrix[k][j]);
				}
				result[i][j] %= 26;
				if (result[i][j] < 0) {
					result[i][j] += 26;
				}
			}
		}

		for (int i = 0; i < div; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(result[i][j] + "\t");
			}
			System.out.println("");
		}
		
		String plaintext = "";

		for (int i = 0; i < div; i++) {
			for (int j = 0; j < n; j++) {
				plaintext += ((char) (result[i][j] + (int) 'a'));	
			}
		}

		System.out.println("plaintext: " + plaintext);

	}

	private static int[][] getAdjugateMatrix (int[][] matrix) {
		int adjugateMatrix[][] = new int[3][3];

		int sign = 0;

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {

				ArrayList<Integer> list = new ArrayList<Integer>();

				for (int k = 0; k < 3; k++) {

					for (int l = 0; l < 3; l++) {

						if (k == i || l == j) continue;
						list.add(matrix[k][l]);
					}
				}
				int det = deteminant(list);
				if (sign % 2 != 0) det = -det;
				adjugateMatrix[i][j] = det;
				sign++;

			}
		}

		return adjugateMatrix;

	}

	private static int deteminant (ArrayList<Integer> list) {
		int det = ((list.get(0) * list.get(3)) - (list.get(1) * list.get(2))) % 26;
		return det;
	}

}