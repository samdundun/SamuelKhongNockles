package javaTheHardWay;

public class Wilderness extends Habitat {

	private String description;

	public Wilderness(String description, int livingCapacity) {
		super(livingCapacity);
		this.description = description;
	}

	public static void main(String[] args) {
		Wilderness w = new Wilderness("An empty desert", 10);
		w.simulate(3);
	}

	public String toString() {
		return this.description + "\n" + animalReport();
	}
	
	private void simulate(int rounds) {
		for(int i = 0; i < rounds; i++) {
			for(Animal a : getAnimals()) {
				if(a instanceof ReproductionAnimal)((ReproductionAnimal)a).reset();
			}
			int predatorCount = 0;
			int preyCount = 0;
			for(Animal a: getAnimals()) {
				if(a instanceof Predator) {
					predatorCount++;
				}else if(a instanceof Prey) {
					preyCount++;
				}
			}
			String s = "\nROUND " + (i+1) + "\n Predators : " + predatorCount + ", PREY: " + preyCount + "\n" + animalReport();
			System.out.print(s);
			for(Animal a: getAnimals()) {
				if(a != null)a.act();
			}
			growPlants();
		}
		
	}

}
//1. Return the animals alive
//2. You need to parse the animal into a reproduction animal