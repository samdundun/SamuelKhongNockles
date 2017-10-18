package arrays;

import java.util.Arrays;

public class ArraysMain {
	
	private String[] testArray;
	public int[] intRay;
	
	public ArraysMain() {
		intRay = new int[100000];
		populate(intRay);
		int[] consecTest1 = {1,2,3,6,7,8,9,10,11,45,46,47};
		int[] consecTest2 = {10,11,12,13,14,15,1,2,3,4,5,8,9,0,2,3,4,5,66,67,68,69,70,71,72,73};
		//cycleThrough(intRay, 20);
		//frontToBack(intRay);
		//swap(intRay, 0, 1);
		//populate(intRay);
		//checkOccurences(intRay,2,12);
		//pIntRays(reverseOrder(intRay));
		pIntRays(intRay);
		//System.out.println(countLessThan(intRay,2));
		//System.out.println(longestConsecutiveSequence(consecTest1));
		//System.out.println(longestConsecutiveSequence(intRay));
		//getConsecDice(intRay);
		//pIntRays(longestConsecSeqAndPos(consecTest2));
		
	}
	private void getConsecDice(int[] intRay2) {
		int counter = 1;
		while(longestConsecutiveSequence(intRay) != 11) {
			System.out.println("This is the attempt #" + counter);
			System.out.println("the longest consecutive dice roll was " +  longestConsecutiveSequence(intRay));
			System.out.println("At position " + posLongestConsecutiveSequence(intRay));
			pIntRays(longestConsecSeqAndPos(intRay));
			populate(intRay);
			counter++;
		}
	}
	public int[] longestConsecSeqAndPos(int[] arr) {
		int[] output = new int [longestConsecutiveSequence(arr)];
		for(int i = 0; i< longestConsecutiveSequence(arr); i++) {
			output[i] = arr[posLongestConsecutiveSequence(arr) + i];
		}
		return output;
	}
	public int longestConsecutiveSequence(int[] arr) {
		int counter = 0;
		int longest = 0;
		for(int i = 0; i < arr.length-1;i++) {
			if(arr[i] + 1 == arr[i+1]) {
				if(counter == 0)
					counter = 2;
				else
					counter++;
			}
			else {
				counter = 0;
			}
			if(counter > longest) {
				longest = counter;
			}
			
		}
		return longest;
	}
	public int posLongestConsecutiveSequence(int[] arr) {
		int counter = 0;
		int longest = 0;
		int pos = 0;
		for(int i = 0; i < arr.length-1;i++) {
			if(arr[i] + 1 == arr[i+1]) {
				if(counter == 0)
					counter = 2;
				else
					counter++;
			}
			else {
				counter = 0;
			}
			if(counter > longest) {
				longest = counter;
				pos = i-longest+2;
			}
			
		}
		return pos;
	}
	public void frontToBack(int[] arr) {
		int temp = arr[0];
		for(int i = 0; i < arr.length-1; i++) {
			arr[i] = arr[i+1];
		}
		arr[arr.length-1] = temp;
	}
	public void cycleThrough(int[] arr, int a) {
		for(int i = 0; i < a; i++) {
			frontToBack(arr);
		}
	}
	private int countLessThan(int[] arr, int i) {
		int counter = 0;
		for(int j = 0; j<arr.length; j++) {
			if(arr[j] < i)
				counter++;
		}
		return counter;
		
	}
	private int[] reverseOrder(int[] arr) {
		int[] output = new int [arr.length];
		int j = 0;
		for(int i = output.length-1; i >-1; i--) {
			output[j] = arr[i];
			j++;
			
		}
		return output;
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
