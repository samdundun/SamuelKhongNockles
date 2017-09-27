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
	
	public boolean isPresent() {
		return present;
	}
	public void setPresent(boolean present) {
		this.present = present;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getlastName() {
		return lastName;
	}
	public boolean mathces(String first, String last) {
		return ((first.toLowerCase().equals(firstName)) && (last.toLowerCase().equals(lastName)));
	}
	public boolean matches(String last){
		return (last.compareTo(lastName)==0);
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
		output += "ABSENT";	
		return output;
	}
}
