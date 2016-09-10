import java.util.Scanner;
import java.net.*;
import java.io.*;

public class Alice {
	public static void main (String args[]) {
		try {
			Scanner terminal = new Scanner(System.in);
			ServerSocket server = new ServerSocket(8888);

			System.out.print("p: ");
			int p = Integer.parseInt(terminal.nextLine());
			System.out.print("g: ");
			int g = Integer.parseInt(terminal.nextLine());
			System.out.print("a: ");
			int a = Integer.parseInt(terminal.nextLine());

			int key = (int) (Math.pow(g, a) % (double) p);

			Socket socket = server.accept();
			System.out.println("Connected to Bob..");
			System.out.println("Exchanging keys..");

			Scanner input = new Scanner(socket.getInputStream());
			PrintWriter out = new PrintWriter(socket.getOutputStream());

			out.println(key);
			out.flush();

			int _key = Integer.parseInt(input.nextLine());

			int s = (int) (Math.pow(_key, a) % (double) p);

			System.out.println("Shared secret key: " + s);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}