package sharedClass;

import java.util.Scanner;

import javax.persistence.criteria.CriteriaBuilder.Case;
import javax.print.DocFlavor.INPUT_STREAM;

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
				
			}
			else if (admin) {
				
			}
			else{
				
			}
			break;
			
		case "2":	
			if(!login){
				
			}
			else if (admin) {
				
			}
			else{
				
			}
			break;
			
		case "3":
			if(!login){
				System.exit(1);
			}
			else if (admin) {
				
			}
			else{
				
			}
			break;
			
		case "4":
			if(admin){
				
			}
			else if(login) {
				
			}
			else
				System.out.println("This input is not valid");
			break;

		case "5":
			if(admin){
				
			}
			else if(login) {
				
			}
			else
				System.out.println("This input is not valid");
			break;
		
	
		case "6":
			if(admin){
				
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
	public static boolean logIn(){
	
		return false;
	}
	
	/** 
	 * Method logOut
	 * 
	 * @return
	 */
	public static boolean logOut(){
		return false;
	}
	
	/**
	 * Method signUp
	 * 
	 * @return
	 */
	public static boolean signUp(){
		
		return false;
	}
	
	/**
	 * Method createAnOrder
	 * 
	 * @return
	 */
	public static boolean createAnOrder(){
		
		return true;
	}
	
	/**
	 * Method modifyAnOrder
	 * @return
	 */
	public static boolean modifyAnOrder(){
		return true;
	}

	/**
	 * Method viewAllOrder
	 */
	public static void viewAllOrder(){
		
	}
	
	/**
	 * Method changeYourPassword
	 * @return
	 */
	public static boolean changeYourPassword(){
		
		return true;
	}

	/**
	 * Method viewAllCompany
	 * 
	 * 
	 * @return
	 */
	public static boolean viewAllCompany(){
		return true;
	}

	/**
	 * Method viewAllQueueClients
	 * 
	 */
	public static void viewAllQueueClients(){
		
	}

	/**
	 * Method viewAllQueueOrders
	 */
	public static void viewAllQueueOrders(){
		
	}


}
