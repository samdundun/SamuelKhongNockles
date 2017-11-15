package javaTheHardWay;

public class Habitat extends Environment {

	private Animal[] animals;
	
	public static void main(String[] args) {
		Habitat h = new Habitat(5);
		int count = 0;
		while(count < 6) {
			Animal a = new Animal();
			h.addAnimal(a);
			count++;
		}
		System.out.println(h);
	}
	
	public Habitat(int livingCapacity) {
		super(livingCapacity);
		animals = new Animal[livingCapacity];
	}
	
	public String toString() {
		return super.toString()+"\nHabitants:\n" + animalReport();
	}

	public String animalReport() {
		String s = "";
		for(Animal a: animals) {
			s+=a+"\n";
		}
		return s;
	}
	
	public Animal[] getAnimals() {
		return animals;
	}

	public void addAnimal(Animal a) {
		int i = 0;
		while(i<animals.length) {
			if(animals[i] == null) {
				animals[i] = a;
				break;
			}
			i++;
		}
	}
	
	public void removeAnimal(int i) {
		animals[i] = null;
	}

	public void removeAnimal(Animal a) {
		for(int i = 0; i < animals.length; i++) {
			if(animals[i] == a) {
				animals[i] = null;
			}
		}
	}
}

//1. livingCapacity is the length of the array and if addAnimals is called while it is reached then it does not put the animal in
//2. It returns "An vast field"
