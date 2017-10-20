package arrays;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		ObjectArrays oA = new ObjectArrays();
		Person s = new Person("Ben", "Nockles", Borough.NY_BOROUGHS[0]);
		int x = 1;
		int[] a = {5,6,7};
		test(s,x,a);
		System.out.println(s+ "\n" + x + "\n" + Arrays.toString(a));

	}
	//test
	public static void test(Person s, int x, int [] arr) {
		s.setFirstName("Ilona");
		//arr = new int[3];
		x = 5; 
		arr[0] = 1;
		arr[1] = 2;
		arr[2] = 3;
	}

}