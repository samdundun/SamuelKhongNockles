package caveExplorer;

public class CaveRoom {

	private String description;//tells what the room looks like
	private String directions;//tells what you can do
	private String contents;//a symbol representing what's in the room
	private String defaultContents;
	//the rooms are organized by direction, 'null' signifies no room/door in that direction
	private CaveRoom[] borderingRooms;
	private Door[] doors; 

	//constants
	public static final int NORTH = 0;
	public static final int EAST = 1;
	public static final int SOUTH = 2;
	public static final int WEST = 3;

	public CaveRoom(String description) {
		this.description = description;
		setDefaultContents(" ");
		contents = defaultContents;
		//difference between defaultContents and contents is "contents" becomes an 'X' when 
		//you are inside this room, when you leave, it goes back to defaultContents

		//note: by default, arrays will populate with 'null' meaning there are no connections
		borderingRooms = new CaveRoom[4];
		doors = new Door[4];
		setDirections();
	}

	/**
	 * for every door in door[] appends a String to "directions" 
	 * describing the access
	 * for example:
	 * 	"There is a door to the North"
	 * 	"There is a door to the South"...etc
	 * 
	 * If there are no doors at all, directions should say:
	 * 	"There are no doors, you are trapped in here."
	 */

	public void setDirections() {
		directions = "";
		boolean doorFound = false;
		for(int i = 0; i < doors.length;i++) {
			if(doors[i] != null) {
				doorFound = true;
				directions += "\nThere is a " +doors[i].getDescription() + " to " + 
						toDirection(i)+ "."+doors[i].getDetails();
			}
		}
		if(!doorFound) {
			directions += "There is no way out. You are trapped in here.";
		}
	}

	/**
	 * converts an int to a direction
	 * for exampleE:
	 * 	toDirection(0) => "the North" etc
	 * @param dir
	 * @return
	 */
	public static String toDirection(int dir) {
		String[] output = {"the North","the East","the South","the West"};
		return output[dir];
	}

	public void enter() {
		contents = "X";
	}
	public void leave() {
		contents = defaultContents;
	}

	/**
	 * Gives this room access to anotherRoom (and vice-versa)
	 * and sets a door between them , updating the directions
	 * @param direction
	 * @param anotherRoom
	 * @param door
	 */
	public void setConnection(int direction, CaveRoom anotherRoom, Door door){
		addRoom(direction, anotherRoom, door);
		anotherRoom.addRoom(oppositeDirection(direction), this, door);
	}

	public static int oppositeDirection(int direction) {
		int[] output = {2,3,0,1};
		return output[direction];
	}

	public void addRoom(int direction, CaveRoom cave, Door door) {
		borderingRooms[direction] = cave;
		doors[direction] = door;
		setDirections();
	}

	public void interpretInput(String input) {
		while(!isValid(input)) {
			printAllowedEntry();
			input = CaveExplorer.in.nextLine();
		}
		String dirs = validKeys();
		respondToKey(dirs.indexOf(input));
	}
	/**
	 * override to print a custom string describing what keys do
	 */
	public void printAllowedEntry() {
		CaveExplorer.print("You can only input W A S D");
	}
	/**
	 * override to add more keys
	 */
	public String validKeys() {
		return "wdsa";
	}

	private boolean isValid(String input) {
		String validEntries = validKeys();
		return validEntries.indexOf(input) > -1 && input.length() == 1;
	}

	private void respondToKey(int direction) {
		//first protect against null pointer exception
		//(user cannot go through non-existent door
		if(direction < 4) {
			if(borderingRooms[direction]!= null && doors[direction]!= null) {
				CaveExplorer.currentRoom.leave();
				CaveExplorer.currentRoom = borderingRooms [direction];
				CaveExplorer.currentRoom.enter();
				CaveExplorer.inventory.updateMap();
			}
		}
		else {
			performAction(direction);
		}
	}

	/**
	 * Override to give response to keus other than wasd
	 * @param direction
	 */
	public void performAction(int direction) {
		CaveExplorer.print("That key does nothing.");
		
	}

	/**
	 * This will be where your group sets up all the caves and all the connections
	 */
	public static void setUpCaves() {
		//All of this code can be changed
		//1. Decide how big your caves should be
		CaveExplorer.caves = new NPCRoom[7][7];
		//2.Populate with caves and a default description : hint: when starting, use coordinates (helps debug)
		for(int row = 0; row < CaveExplorer.caves.length; row++) {
			for(int col = 0; col < CaveExplorer.caves[0].length; col++) {
				//create a "default" cave
				CaveExplorer.caves[row][col] = new NPCRoom("this cave has coordinates ("+row+","+col+")");

			}
		}
		//3. replace default rooms with custom rooms
		//Will be done later

		CaveExplorer.npcs = new Enemy[1];
		
		CaveExplorer.npcs[0] = new Enemy();
		
		CaveExplorer.npcs[0].setPosition(0, 4);
		
		//4. Set your starting room:
		CaveExplorer.currentRoom = CaveExplorer.caves[6][3];
		CaveExplorer.currentRoom.enter();
		//5. Set up doors
		CaveRoom[][] c = CaveExplorer.caves;
		c[0][1].setConnection(SOUTH, c[1][1], new Door());
		c[0][1].setConnection(EAST, c[0][2], new Door());
		c[0][2].setConnection(EAST, c[0][3], new Door());
		c[0][3].setConnection(EAST, c[0][4], new Door());
		c[0][4].setConnection(EAST, c[0][5], new Door());
		c[1][1].setConnection(EAST, c[1][2], new Door());
		c[1][2].setConnection(EAST, c[1][3], new Door());
		c[1][3].setConnection(EAST, c[1][4], new Door());
		c[1][4].setConnection(EAST, c[1][5], new Door());
		c[1][3].setConnection(SOUTH, c[2][3], new Door());
		c[2][3].setConnection(SOUTH, c[3][3], new Door());
		
		
		c[6][3].setConnection(NORTH, c[5][3], new Door());
		c[5][3].setConnection(EAST, c[5][4], new Door());
		c[5][3].setConnection(WEST, c[5][2], new Door());
		c[5][2].setConnection(WEST, c[5][1], new Door());
		c[5][1].setConnection(SOUTH, c[6][1], new Door());
		c[5][1].setConnection(NORTH, c[4][1], new Door());
		c[4][1].setConnection(NORTH, c[3][1], new Door());
		c[3][1].setConnection(EAST, c[3][2], new Door());
		c[3][2].setConnection(EAST, c[3][3], new Door());
		c[5][4].setConnection(EAST, c[5][5], new Door());
		c[5][5].setConnection(SOUTH, c[6][5], new Door());
		c[5][5].setConnection(NORTH, c[4][5], new Door());
		c[4][5].setConnection(NORTH, c[3][5], new Door());
		c[3][5].setConnection(EAST, c[3][6], new Door());
	}

	public String getDescription() {
		return description + "\n" + directions;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public void setDefaultContents(String defaultContents) {
		this.defaultContents = defaultContents;
	}

	public Door getDoor(int dir) {
		if(dir >= 0 && dir < doors.length) {
			return doors[dir];
		}
		else {
			return null;
		}
	}



}
