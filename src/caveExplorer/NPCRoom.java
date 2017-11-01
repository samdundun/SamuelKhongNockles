package caveExplorer;

public class NPCRoom extends CaveRoom {

	private NPC presentNPC;
	
	public NPCRoom(String description) {
		super(description);
		presentNPC = null;
	}

	/**
	 * NPCs can enter room if no other NPC is in the room
	 * @return
	 */
	public boolean canEnter() {
		return presentNPC == null;
	}
	
	public void enterNPC(NPC m) {
		presentNPC = m;
	}
	
	public void leaveNPC() {
		presentNPC = null;
	}
	
	/**
	 * There is already a method like this
	 * but it is helpful the other way for referring to it
	 * especially if it is to change the rules of "canEnter"
	 * @return
	 */
	public boolean containsNPC() {
		return presentNPC != null;
	}
	
	//the above methods are new features to a caveroom
	//the methods below replace CaveRoom methods(override)
	
	public String validKeys() {
		return "wdsae";
	}
	
	public void printAllowedEntry() {
		CaveExplorer.print("You can only input W A S D to move or E to interact.");
	}
	
	public void performAction(int direction) {
		if(direction == 4) {
			if(containsNPC() && presentNPC.isActive()) {
				presentNPC.interact();
			}
			else {
				CaveExplorer.print("There is nothing to interact with.");
			}
		}
		else {
			CaveExplorer.print("That key does nothing.");
		}
		
	}
	
	public String getContents() {
		if(containsNPC()&& presentNPC.isActive()) {
			return "M";
		}
		else {
			return  super.getContents();
		}
	}
	
	public String getDescription() {
		if(containsNPC() && !presentNPC.isActive()) {
			return super.getDescription() + "\n"+presentNPC.getInactiveDescription();
		}
		else {
			return super.getDescription() + "\n"+presentNPC.getActiveDescription();
		}
	}
}
