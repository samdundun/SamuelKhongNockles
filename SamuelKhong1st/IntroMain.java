package intro;//this is a package declaration

//this is a class header (class declaration)
public class IntroMain {

	public static final String[] DESCRIPTIONS = {"is a student", "is a teacher", "is a human being", "is imaginary"};
	
	public static void main(String[] args) {
		//declaration of a local variable
		//notice the use of the word 'new'
		//new must be used to call a constructor
		CodingConventions conventionsInstance = new CodingConventions("Mr.Nockles ", 0);
		
		conventionsInstance.doStuff();
	}

}
