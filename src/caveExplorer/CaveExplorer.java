package caveExplorer;

import java.util.Scanner;

public class CaveExplorer {

	public static CaveRoom[][]caves; //every room in the cave
	public static Scanner in;//for user input
	public static CaveRoom currentRoom;//changes based on how the user navigated 
	public static Inventory inventory;// where all objects found in cave are kept
	public static boolean playing = true;
	public static NPC[] npcs;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		in = new Scanner(System.in);
		CaveRoom.setUpCaves();
		
		inventory = new Inventory();
		startExploring();
	}

	private static void startExploring() {
		while(playing) {
			npcActions();
			print(inventory.getDescription());
			print(currentRoom.getDescription());
			print("What would you like to do?");
			String input = in.nextLine();
			currentRoom.interpretInput(input);
		}
		
	}
	
	private static void npcActions() {
		for(NPC n : npcs) {
			n.act();
		}
		inventory.updateMap();
	}

	public static void print(String s) {
		//NOTE: LATER YOU CAN REPLACE WITHT HE MORE SOPHISTICATED "MULTILINEPRINT"
		System.out.println(s);
	}

}
