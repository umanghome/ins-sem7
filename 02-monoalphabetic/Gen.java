import java.util.*;

public class Gen {

	public static void main (String args[]) {

		Random random = new Random();
		ArrayList<Integer> considered = new ArrayList<Integer>();

		while (considered.size() != 26) {
			int generated = random.nextInt(26);
			if (considered.contains(generated)) continue;
			considered.add(generated);
		}

		for (int i = 0; i < considered.size(); i++) {
			System.out.print("'" + (char) (considered.get(i) + (int) 'a') + "', ");
		}

		System.out.println("");

	}

}