import java.util.Scanner;
import java.net.*;
import java.io.*;

public class Bob {

	public static void main (String args[]) {
		try {
			Scanner terminal = new Scanner(System.in);

			System.out.print("p: ");
			int p = Integer.parseInt(terminal.nextLine());
			System.out.print("g: ");
			int g = Integer.parseInt(terminal.nextLine());
			System.out.print("b: ");
			int b = Integer.parseInt(terminal.nextLine());

			int key = (int) (Math.pow(g, b) % (double) p);

			Socket socket = new Socket("localhost", 8888);

			Scanner input = new Scanner(socket.getInputStream());
			PrintWriter out = new PrintWriter(socket.getOutputStream());

			System.out.println("Connected to Alice..");
			System.out.println("Exchanging keys..");

			out.println(key);
			out.flush();

			int _key = Integer.parseInt(input.nextLine());
			int s = (int) (Math.pow(_key, b) % (double) p);

			System.out.println("Shared secret key: " + s);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}