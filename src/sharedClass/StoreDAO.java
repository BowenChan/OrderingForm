package sharedClass;

import java.util.List;
import java.util.Queue;

import clientStore.Client;
import clientStore.QueueClient;
import serverStore.Admin;

public interface StoreDAO {
	
	//Invoice DAO Functions
	boolean create(Invoice invoice);
	boolean update(Invoice invoice);
	boolean delete(Invoice invoice);
	
	//Client DAO Functions
	boolean create(Client client);
	boolean createQ(QueueClient client);
	boolean update(Client client);
	boolean delete(Client client);
	User findUser(String username, String password);
	
	//Server DAO Functions
	boolean createA(User user);
	boolean create(User user);
	boolean delete(QueueClient client);
	List<Invoice> findByClient(Client client);
	List<Invoice> findAllInvoice(); 
	List<Client> findAllClient();
	List<QueueClient> findAllQueueClients();
	Client searchClientByID(String keyword);
	
	boolean checkAdmin();
	boolean createInventory(String item, int amount);
	boolean updateInventory(String item, int amount);
	boolean deleteItem(String item);
	

}
