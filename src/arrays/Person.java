package arrays;

public class Person {

	public static final String[] FIRST_START = {"Chr","M","L","J","S","Gre","Ph","E","A","C","T","R",};
	public static final String[] FIRST_MIDDLE = {"isti", "icha", "am", "era", "eta", "ala", "ina", "ara","gor","enn",""};
	public static final String[] FIRST_END = {"","na","antha","n","r","s","rs","mp","les", "y","ric","lex", "an","uel"};
	
	public static final String[] LAST_START = {"Tr","Br","L","Gr","Sh","B","Th", "Kh"};
	public static final String[] LAST_MIDDLE = {"","om", "o", "an", "ola", "et", "e", "is"};
	public static final String[] LAST_END = {"", "tan", "y", "dy", "ty","ly", "man","en","de","son","o","les", "ers", "rian","ong"};
	
	
	String firstName;
	String lastName;
	String nickName;
	Borough home;
	private Hobby hobby;
	private Person[] friends;
	
	public Person(String first, String last, Borough home) {
		this.firstName = first;
		this.lastName = last;
		this.home = home;
		this.hobby = Hobby.randomHobby();
		friends = new Person[3];
		this.nickName = nickName(firstName);
	}
	
	public void mingle(Person[] people) {
		for(Person p: people) {
			if(p != this) {
				p = betterFriend(p, friends[0]);
				
				addFriendsToFirstPlace(p);
			}
		}
	}
	
	private Person betterFriend(Person p, Person q) {
		if(p == null) {
			return q;
		}
		if(q == null) {
			return p;
		}
		if(p.getClass() == this.getClass() && q.getClass() == this.getClass()) {
			if(p.hobby == this.hobby)
				return p;
			else if(q.hobby == this.hobby)
				return q;
		}
		if(p.getClass() == this.getClass()) {
			return p;
		}
		if(q.getClass() == this.getClass()) {
			return q;
		}
		
		return p;
	}

	private void addFriendsToFirstPlace(Person p) {
		for(int i = friends.length-1; i > 0; i--) {
			friends[i] = friends[i-1];
		}
		friends[0] = p;
	}
	
	public void printFriends() {
		System.out.println("My name is " + firstName + " "+ lastName + ". My hobby is " + hobby + " and these are my friends:");
		for(Person f : friends) {
			if(f!= null ) System.out.println(f);
		}
	}
	public static String nickName(String name) {
		String output = "";
		boolean pastfirstVowel = false;
		for(int i = 0; i < name.length(); i++) {
			String currentLetter =  name.substring(i,i+1);
			if(isVowel(currentLetter)) {
				if(pastfirstVowel) {
					break;
				}
				else {
					output+= currentLetter;
					pastfirstVowel = true;
				}
			}
			else {
				output+= currentLetter;
			}
		}
		return output;
	}
	
	private static boolean isVowel(String a) {
		return ("aeiouAEIOU".indexOf(a) != -1);
	}

	public String toString() {
		return "My name is " + firstName + " "+ lastName + " and I live in " + home + ".\nMy hobby is " + hobby + " and my nickname is " + nickName + ".\n";
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
		this.nickName = nickName(firstName);
	}

	
}
