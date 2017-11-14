package javaTheHardWay;

public class Animal {

	private String description;
	
	private Trait trait1;
	private Trait trait2;
	private int age;
	private boolean mated;
	
	
	public static void main(String[] args) {
		
		for(int i = 0; i <10; i++) {
			Animal someanimal = new Animal();
			System.out.println(someanimal);
		}
	}
	
	public Animal() {
		chooseTraits();
		description = getName();
		age = 0;
	}

	public Animal(String description, Trait trait1, Trait trait2) {
		this.trait1 = trait1;
		this.trait2 = trait2;
		while(trait2.equals(trait1)) {
			trait2 = new Trait();
		}
		this.description = description;
	}
	
	private String getName() {
		return "animal";
	}
	
	public String getDescription() {
		return this.getDescription();
	}

	private void chooseTraits() {
		trait1 = new Trait();
		trait2 = new Trait();
		while(trait1.equals(trait2)) {
			trait2 = new Trait();
		}
	}
	
	public String toString(){
	return "a " + age+ " year old, " + trait1+", " + trait2+ " "+ description;
	}

	public Trait getTrait1() {
		return trait1;
	}

	public Trait getTrait2() {
		return trait2;
	}

	public int getAge() {
		return age;
	}
	
	public void increaseAge() {
		age++;
	}
	
	public void act() {
		System.out.println(this + " is sleeping.");
		mated = true;
	}
	
	public boolean hasMated() {
		return mated;
	}
	
	public void setMated(boolean b) {
		this.mated = b;
	}
	
	public void reset() {
		mated = false;
	}	
}

//1. So that they can be called from an outside source since they are private;
//   The reason they don't need a setter is because they are set in a different way
//2. To make sure that opposite traits dont exist like furry and hairless