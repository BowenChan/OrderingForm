package sharedClass;

import java.util.Scanner;

import clientStore.Address;
import serverStore.Admin;

public class Main {
	
	private static ServiceLayer sLayer;
	private static boolean login;
	private static boolean admin;
	
	public static void main(String[] args){
		sLayer = new ServiceLayer();
		admin = false;
		login = false;
		while(optionMenu(login, admin)); // always run the the option until they exit
	}

	/**
	 * Method optionMenu
	 * 
	 * Presents the user an menu depending on which user they are
	 * 
	 * @param login
	 * @param admin
	 * @return true as long as the program is running
	 */
	public static boolean optionMenu(boolean login, boolean admin){
		
		Scanner in= new Scanner(System.in);
		if(!login){
			System.out.println("Welcome: What would you like to do");
			System.out.println("1. Register");
			System.out.println("2. Login");
			System.out.println("3. Exit");
		}
		else if(login && !admin){
			System.out.println("Welcome " + login);
			System.out.println("1. Create an order");
			System.out.println("2. Modify an order");
			System.out.println("3. Check all previous order");
			System.out.println("4. Change your password");
			System.out.println("5. Logout");
			System.out.println("6. Exit");
		}
		else if(admin){
			System.out.println("Welcome back");
			System.out.println("1. View All Company");
			System.out.println("2. View all Orders");
			System.out.println("3. Check all Queue Clients");
			System.out.println("4. Check all Queue Orders");
			System.out.println("5. Change your password");
			System.out.println("6. Logout");
			System.out.println("7. Exit");
		}
		String input;
		input = in.nextLine();
		switch(input){
		case "1":
			if(!login){
				signUp(in);
			}
			else if (admin) {
				viewAllCompany(in);
			}
			else{
				createAnOrder(in);
			}
			break;
			
		case "2":	
			if(!login){
				logIn(in);
			}
			else if (admin) {
				viewAllOrderAdmin(in);
			}
			else{
				modifyAnOrder(in);
			}
			break;
			
		case "3":
			if(!login){
				System.exit(1);
			}
			else if (admin) {
				viewAllQueueClients(in);
			}
			else{
				viewAllOrder(in);
			}
			break;
			
		case "4":
			if(admin){
				viewAllQueueOrders(in);
			}
			else if(login) {
				changeYourPassword(in);
			}
			else
				System.out.println("This input is not valid");
			break;

		case "5":
			if(admin){
				changeYourPassword(in);
			}
			else if(login) {
				logOut(in);
			}
			else
				System.out.println("This input is not valid");
			break;
		
	
		case "6":
			if(admin){
				logOut(in);
			}
			else if(login) {
				System.exit(1);
			}
			else
				System.out.println("This input is not valid");
			break;
		case "7":
			if(admin){
				System.exit(1);
			}
			else
				System.out.println("This input is not valid");
			break;
			
		default:
			System.out.println("This input is not valid");
			break;
		}
		return true;
				
	}

	/**
	 * Method logIn
	 * 
	 *  
	 * @return
	 */
	public static boolean logIn(Scanner in){
	
		return false;
	}
	
	/** 
	 * Method logOut
	 * 
	 * @return
	 */
	public static boolean logOut(Scanner in){
		return false;
	}
	
	/**
	 * Method signUp
	 * 
	 * @return
	 */
	public static boolean signUp(Scanner in){
		System.out.println("What is the name of your company?");
		String company = in.next();
		System.out.print("Username: ");
		String username = in.next();
		System.out.print("Password: ");
		String password = in.next();
		
			
		System.out.println("----------- Processing Information -----------");
		System.out.print("Entering Address\nAddress Line: ");
		
		//ignore the line at EnteringAddress
		in.nextLine();
		Address address = new Address();
		address.setStreet(in.nextLine());
		System.out.print("City: ");
		address.setCity(in.next());
		System.out.print("State: ");
		address.setState(in.next());
		System.out.print("Zipcode: ");
		address.setZipcode(in.next());

		String result = sLayer.createUser(company, username,password, address);
		System.out.println(result);
		return false;
	}
	
	/**
	 * Method createAnOrder
	 * 
	 * @return
	 */
	public static boolean createAnOrder(Scanner in){
		
		return true;
	}
	
	/**
	 * Method modifyAnOrder
	 * @return
	 */
	public static boolean modifyAnOrder(Scanner in){
		return true;
	}

	/**
	 * Method viewAllOrder
	 */
	public static void viewAllOrder(Scanner in){
		
	}
	
	/**
	 * Method viewAllOrderAdmin
	 */
	public static void viewAllOrderAdmin(Scanner in) {
		// TODO Auto-generated method stub
		
	}

	
	/**
	 * Method changeYourPassword
	 * @return
	 */
	public static boolean changeYourPassword(Scanner in){
		
		return true;
	}

	/**
	 * Method viewAllCompany
	 * 
	 * 
	 * @return
	 */
	public static boolean viewAllCompany(Scanner in){
		return true;
	}

	/**
	 * Method viewAllQueueClients
	 * 
	 */
	public static void viewAllQueueClients(Scanner in){
		
	}

	/**
	 * Method viewAllQueueOrders
	 */
	public static void viewAllQueueOrders(Scanner in){
		
	}


}
