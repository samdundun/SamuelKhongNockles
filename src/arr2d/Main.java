package arr2d;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] test = {5,4,5,7,10};
		int[] test1 = {1};
		changeNeighbor(test1, 0);
		System.out.println(Arrays.toString(test1));

	}
	
	public static void changeNeighbor(int[] arr, int psn) {
			arr[psn]++;
			if(psn < arr.length-1) {
				arr[psn+1]--;
			}
			if (psn>0) {
				arr[psn-1]--;
			}
		}

}
