package sharedClass;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Users")
public class Users {
	
	private int id;
	private String username;
	private String password;
	
	@Id
	public int getID(){
		return id;
	}
	
	public void setID(int id){
		this.id = id;
	}
	
	public String getUsername(){
		return username;
	}
	
	public void setUsername(String username){
		this.username = username;
	}
	
	public String getPassword(){
		return password;
	}
	
	public void setPassword(String password){
		this.password = password;
	}
}
