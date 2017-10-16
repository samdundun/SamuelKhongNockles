package arrays;

import java.util.Arrays;

public class ArraysMain {
	
	private String[] testArray;
	public int[] intRay;
	
	public ArraysMain() {
		intRay = new int[100];
		populat1ToN(intRay);
		shuffle(intRay);
		//swap(intRay, 0, 1);
		//populate(intRay);
		//checkOccurences(intRay,2,12);
		pIntRays(intRay);
	}
	private void shuffle(int[] arr) {
		for(int i = 0; i < arr.length; i++) {
			swap(arr,(int)(Math.random()*arr.length), (int)(Math.random()*arr.length));
		}
		
	}
	private void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		
	}
	private void populat1ToN(int[] arr) {
		for(int i = 0; i <arr.length; i++) {
			arr[i] = i+1;
		}
	}
	private void checkOccurences(int[] arr, int start , int end) {
		int[] counter = new int[end-start+1];
		for(int value: arr) {
			counter[value-start]++;
		}
		for(int i = 0; i < counter.length; i++){
			System.out.println("A " +(start+i)+ " was rolled " + counter[i] + " times.");
		}
	}
	private void populate(int[] intRay2) {
		for(int i = 0; i < intRay2.length; i++) {
			intRay2[i] = diceRoll(2);
		}
		
	}
	private void pIntRays(int[] intRay3) {
		System.out.println(Arrays.toString(intRay3));
	}
	
	public void notes() {
		testArray = new String[50];
		for(int i = 0; i < testArray.length;i++) {
			System.out.println("The #" + (i+1) + " item is:" + testArray[i]);
		}
		for(String value:testArray) {
			System.out.println(value);
		}
	}

	public static void main(String[] args) {
		ArraysMain arrayPractice = new ArraysMain();

	}

	public int diceRoll(int numberOfDice) {
		int output = 0;
		for(int i = 0; i < numberOfDice; i++) {
			output= output + 1 + (int)(Math.random()*6);
		}
		return output;
		
	}
	
}
