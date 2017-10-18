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
	Borough home;
	
	public Person(String first, String last, Borough home) {
		this.firstName = first;
		this.lastName = last;
		this.home = home;
	}
	
	public String toString() {
		return "My name is " + firstName + " "+ lastName + " and I live in " + home + ".";
	}
}
