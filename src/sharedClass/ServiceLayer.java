package sharedClass;

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
		
	}
	
	private boolean checkAdmin(){
		
		return false;
	}
	
}
