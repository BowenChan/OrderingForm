package sharedClass;

import java.util.GregorianCalendar;
import java.util.List;import java.util.Queue;

import org.hibernate.*;

import clientStore.Client;
import clientStore.QueueClient;
import serverStore.Admin;

public class ConcreteStoreDAO implements StoreDAO {

	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	
	@Override
	public Invoice create(Invoice invoice) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(Invoice invoice) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Invoice invoice) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Client client) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Client client) {
		// TODO Auto-generated method stub
		return false;
	}

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

	@Override
	public List<Invoice> findByClient(Client client) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Admin create(User user) {
		// TODO Auto-generated method stub
		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			Admin admin = new Admin();
			
			session.save(user);
			admin.setUsername(user.getUsername());
			admin.setUserID(user.getID());
			session.save(admin);
			session.getTransaction().commit();
			session.close();
			return admin;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public List<Invoice> findAllInvoice() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Client> findAllClient() {
		// TODO Auto-generated method stub
		return null;
	}
	
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

	@Override
	public Client searchClientByID(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	
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

	@Override
	public Client create(QueueClient client) {
		// TODO Auto-generated method stub
		return null;
	}

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

	


}
 		