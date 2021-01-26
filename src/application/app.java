package application;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;

public class app extends Application {
	private String myFirstName;
	private String myLastName;
	private int myNumber;
	private static ArrayList<contacts> list = new ArrayList<contacts>();
	
	public app(String fName, String lName, int number) {
		myFirstName = fName;
		myLastName = lName;
		myNumber = number;
	}
	
//	public void printList() {
//		if (contactList.isEmpty()) {
//			System.out.println("You have zero saved contacts.");
//		}
//		else {
//			for (contact ch: contactList) {
//				ch.toString();
//			}
//			
//		}
//	}
	
	public static String addContact(contacts contact) {
		String str = "Contact added successfully.";
		list.add(contact);
		return str;
	}
	
	public static ArrayList searchContact(String fNameToFind) {		//search via first name
		ArrayList<contacts> names = new ArrayList<contacts>();
		
		for (contacts contact: list) {
			String name = contact.getFirstName();
			
			if (name.equalsIgnoreCase(fNameToFind)) {
				names.add(contact);
			}
		}
		if (names.isEmpty()) {
			return null;
		}
		
		return names;
	}
	
	public static contacts searchContact(long numberToFind) {		//search via phone number
		String str = "Contact not found";
		
		for (contacts contact: list) {
			long num = contact.getNumber();
			
			if (num == numberToFind) {
				System.out.println("\nContact Found: ");
				return contact;
			}
		}
		return null;
	}
	
	
	
	
	
	
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/application/Sample.fxml"));
			Scene scene = new Scene(root,600,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("hello");
			primaryStage.show();
			primaryStage.setResizable(false);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
		
		
		
		
		
		
		
		
		
		Scanner input = new Scanner(System.in);
		int instruction = 0;
		String con = "y";
//		class testPersonal = contacts;
//		
		
		
		contacts c1 = new contacts("Personal", "dax", "patel", 5355395293L);
		contacts c2 = new contacts("Personal", "will", "myers", 4758392745L);
		contacts c3 = new contacts("Personal", "joe", "ablins", 9705734859L);
		contacts c4 = new contacts("Personal", "james", "smith", 3069374845L);
		contacts c5 = new contacts("Personal", "james", "kali", 8697048576L);
		contacts c6 = new contacts("Personal", "james", "mills", 1048574634L);
		
		workContact c7 = new workContact("Bussiness", "Katy", "Castillo", 8573640693L, "katy@aim.com", "address", "Manager", "LawTap");
		workContact c8 = new workContact("Bussiness", "Michael", "Mitchell", 9582827564L, "michael@aim.com", "address", "Team Leader", "bioLabs");
		workContact c9 = new workContact("Bussiness", "Tina", "Lexis", 4958673651L, "katheryn@aim.com", "address", "Director", "GTP");
		workContact c10 = new workContact("Bussiness", "Matt", "McDonald", 9603726472L, "matt@aim.com", "address", "Coordinator", "Motion Man");
		workContact c11 = new workContact("Bussiness", "Tina", "Mork", 1069583756L, "tina@aim.com", "address", "Controller", "Onecrete");
		workContact c12 = new workContact("Bussiness", "Sam", "Sulli", 1059384758L, "sam@aim.com", "address", "Administrator", "ProMed");
		
		list.add(c1);
		list.add(c2);
		list.add(c3);
		list.add(c4);
		list.add(c5);
		list.add(c6);
		list.add(c7);
		list.add(c8);
		list.add(c9);
		list.add(c10);
		list.add(c11);
		list.add(c12);
		
		while (con.equals("y")) {
			
			System.out.println("Enter the corresponding number: ");
			System.out.println("1) Add contact");
			System.out.println("2) Search contact");
			System.out.println("3) Remove contact");
			System.out.println("4) Edit contact");
			System.out.println("5) View all contacts");
			System.out.println("6) Quit");
			System.out.print("Selection: ");
			
			int function = 0;
			
			try {
				function = input.nextInt();
				System.out.println();
			
			
				if (function == 1) {		//add contact
					long tempNum;
					String email = "";
					String address = "";
					
					System.out.println("Which type of contact would you like to add: ");
					System.out.println("1) Personal Contact ");
					System.out.println("2) Work Contact ");
					System.out.print("Selection: ");
					
					instruction = input.nextInt();
					System.out.println();
					
					if (instruction == 1) {
						System.out.print("First Name: ");
						String fName = input.next();
						System.out.print("Last Name: ");
						String lName = input.next();
						System.out.print("Phone Number: ");
						tempNum = input.nextLong();
						System.out.println("Email (not required): ");
						input.nextLine();
						email = input.nextLine();
						System.out.println("Address (not required): ");
						address = input.nextLine();
						for (contacts c: list) {
							long tempNum2 = c.getNumber();
							
							if (tempNum == tempNum2) {
								System.out.println("Phone number already exists!");
								break;
							}
						}
						contacts newContact = new contacts("Personal", fName, lName, tempNum, email, address);
						addContact(newContact);
					}
					
					else if (instruction == 2) {
						
						System.out.print("First Name: ");
						String fName = input.next();
						System.out.print("Last Name: ");
						String lName = input.next();
						System.out.print("Phone Number: ");
						tempNum = input.nextLong();
						input.nextLine();
						System.out.print("Email Address: ");
						String tempEmail = input.next();
						input.nextLine();
						System.out.print("Firm Address: ");
						String tempAddress = input.nextLine();
						System.out.print("Client Title: ");
						String tempTitle = input.next();
						System.out.print("Client Company: ");
						String tempFirm = input.nextLine();
						
						workContact newContact = new workContact("Bussiness", fName, lName, tempNum, 
								tempEmail, tempAddress, tempTitle, tempFirm);
						addContact(newContact);
					}
				}
				else if (function == 2) {		//search contact
					System.out.println();
					System.out.println("Enter the corresponding number: ");
					System.out.println("1) Search by first name: ");
					System.out.println("2) Search by phone number: ");
					System.out.print("Selection: ");
					
					try {
						instruction = input.nextInt();
						System.out.println();
					}
					catch (InputMismatchException exit) {
						System.out.println("Input must only contain an integer.");
						System.out.println();
						break;
					}
					catch (java.lang.NullPointerException exit) {
						System.out.println("Input must only contain an integer.");
						System.out.println();
						break;
					}
					
					if (instruction == 1) {
						System.out.print("Enter first name to search: ");
						
						try {
							String name = input.next();
							ArrayList<contacts> names = searchContact(name);
							
							for (contacts cont: names) {
								System.out.println(cont.toString());
							}
						}
						catch (InputMismatchException exit) {
							System.out.println("Input must only contain letters.");
							System.out.println();
						}
						catch (java.lang.NullPointerException exit) {
							System.out.println("Contact not found.");
							System.out.println();
						}
					}
					else if (instruction == 2) {
						System.out.print("Enter phone number to search: ");
						
						
						try {
							System.out.println(searchContact(input.nextLong()).toString());
						}
						catch (InputMismatchException e) {
							System.out.println("Input must only contain integers.");
							System.out.println();
						}
					}
					
				}
				else if (function == 3) {		//remove contact
					try {
						long numToFind = 0;
						int index = -1;
						long tempNum;
						
						System.out.print("Enter the phone number to delete: ");
						numToFind = input.nextLong();
						System.out.println();
					
						for (contacts c: list) {
							tempNum = c.getNumber();
							
							if (numToFind == tempNum) {
								index = list.indexOf(c);
							}
						}
						
						if (index == -1) {
							System.out.println("Contact not found!");
						}
						else {
							list.remove(index);
							System.out.println("Contact deleted.");
						}
					}
					
					catch (InputMismatchException exit) {
						System.out.println("Input must only contain integers.");
						System.out.println();
					}
					catch (java.lang.NullPointerException exit) {
						System.out.println("Input must only contain integers.");
						System.out.println();
					}
				}
				else if (function == 4) {		//edit contact
					System.out.print("Enter the phone number of the contact to edit: ");
					int numToFind = input.nextInt();
					System.out.println();
					long tempNum;
					int index = -1;
					String loop = "y";
					
					for (contacts c: list) {
						tempNum = c.getNumber();
						
						
						if (tempNum == numToFind) {
							while (loop.equals("y")) {
								
								if (c.getClass() == workContact.class) {
									
								}
								
								
								
								System.out.println();
								System.out.println("Enter the corresponding number: ");
								System.out.println("1) Edit first name");
								System.out.println("2) Edit last name");
								System.out.println("3) Edit phone number");
								System.out.println("4) Edit email address");
								System.out.println("5) Edit address");
								System.out.print("Selection: ");
								
								index = list.indexOf(c);
								instruction = input.nextInt();
								System.out.println();
								
								switch (instruction) {
								case 1:
									System.out.print("Enter new first name: ");
									String fName = input.next();
									System.out.print("Enter new last name: ");
									String lName = input.next();
									
									c.setName(fName, lName);
									break;
		
								case 2:
									System.out.print("Enter new phone number: ");
									c.setNum(input.nextInt());
									break;
								
								case 3:
									System.out.print("Enter new email address: ");
									c.setEmail(input.next());
									break;
									
								case 4:
									System.out.print("Enter new address: ");
									c.setAddress(input.next());
								}
								
								System.out.print("Would you like to continue editing this contact? (y/n): ");
								loop = input.next();
							}
							break;
						}
					}
					if (index == -1) {
						System.out.println("Contact not found!");
					}
				}
				else if (function == 5) {		//print list
					for (contacts c: list) {
						System.out.println(c.toString());
					}
				}
				else if (function == 6) {
					System.out.println("\nShutting Down....");
					System.exit(0);
					
				}
			
			System.out.println("\nWould you like to continue? (y/n)");
			con = input.next();
			System.out.println();
				
		//		System.out.println(c1);
		//		System.out.println(c2);
		//		System.out.println(c3);
		//		System.out.println(c4);
			}
			catch (InputMismatchException exit) {
				System.out.println("Input must only contain an integer.");
				System.out.println();
				System.exit(0);
			}
			catch (java.lang.NullPointerException exit) {
				System.out.println("Input must only contain an integer.");
				System.out.println();
				System.exit(0);
			}
		}
	}

}
