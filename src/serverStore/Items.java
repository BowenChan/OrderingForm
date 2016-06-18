package serverStore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Inventory")
public class Items {
	
	private int itemID;
	private String item;
	private int stock;
	
	@Id
	@GeneratedValue
	public int getItemID(){
		return itemID;
	}
	
	public void setItemID(int id){
		itemID = id;
	}
	
	public String getItem(){
		return item;
	}
	
	public void setItem(String itemName){
		item = itemName;
	}
	
	public int getItemAmount(){
		return stock;
	}
	
	public void setItemAmount(int amount){
		stock = amount;
	}
	
}
