package sharedClass;

import java.util.List;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

import clientStore.Address;
import clientStore.Client;
import clientStore.QueueClient;
import serverStore.Admin;
import serverStore.Items;

public class ServiceLayer {
	
	User currentLogin;
	ConcreteStoreDAO storeDAO;
	
	/**
	 * Constructor ServiceLayer
	 * 
	 * Initialize all instance variable and checks if the admin exist
	 * 
	 */
	public ServiceLayer(XMLParser parse) {
		// TODO Auto-generated constructor stub
		storeDAO = new ConcreteStoreDAO();
		if(!checkAdmin()){
			User user = new User();
			user.setUsername("admin");
			user.setPassword("admin");
			storeDAO.createA(user);
		}
		
		
		//load up the database
		if(!checkInventory()){
			for(int i = 0; i < parse.getNodeList().getLength(); i++){
				Node node = parse.getNodeList().item(i);
				if(node.getNodeType() == Node.ELEMENT_NODE){
					Element element = (Element) node;
					Items item = new Items();
					item.setItem(element.getAttribute("name"));
					item.setItemAmount(Integer.parseInt(element.getElementsByTagName("Amount").item(0).getTextContent()));
					storeDAO.createInventory(item);
				}
			}
		}
		
		
	}
	
	public boolean checkInventory(){
		return storeDAO.checkInventory();
	}
	
	public void retrieveInventory(){
		for(Items inventoryItem: storeDAO.findAllInventoryItem()){
			System.out.println(inventoryItem.getItem() + ": " + inventoryItem.getItemAmount());
		}
	}
	public boolean checkAdmin(){
		return storeDAO.checkAdmin();
	}

	public String createQUser(String company, String username, String password, Address address) {
		// TODO Auto-generated method stub
		QueueClient user = new QueueClient();
		user.setCompany(company);
		user.setUsername(username);
		user.setPassword(password);
		user.setAddress(address);
		//storeDAO.createQ(user);
		if(storeDAO.createQ(user))
			return "Thank you for registering, Please wait for admin to approve your company";
		else
			return "We were unable to register you";
	}
	
	public boolean createUser(QueueClient client){
		Client newClient = new Client();
		User newUser = new User();
		newClient.setAddress(client.getAddress());
		newClient.setUsername(client.getUsername());
		newClient.setPassword(client.getPassword());
		newClient.setKeyword(client.getCompany());
		if(storeDAO.create(newClient))
		{
			newUser.setUsername(client.getUsername());
			newUser.setPassword(client.getPassword());
			storeDAO.create(newUser);
			storeDAO.delete(client);
			
		}	
		return true;
	}
	
	public List<QueueClient> viewAllQueueClient(){
		List<QueueClient> clients = storeDAO.findAllQueueClients();
		return clients;
	}
	
	public boolean login(String username, String password){
		User user = storeDAO.findUser(username, password);
		if(user != null)
			return true;
		return false;
	}
	
	public boolean createItem(String itemName, int amount){
		return true;
	}
	public boolean updateItem(String itemName, int amount){
		Items item = new Items();
		item.setItem(itemName);
		item.setItemAmount(amount);
		return storeDAO.updateInventory(item);
	}
	
}
