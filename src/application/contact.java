package application;

public class contact {
	public String firstName;
	public String lastName;
	public String number;
	public String email;
	public String address;
	
	public contact(String fName, String lName, String num, String email, String address) {
		firstName = fName;
		lastName = lName;
		number = num;
		this.email = email;
		this.address = address;
	}
	
	public contact(String fName, String lName, String num) {
		this(fName, lName, num, "", "");
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getNumber() {
		return number;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getAddress() {
		return address;
	}
	
	public String toString() {
		return ("First Name: " + getFirstName() + "\nLast Name: " + getLastName() + "\nPhone Number: " + getNumber() + "\nEmail: " 
				+ getEmail() + "\nAddress: " + getAddress());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
