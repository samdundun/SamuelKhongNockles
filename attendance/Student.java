package attendance;

public class Student implements Attendee{
	
	private String firstName;
	private String lastName;
	private boolean present;
	public Student{
		firstName = Samuel;
		lastName = Khong;
		present = false;
	}
	
	boolean isPresent() {
		return present;
	}
	void setPresent(boolean present) {
		this.present = present;
	}
	String getFirstName() {
		return firstName;
	}
	String getlastName() {
		return lastName;
	}
	boolean mathces(String first, String last) {
		return ((first.compareTo(firstName))==0 && (last.compareTo(lastName)==0);
	}
	boolean matches(String last){
		return (last.compareTo(lastName)==0);
	}
}
