package miniprj;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class AdminManager implements Serializable, Manager{			
	
	private ArrayList<Admin> adminList = new ArrayList<Admin>();
	private Scanner scans = new Scanner(System.in);
	
	public AdminManager() { //constructor
		adminList.add(new Admin());	//creating a new admin object from Admin.java
		adminList.addAll(FileIO.readFile(Directory.DIR_USERS));
	}
	
	public boolean removeAdmin(String username) {
		for(int i =0; i<adminList.size(); i++) {
			if(adminList.get(i).getUsername().contentEquals(username)) {
				adminList.remove(i);
				return true;
			}
		}
		//user not found
		System.out.println("Username not found!!!");
		return false;
	}
	
	public boolean authenticate(String username, String password) {
		for (int i=0; i<adminList.size(); i++) {
			//System.out.println(adminList.get(i).getUsername());
			//System.out.println(adminList.get(i).getPassword());
			if (adminList.get(i).getUsername().compareTo(username) == 0 && 
					adminList.get(i).getPassword().compareTo(password) == 0) {
				return true;
			}
		}
		return false;
	}
	
	public void addAdmin(String username, String password) {
		adminList.add(new Admin(username, password));
		FileIO.saveToFile(adminList, Directory.DIR_USERS);
		reloadData();
	}
	
	public void updateAdmin() {	//use it to update password
		System.out.println("Enter administrator username to update: ");
		String username = scans.next(); 
		//now you will need to check for the admin username in the admin list.
		for(int i=0; i<adminList.size();i++) {
			if(adminList.get(i).getUsername().contentEquals(username)) {
				System.out.println("Please select which of the following to update: ");
				System.out.println("(1) Update Username");
				System.out.println("(2) Update Password");
				System.out.println("(3) Back");
				int userSelect = scans.nextInt();
					do {
					switch(userSelect) {
						case 1: 
							System.out.println("New Username: ");
							String newUser = scans.next();
							for(int x=0; x<adminList.size();x++) {
								if(adminList.get(x).getUsername().contentEquals(username)) {
									System.out.println("Administrator USERNAME exist!!!");
									return;
								}
							}
							adminList.get(i).setUsername(newUser);
							System.out.println("User sucessfully update!");
							return;
						case 2:
							System.out.println("New Password: ");
							String newPasswordA = scans.next();
							System.out.println("Re-enter Password: ");
							String newPasswordB = scans.next();
							if((newPasswordA.equals(newPasswordB))){
								adminList.get(i).setPassword(newPasswordA);
								System.out.println("Password updated!");
								return;
							}else {
								System.out.println("Password missmatch, please try again!");
							}
							break;
						case 3:
							return;
						default:
							break; 
					}
					}while(true);
			}else {
				//do nothing
			}
		}
		//if user is not found
		System.out.println("Username not found!");
	}
	public void adminSignup() {
		String passworda,passwordb = null;
		System.out.println("Please enter the new admin: ");
		String username = scans.nextLine(); 
		//check if the admin username exist
		for(int i=0; i<adminList.size();i++) {
			if(adminList.get(i).getUsername().contentEquals(username)) {
				System.out.println("Administrator USERNAME exist!!!");
				return;
			}
		}
		System.out.println("Please enter the password: ");
		passworda = scans.nextLine();
		System.out.println("Please re-nter the password: ");
		passwordb = scans.nextLine();
		if(passworda.equals(passwordb)) {
			addAdmin(username,passworda);
			System.out.println("Admin is added successfully!");
			System.out.println("Returning you back to the main menu...");
		}
		else{
			System.out.println("Password mismatch, please retry!");
			adminSignup();
		}
		return;
		
		/*if(addAdmin(newAdmin.username,newAdmin.password)) {
			System.out.println("Admin is added successfully!");
		}else {
			System.out.println("Admin is not added sucessfully! Press 1 to retry and 0 to exit retry!");
			if(scans.nextInt() == 1) {
				adminSignup();
			}else {
				System.out.println("Returning you back to the admin login...");
				loginPrint();
			}
			
		}*/
	}

	@Override
	public void reloadData() {
		adminList.clear();
		adminList.addAll(FileIO.readFile(Directory.DIR_USERS));
		
	}
	
}
