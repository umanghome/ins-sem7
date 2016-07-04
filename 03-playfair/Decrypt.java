import java.util.*;

public class Decrypt {

	public static void main (String args[]) {

		Scanner terminal = new Scanner(System.in);
		System.out.print("Key: ");
		String key = terminal.nextLine();
		key = key.toLowerCase();

		// Get alphabets from key
		ArrayList<Character> alphabets = new ArrayList<Character>(26);
		for (int i = 0; i < key.length(); i++) {
			char c = key.charAt(i);
			if (!Character.isAlphabetic(c)) continue;
			if (alphabets.contains(key.charAt(i))) continue;
			if (c == 'j') continue;
			alphabets.add(key.charAt(i));
		}

		// Get the remaining alphabets
		for (int i = 0; i < 26; i++) {
			char c = (char) (i + (int) 'a');
			if (alphabets.contains(c)) continue;
			if (c == 'j') continue;
			alphabets.add(c);
		}

		// Generate matrix
 		char[][] matrix = new char[5][5];
 		for (int i = 0; i < 25; i++) {
 			char c = alphabets.get(i);
 			matrix[(int) (i / 5)][i % 5] = c;
 		}

 		// Display Matrix
 		for (int i = 0; i < 5; i++) {
 			for (int j = 0; j < 5; j++) {
 				System.out.print(matrix[i][j] + " ");
 			}
 			System.out.println("");
 		}

 		// Get ciphertext
 		System.out.print("Ciphertext: ");
 		String ciphertext = terminal.nextLine();
 		String plaintext = "";
 		String ciphertextSave = ciphertext;

 		ciphertext = ciphertext.toLowerCase();
 		ciphertext = ciphertext.replace("j", "i");
 		ciphertext = ciphertext.replace(" ", "");

 		// Generate pairs
 		char[][] pairs = new char[(int) Math.ceil(ciphertext.length() / 2)][2];
 		int counter1 = 0;
 		int counter2 = 0;
 		for (int i = 0; i < ciphertext.length(); i++) {

 			char c = ciphertext.charAt(i);
 			if (c == ' ' || !Character.isAlphabetic(c)) continue;

 			int index1 = (int) Math.floor(counter1 / 2);
 			int index2 = counter2 % 2;

 			pairs[index1][index2] = c;
 			counter1++;
 			counter2++;

 		}
 		System.out.println("");

 		for (int i = 0; i < pairs.length; i++) {
 			System.out.print(pairs[i][0] + "" + pairs[i][1] + " ");
 		}
 		System.out.println("");

 		for (int i = 0; i < pairs.length; i++) {
 			plaintext += playFair(matrix, pairs[i][0], pairs[i][1]);
 		}

 		plaintext = plaintext.replace("x", "");
 		plaintext = plaintext.replace("i", "(i/j)");

 		System.out.println("Plaintext: " + plaintext);

	}

	public static ArrayList<Integer> findInMatrix (char[][] matrix, char key) {
		ArrayList<Integer> toReturn = new ArrayList<Integer>();

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (matrix[i][j] == key) {
					toReturn.add(i);
					toReturn.add(j);
					return toReturn;
				}
			}
		}

		return null;
	}

	public static String playFair (char[][] matrix, char a, char b) {

		ArrayList<Integer> firstIndices = findInMatrix(matrix, a);
		ArrayList<Integer> secondIndices = findInMatrix(matrix, b);

		// Same row
		if (firstIndices.get(0) == secondIndices.get(0)) {
			String toReturn = "";
			int colIndex = firstIndices.get(1) - 1;
			if (colIndex < 0) colIndex += 5;
			colIndex %= 5;
			toReturn += matrix[firstIndices.get(0)][colIndex];
			colIndex = secondIndices.get(1) - 1;
			if (colIndex < 0) colIndex += 5;
			colIndex %= 5;
			toReturn += matrix[secondIndices.get(0)][colIndex];
			return toReturn;
		}

		// Same column
		if (firstIndices.get(1) == secondIndices.get(1)) {
			String toReturn = "";
			int rowIndex = firstIndices.get(0) - 1;
			if (rowIndex < 0) rowIndex += 5;
			rowIndex %= 5;
			toReturn += matrix[rowIndex][firstIndices.get(1)];
			rowIndex = secondIndices.get(0) - 1;
			if (rowIndex < 0) rowIndex += 5;
			rowIndex %= 5;
			toReturn += matrix[rowIndex][secondIndices.get(1)];
			return toReturn;
		}

		String toReturn = "";
		toReturn += matrix[firstIndices.get(0)][secondIndices.get(1)];
		toReturn += matrix[secondIndices.get(0)][firstIndices.get(1)];

		return toReturn;

	}

}