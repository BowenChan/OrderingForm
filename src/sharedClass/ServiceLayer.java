package sharedClass;

import java.util.List;

import clientStore.Address;
import clientStore.QueueClient;
import serverStore.Admin;

public class ServiceLayer {
	
	ConcreteStoreDAO storeDAO;
	
	/**
	 * Constructor ServiceLayer
	 * 
	 * Initialize all instance variable and checks if the admin exist
	 * 
	 */
	public ServiceLayer() {
		// TODO Auto-generated constructor stub
		storeDAO = new ConcreteStoreDAO();
		if(!checkAdmin()){
			User user = new User();
			user.setUsername("admin");
			user.setPassword("admin");
			storeDAO.create(user);
		}
		
	}
	
	
	public boolean checkAdmin(){
		return storeDAO.checkAdmin();
	}

	public String createUser(String company, String username, String password, Address address) {
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
	
	public List<QueueClient> viewAllQueueClient(){
		List<QueueClient> clients = storeDAO.findAllQueueClients();
		return clients;
	}
}
