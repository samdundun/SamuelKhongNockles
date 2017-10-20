package arrays;

public class ObjectArrays {
	Person[] group1;
	Person[] group2;

	public ObjectArrays() {
		Person[] people = new Person[10];
		populate(people);
		//for(Person p: people) {
			//System.out.println(p);
		//}
		
		/*for(Person p: people) {
			p.mingle(people);
			p.printFriends();
			System.out.println("");
		}*/
		//Person[] group1 = selectGroup(people, 5);
		//Person[] group2 = selectGroup(group1, 5);
		//testShuffling();
		
	}
	
	public int countDifferences(Person[] arr1, Person[] arr2) {
		int counter = 0;
		for(int i = 0; i < arr1.length; i++) {
			if(arr1[i] != arr2[i]) {
				counter++;
			}
		}
		return counter;
	}

	public void testShuffling() {
		int average = 0;
		for(int i = 0; i < 100; i++) {
			group1 = selectGroup(group1,group1.length);
			group2 = selectGroup(group1,group1.length);
			average = average + countDifferences(group1,group2);
		}
		average = average/100;
		System.out.println("The average difference is " + average);
		
	}
	
	private Person[] selectGroup(Person[] people, int a) {
		int[] haveSelected = new int[a];
		Person[] output = new Person[a];
		popIntFromPerson(people, haveSelected);
		for(int i = 0; i < a; i++) {
			output[i] = people[haveSelected[i]];
		}
		return output;
		
	}
	private static boolean personInGroup(Person p, Person[] people) {
		for(int i = 0; i < people.length; i++) {
			if(p == people[i]) {
				return true;
			}
		}
		return false;
	}

	private void popIntFromPerson(Person[] people, int[] a) {
		int random = (int)(Math.random()*people.length);
		a[0] = random;
		for(int i = 1; i < a.length; i++) {
			while(Used(random, a)){
			random = (int)(Math.random()*people.length);
			}
			a[i] = random;
		}
	}

	private boolean Used(int random, int[] a) {
		for(int i = 0; i< a .length; i++) {
			if(random == a[i]) {
				return true;
			}
		}
		return false;
	}

	private void populate(Person[] people) {
		for(int i = 0; i < people.length; i++) {
			String firstName = randomNameFrom(Person.FIRST_START,Person.FIRST_MIDDLE,Person.FIRST_END);
			String lastName = randomNameFrom(Person.LAST_START,Person.LAST_MIDDLE,Person.LAST_END);
			Borough b = randomBorough();
			if(Math.random() < .6)
				people[i] = new Student(firstName, lastName, b, (int)(Math.random()*5)+9);
			else	
				people[i] = new Person(firstName, lastName, b);
		}
	}

	private Borough randomBorough() {
		return Borough.NY_BOROUGHS[(int)(Math.random()*Borough.NY_BOROUGHS.length)];
	}

	private String randomNameFrom(String[] f, String[] m, String[] e) {
		return get(f)+get(m)+get(e);
	}

	private String get(String[] a) {
		return a[(int)(Math.random()*a.length)];
	}

}
