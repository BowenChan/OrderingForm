package sharedClass;

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
	
}
