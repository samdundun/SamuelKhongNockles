package recursion;

public class Hanoi {

	public static void main(String[] args) {
		hanoi(7, "a", "b", "c");

	}

	public static void hanoi(int n, String a, String b, String c) {
		if(n == 1) {
			System.out.println(a + " to " + c);
		}
		else {
			hanoi(n-1, a, c, b);
			System.out.println(a + " to " + c);
			hanoi(n-1, b, a, c);
		}
	}
}
