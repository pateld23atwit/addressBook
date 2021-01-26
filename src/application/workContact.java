package application;

public class workContact extends contacts{
	private String jobTitle;
	private String company;
	
	public workContact(String type, String clientFirstName, String clientLastName, long clientNumber, String clientEmail, String address, String title, String firm) {
		super(type, clientFirstName, clientLastName, clientNumber, clientEmail, address);
		jobTitle = title;
		company = firm;
	}

	public String getJobTitle() {
		return jobTitle;
	}
	
	public String getCompanyName() {
		return company;
	}
	
	public void setJobTitle(String newPosition) {
		this.jobTitle = newPosition;
	}
	
	public void setCompanyName(String newFirmName) {
		this.company = newFirmName;
	}
	
	public String toString() {
		return ("Contact Type: " + getType() + "\nFirst Name: " + getFirstName() + "\nLast Name: " + getLastName() + "\nPhone Number: " + getNumber() + "\nEmail: " 
				+ getEmail() + "\nAddress: " + getAddress() + "\nJob Title: " + getJobTitle() + "\nCompany: " + getCompanyName() + "\n");
	}

}
