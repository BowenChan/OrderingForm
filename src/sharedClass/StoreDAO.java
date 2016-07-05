package sharedClass;

import java.util.List;
import java.util.Queue;

import clientStore.Client;
import clientStore.QueueClient;
import serverStore.Admin;
import serverStore.Items;

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
	boolean update(User user);
	boolean delete(QueueClient client);
	List<Invoice> findByClient(Client client);
	List<Invoice> findAllInvoice(); 
	List<Client> findAllClient();
	List<QueueClient> findAllQueueClients();
	Client searchClientByID(String keyword);
	
	boolean checkAdmin();
	Items findInventory(Items item);
	List<Items> findAllInventoryItem(); 
	boolean createInventory(Items item);
	boolean updateInventory(Items item);
	boolean deleteItem(Items item);
	boolean checkInventory();

}
