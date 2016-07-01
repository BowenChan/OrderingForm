package sharedClass;

import java.util.GregorianCalendar;
import java.util.List;import java.util.Queue;

import javax.swing.JApplet;

import org.hibernate.*;

import clientStore.Client;
import clientStore.QueueClient;
import serverStore.Admin;
import serverStore.Items;

public class ConcreteStoreDAO implements StoreDAO {

	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	
	/**
	 * Creates an order invoice and inserts the invoice into the database
	 * the invoice will contain the orderID, as well as 
	 * the store key. It will also have a record of all the 
	 * items
	 * 
	 * This method will always return true unless the invoice
	 * is unable to process into the database
	 * 
	 * @param invoice 	the copy of the invoice with all the information
	 * @return			the order is fully processed
	 */
	@Override
	public boolean create(Invoice invoice) {
		// TODO Auto-generated method stub
		return true;
	}

	/**
	 * Takes an existing order and modifies the object type Invoice
	 * 
	 * The invoice will always exist when passed.
	 * 
	 * @param invoice	 the invoice that is needed to be modified
	 * @return 			 The invoice is fully modified
	 */
	@Override
	public boolean update(Invoice invoice) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Takes an existing invoice and removes it from the database
	 * 
	 * the invoice will always exist in the database
	 * 
	 * @param invoice	the invoice to be deleted
	 * @return			whether or not the invoice has been deleted
	 */
	@Override
	public boolean delete(Invoice invoice) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Takes an existing Client and updates their mailing address
	 * 
	 * @param client 	the client that would like to be modified
	 * @return 			Whether or not the modifications were successful
	 */
	@Override
	public boolean update(Client client) {
		// TODO Auto-generated method stub
		return false;
	}
	
	/**
	 * Takes an existing client and deletes any traces and orders from the client
	 * 
	 * @param client	The client that will be deleted from the database
	 * @return			Returns whether or not the client was deleted
	 */
	@Override
	public boolean delete(Client client) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Checks if the user exist in the user database to login
	 * 
	 * Checks if the user is located with the given username and the specificed password
	 * 
	 * @param username	the username of the user
	 * @param password	the password of the user
	 * @return			returns if the user is found
	 */
	@Override
	public User findUser(String username, String password) {
		// TODO Auto-generated method stub
		try{
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			String queryString = "from User where username = :username AND password = :password";
			Query query = session.createQuery(queryString);
			query.setString("username", username);
			query.setString("password",password);
			Object queryResult = query.uniqueResult();
			User user =(User) queryResult;
			session.getTransaction().commit();
			return user;
		}
		catch (Exception e)
		{
			System.out.println("Unable to login");
			return null;
		}
	}

	/**
	 * This will determine all the orders within the users history
	 * 
	 * the client will exist in the database; however, the list of invoice may 
	 * not be gauranteed if the client has never made an order
	 * 
	 * @param client	the current client that is viewing the order
	 * @return			returns the list of orders that the client has made
	 */
	@Override
	public List<Invoice> findByClient(Client client) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * This will create an admin account within the system
	 * 
	 * @param user	the User you would like to make an admin
	 * @return
	 */
	@Override
	public boolean createA(User user){
		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			session.save(user);
			Admin admin = new Admin();
			admin.setUsername(user.getUsername());
			admin.setUserID(user.getID());
			session.save(admin);
			session.getTransaction().commit();
			session.close();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
	/**
	 * A user will be created and persisted into the database
	 * 
	 * @param user	The user that will be added into the database
	 * @return		Whether or not the user was persisted correctly
	 */
	@Override
	public boolean create(User user) {
		// TODO Auto-generated method stub
		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			session.save(user);
			session.getTransaction().commit();
			session.close();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}

	}
	

	/**
	 * This will output all orders that have been made since the start
	 * 
	 *
	 * @return			returns the list of orders 
	 */
	@Override
	public List<Invoice> findAllInvoice() {
		// TODO Auto-generated method stub
		return null;
	}


	/**
	 * This will output all Clients that have been made since the start
	 * 
	 *
	 * @return			returns the list of clients 
	 */
	@Override
	public List<Client> findAllClient() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * This will output all clients that have not been approved by the distributor
	 * 
	 *
	 * @return			returns the list of Queue Clients 
	 */
	@Override
	public List findAllQueueClients() {
		// TODO Auto-generated method stub
		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			String queryString = "from QueueClient";
			Query queryResult = session.createQuery(queryString);
			List<QueueClient> clients = queryResult.list();
			session.getTransaction().commit();
			session.close();
			return clients;
		}
		catch(Exception e){
			return null;
		}
	}
	
	/**
	 * This will output the information about a specific company based on the 
	 * Company specified ID
	 * 
	 * @param keyword	This is the keyword of the company
	 * @return			the clients information
	 */
	@Override
	public Client searchClientByID(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * THis will check if there are any admin within the 
	 * admin database
	 * 
	 * @return			whether or not if there are admins
	 */
	@Override
	public boolean checkAdmin() {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			String query = "From Admin";
			Query queryResult = session.createQuery(query);
			//System.out.println(queryResult.list());
			session.close();
			return (queryResult.getFetchSize() != null);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error is " + e);
		}
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * A client will be created and persisted into the database
	 * 
	 * @param client	The client that will be added into the database
	 * @return			Whether or not the client was persisted correctly
	 */
	@Override
	public boolean create(Client client) {
		// TODO Auto-generated method stub
		client.setRegistrationDate(new GregorianCalendar());
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(client);
		session.getTransaction().commit();
		session.close();
		return true;
	}
	
	/**
	 * A queue client will be created and persisted into the database
	 * 
	 * After the client is added into the database then it will be removed from the queue database
	 * 
	 * @param client	The queue client that will be added into the database
	 * @return			Whether or not the queue client was persisted correctly
	 */
	@Override
	public boolean createQ(QueueClient client) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			client.setRegistrationDate(new GregorianCalendar());
			session.save(client);
			session.getTransaction().commit();
			session.close();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("The error is : " + e);
		}
		return false;
	}

	/**
	 * The client will be deleted from the Queue Client database
	 * when inserted into the client database
	 * 
	 * @param client	Takes in the client that will be deleted
	 * @return			Whether the client has been sucecssfully deleted
	 */
	@Override
	public boolean delete(QueueClient client) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.delete(client);
		session.getTransaction().commit();
		session.close();
		return true;
	}

	/**
	 * Persist the data of an inventory item and the amount
	 * into the Items database
	 * 
	 * @param item		The item that will be added into the database
	 * @param amount	The number in stock of the given item
	 * @return			Whether the item fully persisted
	 */
	@Override
	public boolean createInventory(Items item){
		Session session = sessionFactory.openSession();
		try{
			session.beginTransaction();
			session.save(item);
			session.getTransaction().commit();
			session.close();
			return true;
		}catch(Exception e){
			return false;
		}
	}
	
	/**
	 * Update the data of an inventory item and the amount
	 * into the Items database
	 * 
	 * @param item		The item that will be updated into the database
	 * @param amount	The number in stock of the given item
	 * @return			Whether the item fully persisted
	 */
	@Override
	public boolean updateInventory(Items item){
		return true;
	}

	/**
	 * Delete the given item from the database
	 * 
	 * @return			Whether the item fully deleted
	 */
	@Override
	public boolean deleteItem(Items item){
		return false;
	}
}
 		