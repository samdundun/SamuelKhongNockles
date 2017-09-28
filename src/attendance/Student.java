package attendance;

public class Student implements Attendee{
	
	private String firstName;
	private String lastName;
	private boolean isHere;
	public Student(String first, String last){
		firstName = first;
		lastName = last;
		isHere = false;
	}
	
	public boolean isPresent() {
		return isHere;
	}
	public void setPresent(boolean present) {
		this.isHere = isHere;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public boolean mathces(String first, String last) {
		return ((first.toLowerCase().equals(firstName.toLowerCase())) && (last.toLowerCase().equals(lastName.toLowerCase())));
	}
	public boolean matches(String last){
		return (last.toLowerCase().equals(lastName.toLowerCase()));
	}
	public String getReportString() {
		String output = lastName;
		if(lastName.length() > 20) {
			String cutOffLastName = lastName.substring(0,17) + "...";
			output = cutOffLastName;
		}
		while(output.length() < 20) {
			output += " ";
		}
		if(firstName.length() > 20) {
			String cutOffFirstName = firstName.substring(0,17) + "...";
			output += cutOffFirstName;
		}else {
			output += firstName;
		}
		while(output.length() < 40) {
			output += " ";
		}
			if(isHere) {
				output += "PRESENT";
				return output;
			}
		output += "ABSENT \n";	
		return output;
	}
}
