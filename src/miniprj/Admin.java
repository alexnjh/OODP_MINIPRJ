package miniprj;

import java.io.Serializable;

public class Admin implements Serializable{
	private String username;
	private String password;
	
	public Admin() { //the constructor / default username and password
		username = "root";
		password = "password";
	}
	
	public Admin(String username, String password) {	//constructor	
		this.username = username;			
		this.password = password;
	}
	
	public String getUsername() { //method 			
		return username;
	}
	
	public String getPassword() { //method
		return password;
	}
	
	public void setUsername(String user) {
		this.username = user;
	}
	public void setPassword(String pass) {
		this.password = pass;
	}
}