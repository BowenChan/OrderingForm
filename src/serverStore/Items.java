package serverStore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Stock")
public class Items {
	
	private int JasmineTea;
	
	@Id
	@GeneratedValue
	private int getJasmineTea(){
		return JasmineTea;
	}
	
	private void setJasmineTea(int stock){
		JasmineTea = stock;
	}
}
