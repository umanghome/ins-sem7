public class KeyGenerator {

	public static int getPublicKey (int p, int q) {
		int n = (p * q);
		int phiN = (p - 1) * (q - 1);
		int copy = 2;
		int e = -1;
		while (copy < phiN) {
			if (gcd(phiN, copy) == 1) {
				e = copy;
				break;
			}
			copy++;
		}
		return e;
	}

	public static int getPrivateKey (int p, int q) {
		int e = getPublicKey(p, q);
		int phiN = (p - 1) * (q - 1);
		for (int i = 1; ; i++) {
			if ((i * e) % phiN == 1) {
				return i;
			}
		}
	}

	public static int gcd (int a, int b) {
		if (b == 0) return a;
		else return gcd(b, a % b);
	}

}