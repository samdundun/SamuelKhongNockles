package arrays;

public class Student extends Person {

	public static final String [] grades = {"Freshman", "Sophmore", "Junior", "Senior", "Super Senior"};
	
	private String grade;
	
	public Student(String first, String last, Borough home, int gradeLevel) {
		super(first, last, home);
		int index = gradeLevel-9;
		this.grade = grades[index];
	}

	public String toString() {
		return super.toString()+ "I am also a " + grade+ ".\n";
	}
	
}
//Java is pass by value
//meaning the parameters of a method are just values not references
//if you change those values, the original object is not affected
//in this case, 'name' will not be changed. In fact nothing can change
// this.firstname via name