package application;
import java.util.ArrayList;
import java.util.Collections;

public class contacts {
	private String type;
	private String firstName;
	private String lastName;
	private long number;
	private String email;
	private String address;
	private static ArrayList<String> contactList = new ArrayList<String>();
	
	public contacts(String type, String fName, String lName, long num, String email, String address) {
		this.type = type;
		firstName = fName;
		lastName = lName;
		number = num;
		this.email = email;
		this.address = address;
	}
	
	public contacts(String type, String fName, String lName, long num, String email) {
		this(type, fName, lName, num, email, "");
	}
	
	public contacts(String type, String fName, String lName, long num) {
		this(type, fName, lName, num, "", "");
	}
	
	public String getType() {
		return type;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public long getNumber() {
		return number;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void saveContact(String name) {
		contactList.add(name);
	}
	
	public void setName(String fName, String lName) {
		this.firstName = fName;
		this.lastName = lName;
	}
	
	public void setNum(long num) {
		this.number = num;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String toString() {
		return ("Contact Type: " + getType() + "\nFirst Name: " + getFirstName() + "\nLast Name: " + getLastName() + "\nPhone Number: " + getNumber() + "\nEmail: " 
				+ getEmail() + "\nAddress: " + getAddress() + "\n");
	}
	
	public static void alphabatize() {
		Collections.sort(contactList);
	}
	
	public static void printContactList() {
		alphabatize();
		
		int x = 1;
		System.out.println("Total Contacts: " + contactList.size());
		
		for (String name: contactList) {
			System.out.println(x + ") " + name);
			x++;
		}
	}
}
