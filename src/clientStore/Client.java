package clientStore;

import javax.persistence.Entity;
import javax.persistence.Table;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Client")
public class Client {
	private String keywordID;
	private int customerID;
	private String username;
	private String password;
	private Address address;
	private java.util.Calendar registrationDate;
	
	@Id
	@GeneratedValue
	public int getID(){
		return customerID;
	}
	
	public void setID(int id){
		this.customerID = id;
	}
	
	@Column(unique = true)
	public String getKeyword(){
		return keywordID;
	}
	
	public void setKeyword(String keyword){
		this.keywordID = keyword;
	}
	
	@Column(unique = true)
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
	
	public Address getAddress(){
		return address;
	}
	
	public void setAddress(Address address){
		this.address = address;
	}
	
	@Temporal(TemporalType.DATE)
	public java.util.Calendar getRegistrationDate() {
		return registrationDate;
	}
   
	public void setRegistrationDate(java.util.Calendar registrationDate) {
		this.registrationDate = registrationDate;
	}
	   
	@Override
	public String toString(){
		return "ID: " + getID() + " Company: " + getKeyword() + " Address: " +getAddress();
	}
}