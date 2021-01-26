package application;
	
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;


public class Main extends Application implements EventHandler<ActionEvent>{
	private static ArrayList<contacts> list = new ArrayList<contacts>();
	static int tempIndex;
	Stage primaryStage;
	
	@FXML
	private TextField fName1 = null;
	@FXML
	private TextField lName1 = null; 
	@FXML
	private TextField phone1 = null; 
	@FXML
	private TextField email1 = null; 
	@FXML
	private TextField address1 = null; 
	
	@FXML
	private TextField editfName1 = null;
	@FXML
	private TextField editlName1 = null; 
	@FXML
	private TextField editPhone1; 
	@FXML
	private TextField editemail1 = null; 
	@FXML
	private TextField editaddress1 = null; 
	
	@FXML
	private TextField clientfName1 = null;
	@FXML
	private TextField clientlName1 = null; 
	@FXML
	private TextField clientPhone1 = null; 
	@FXML
	private TextField clientEmail1 = null; 
	@FXML
	private TextField clientAddress1 = null; 
	@FXML
	private TextField clientTitle1 = null; 
	@FXML
	private TextField clientCompany1 = null;	
	@FXML
	private TextField searchfName1 = null;
	@FXML
	private TextField removePhone1 = null;
	@FXML
	private TextField searchEditPhone1 = null;
	
	@FXML
	private TextField clientEditfName1 = null;
	@FXML
	private TextField clientEditlName1 = null; 
	@FXML
	private TextField clientEditPhone1 = null; 
	@FXML
	private TextField clientEditEmail1 = null; 
	@FXML
	private TextField clientEditAddress1 = null; 
	@FXML
	private TextField clientEditTitle1 = null; 
	@FXML
	private TextField clientEditCompany1 = null;
	
	@FXML
    private TextArea console;
	@FXML
    private TextArea searchResults;
//	@FXML
//    private TextArea removeResults;
	@FXML
	 private TextArea searchEditResults;
	@FXML
	 private TextArea editPersonalResults;
	@FXML
	 private TextArea editWorkResults;
	@FXML
	private Label status = new Label();
	@FXML
	private Label status2 = new Label();
	@FXML
	private Label status3 = new Label();

    public void printName(ActionEvent event) {
    	String printName = fName1.getText();
    	System.out.println(printName);
    }
    
    public void addContactWindow(ActionEvent event) {		//open add contact window
    	try {
    		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("addContact.fxml"));
        	Parent root1 = (Parent) fxmlLoader.load();
        	Stage stage = new Stage();
        	stage.setScene(new Scene(root1));  
        	stage.show();
    	}
    	catch (Exception e) {
    		System.out.println("Cannot load window");
    	}
    }
    
    public void handleCloseButtonAction(ActionEvent event) {		//quit
    	System.exit(0);
    }
	
	public void addPersonal(ActionEvent event) {		//add personal contact
		try {
			boolean copy = false;
			String fName = fName1.getText();
			String lName = lName1.getText();
			long phone = Long.parseLong(phone1.getText());
			String email = email1.getText();
			String address = address1.getText();
			
		    for (contacts c: list) {
				long tempNum = c.getNumber();
				
				if (tempNum == phone) {
					copy = true;
					System.out.println("Phone number already exists!");
					break;
				}
			}
		    
		    if (copy == false) {
			    contacts c = new contacts("Personal", fName, lName, phone, email, address);
			    list.add(c);
		    }
		    
		    System.out.println("Contact added successfully");
		    Stage stage = (Stage) fName1.getScene().getWindow();
		    stage.close();
		}
		catch (Exception e) {
			status.setTextFill(Color.RED);
			status.setText("Woops, something went wrong.");
		}   
	}
	
	public void addWork(ActionEvent event) {		//add work contact
		try {
			boolean copy = false;
			String clientfName = clientfName1.getText();
			String clientlName = clientlName1.getText();
			long clientPhone = Long.parseLong(clientPhone1.getText());
			String clientEmail = clientEmail1.getText();
			String clientAddress = clientAddress1.getText();
			String clientTitle = clientTitle1.getText();
			String clientCompany = clientCompany1.getText();
			
		    for (contacts c: list) {
				long tempNum = c.getNumber();
				
				if (tempNum == clientPhone) {
					copy = true;
					System.out.println("Phone number already exists!");
					break;
				}
			}
		    
		    if (copy == false) {
			    workContact c = new workContact("Work", clientfName, clientlName, clientPhone, clientEmail, clientAddress, clientTitle, clientCompany);
			    list.add(c);
		    }
		    
		    status.setText("Work Contact added successfully");
		    Stage stage = (Stage) clientfName1.getScene().getWindow();
		    stage.close();
		}
		catch (Exception e) {
			status.setTextFill(Color.RED);
			status.setText("Woops, something went wrong.");
		} 
	}
	
	public void viewAll(ActionEvent event) {		//view all contacts
		String s = "";
	    for (contacts c: list) {
	    	s += c.toString();
	    	s += "\n";
		}
	    console.setText(s);
	}  
	
	public void searchContactWindow(ActionEvent event) {		//open add contact window
    	try {
    		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("searchContacts.fxml"));
        	Parent root1 = (Parent) fxmlLoader.load();
        	Stage stage = new Stage();
        	stage.setScene(new Scene(root1));  
        	stage.show();
    	}
    	catch (Exception e) {
    		System.out.println("Cannot load window");
    	}
    }
	
	public void searchContact(ActionEvent event) {		//search contacts
		System.out.println("Search button works!");
		String fName = searchfName1.getText();
		String output = null;
		ArrayList<contacts> names = searchContact(fName);
		
		try {
			if (names != null) {
				output = "";
				for (contacts c: names) {
					output += c.toString();
					output += "\n";
				}
			}
			else {
				String str = "No contacts found!";
				searchResults.setText(str);
				System.out.println(str);
			}
			
			searchResults.setText(output);
		}
		catch (Exception e) {
			searchResults.setText(output);
			System.out.println("Whoops, something went wrong.");
		}
		
	}
	
	public void removeContactWindow(ActionEvent event) {			//remove contact window
		try {
    		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("removeContact.fxml"));
        	Parent root1 = (Parent) fxmlLoader.load();
        	Stage stage = new Stage();
        	stage.setScene(new Scene(root1));  
        	stage.show();
    	}
    	catch (Exception e) {
    		System.out.println("Cannot load window");
    	}
	}
	
	public void removeContact(ActionEvent event) {		//remove contact button
		System.out.println("Search button works!");
		
		try {
			long numToFind = 0;
			int index = -1;
			long tempNum;
			
			numToFind = Long.parseLong(removePhone1.getText());
			
			for (contacts c: list) {
				tempNum = c.getNumber();
				
				if (numToFind == tempNum) {
					index = list.indexOf(c);
				}
			}
			
			if (index == -1) {
				status2.setTextFill(Color.RED);
				status2.setText("Contact not found!");
//				removeResults.setText("Contact not found!");
				System.out.println("Contact not found!");
			}
			else {
				list.remove(index);
//				removeResults.setText("Contact deleted.");
				status2.setTextFill(Color.GREEN);
				status2.setText("Contact deleted.");
				System.out.println("Contact deleted.");
			}
		}
		catch (Exception e) {
//			removeResults.setText("Whoops, something went wrong.");
			status2.setTextFill(Color.RED);
			status2.setText("Woops, something went wrong.");
			System.out.println("Whoops, something went wrong.");
		}
	}
	
	public void editContactWindow(ActionEvent event) {		//open add contact window
    	try {
    		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("editContacts.fxml"));
        	Parent root1 = (Parent) fxmlLoader.load();
        	Stage stage = new Stage();
        	stage.setScene(new Scene(root1));  
        	stage.show();
    	}
    	catch (Exception e) {
    		System.out.println("Cannot load window");
    	}
    }
	
	public void findEditContact(ActionEvent event) {		//edit contact button
//		try {
			long numToFind = 0;
			long tempNum;
			int index = -1;
			
			numToFind = Long.parseLong(searchEditPhone1.getText());
			
			for (contacts c: list) {
				tempNum = c.getNumber();
				
				if (tempNum == numToFind) {
					index = list.indexOf(c);
					tempIndex = index;
					System.out.println("Temp index: " + tempIndex);
					
					if (c.getClass() == workContact.class) {
						((Node)(event.getSource())).getScene().getWindow().hide();
						editWorkContactWindow2();
					}
					else if (c.getClass() == contacts.class) {
						((Node)(event.getSource())).getScene().getWindow().hide();
						editPersonalContactWindow2();
					}
				}
			}
			if (index == -1) {
				status3.setTextFill(Color.RED);
				status3.setText("Contact not found!");
				searchEditResults.setText("Contact not found!");		//5355395293
				System.out.println("Contact not found!");
			}
//		}
//		catch (Exception e){
//			status3.setTextFill(Color.RED);
//			status3.setText("Woops, something went wrong.");
//			System.out.println("Whoops, something went wrong here.");
//		}
	}
	
	public void editPersonalContactWindow2() {		//open edit personal contact window
    	try {
    		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("editPersonallContact.fxml"));
        	Parent root1 = (Parent) fxmlLoader.load();
        	Stage stage = new Stage();
        	stage.setScene(new Scene(root1));  
        	stage.show();
    	}
    	catch (Exception e) {
    		System.out.println("Cannot load window");
    	}
    }
	
	public void editWorkContactWindow2() {		//open edit work contact window
    	try {
    		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("editWorkContact.fxml"));
        	Parent root1 = (Parent) fxmlLoader.load();
        	Stage stage = new Stage();
        	stage.setScene(new Scene(root1));  
        	stage.show();
    	}
    	catch (Exception e) {
    		System.out.println("Cannot load window");
    	}
    }
	
	public void setLabel() {
		String res = "";
		res = list.get(tempIndex).toString();
		editPersonalResults.setText(res);
	}
	public void findEditPersonalContact(ActionEvent event) {		//look for personal contact to edit
		
		if (editfName1.getText().isEmpty() && editlName1.getText().isEmpty() && editPhone1.getText().isEmpty() &&
				editemail1.getText().isEmpty() && editaddress1.getText().isEmpty()) {
			editPersonalResults.setText("Nothing to edit!");
			System.out.println("Nothing to edit!");
		}
		else {
			try {
				String fName = list.get(tempIndex).getFirstName();
				String lName = list.get(tempIndex).getLastName();
				long phone = list.get(tempIndex).getNumber();
				System.out.println("Inside Method: " + tempIndex);
				
				if (editfName1.getText().isEmpty() == false) {
					fName = editfName1.getText();		
				}
				if (editlName1.getText().isEmpty() == false) {
					lName = editlName1.getText();		
				}
				if (editPhone1.getText().isEmpty() == false) {
					phone = Long.parseLong(editPhone1.getText());		//5355395293
				}
				String email = editemail1.getText();
				String address = editaddress1.getText();
				
		    	if ((editfName1.getText().isEmpty() == false) || (editlName1.getText().isEmpty() == false)) {
		    		list.get(tempIndex).setName(fName, lName);
		    	}
		    	if ((editPhone1.getText().isEmpty() == false)) {
		    		list.get(tempIndex).setNum(phone);
		    	}
		    	if (editemail1.getText().isEmpty() == false) {
		    		list.get(tempIndex).setEmail(email);
		    	}
		    	if (editaddress1.getText().isEmpty() == false) {
		    		list.get(tempIndex).setAddress(address);
		    	}
		    	
		    	((Node)(event.getSource())).getScene().getWindow().hide();
		    	System.out.println("Contact edited successfully.");
			    
			}
			catch (Exception e) {
				editPersonalResults.setText("Whoops, something went wrong.");
				System.out.println("Whoops, something went wrong.");
			}
		}
	}
	
	public void setLabel2() {
		String res = "";
		res = list.get(tempIndex).toString();
		editWorkResults.setText(res);
	}
	
	public void findEditBussinessContact(ActionEvent event) {		//look for bussiness contact to edit
		if (clientEditfName1.getText().isEmpty() && clientEditlName1.getText().isEmpty() && clientEditPhone1.getText().isEmpty() &&
				clientEditEmail1.getText().isEmpty() && clientEditAddress1.getText().isEmpty() && clientEditTitle1.getText().isEmpty() &&
					clientEditCompany1.getText().isEmpty()) {
			editWorkResults.setText("Nothing to edit!");
			System.out.println("Nothing to edit!");
		}
		else {
			try {
				long phone = list.get(tempIndex).getNumber();		//4958673651
				System.out.println("Inside Method: " + tempIndex);
				String fName = list.get(tempIndex).getFirstName();
				String lName = list.get(tempIndex).getLastName();
				
				if (clientEditfName1.getText().isEmpty() == false) {
					fName = clientEditfName1.getText();
				}
				if (clientEditlName1.getText().isEmpty() == false) {
					lName = clientEditlName1.getText();
				}
				if (clientEditPhone1.getText().isEmpty() == false) {
					phone = Long.parseLong(clientEditPhone1.getText());
				}
				
				String email = clientEditEmail1.getText();
				String address = clientEditAddress1.getText();
				String title = clientEditTitle1.getText();
				String company = clientEditCompany1.getText();
			    
		    	if ((clientEditfName1.getText().isEmpty() == false) || (clientEditlName1.getText().isEmpty() == false)) {
		    		list.get(tempIndex).setName(fName, lName);
		    	}
		    	if ((clientEditPhone1.getText().isEmpty() == false)) {
		    		list.get(tempIndex).setNum(phone);
		    	}
		    	if (clientEditEmail1.getText().isEmpty() == false) {
		    		list.get(tempIndex).setEmail(email);
		    	}
		    	if (clientEditAddress1.getText().isEmpty() == false) {
		    		list.get(tempIndex).setAddress(address);
		    	}
		    	if (clientEditTitle1.getText().isEmpty() == false) {
		    		list.get(tempIndex).setAddress(title);
		    	}
		    	if (clientEditCompany1.getText().isEmpty() == false) {
		    		list.get(tempIndex).setAddress(company);
		    	}
		    	((Node)(event.getSource())).getScene().getWindow().hide();
		    	System.out.println("Work contact edited successfully.");
			    
			}
			catch (Exception e) {
				editWorkResults.setText("Whoops, something went wrong.");
				System.out.println("Whoops, something went wrong.");
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/application/myFXML.fxml"));
			Parent root1 = FXMLLoader.load(getClass().getResource("/application/addContact.fxml"));
			
			Scene scene = new Scene(root, 551, 720);
			Scene addContact = new Scene(root1, 716, 720);
			
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			addContact.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			primaryStage.setScene(scene);
			primaryStage.setTitle("Address Book");
			primaryStage.show();
			primaryStage.setResizable(false);
		} catch(Exception e) {
			e.printStackTrace();
		}
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
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		int instruction = 0;
		String con = "y";
		
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
		
		launch(args);
		
		System.exit(0);
		
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
//						addContact(newContact);
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
//						addContact(newContact);
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








	@Override
	public void handle(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
