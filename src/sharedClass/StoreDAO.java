package sharedClass;

import java.util.List;

import clientStore.Client;
import clientStore.QueueClient;
import serverStore.Admin;

public interface StoreDAO {
	
	//Invoice DAO Functions
	Invoice create(Invoice invoice);
	boolean update(Invoice invoice);
	boolean delete(Invoice invoice);
	
	//Client DAO Functions
	Client create(Client client);
	boolean update(Client client);
	boolean delete(Client client);
	Client findUser(String username, String password);
	
	//Server DAO Functions
	Admin create(User user);
	List<Invoice> findByClient(Client client);
	List<Invoice> findAllInvoice(); 
	List<Client> findAllClient();
	List<QueueClient> findAllQueueClients();
	Client searchClientByID(String keyword);
	
	boolean checkAdmin();
	

}
