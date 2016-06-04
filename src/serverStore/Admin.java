package serverStore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Admin")
public class Admin {
	
	//Setting up Admins' Attribute
	private int adminID;
	private int userID;
	private String username;
	
	@Id
	@GeneratedValue
	public int getID(){
		return adminID;
	}
	
	public void setID(int id){
		this.adminID = id;
	}
	
	public int getUserID(){
		return userID;
	}
	
	public void setUserID(int id){
		userID = id;
	}
	@Column(unique = true)
	public String getUsername(){
		return username;
	}
	
	public void setUsername(String username){
		this.username = username;
	}
	
}
