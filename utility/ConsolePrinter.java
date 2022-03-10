package com.dollarsbank.utility;

public class ConsolePrinter {
	
	public void mainMenu() {
		System.out.println("Welcome to DollarsBank!");
		System.out.println("------------------------");
		System.out.println("Please Select the following from below");
		System.out.println("1. Create New Account");
		System.out.println("2. Login");
		System.out.println("3. Exit");
	}
	
	public void createCustomer() {
		System.out.println("Enter your information for your account");
		System.out.println("Customer First Name: ");
		System.out.println("Customer Last Name: ");
		System.out.println("Customer Phone Number: ");
		System.out.println("Customer Username: ");
		System.out.println("Customer Password: ");
	}
	
	public void login() {
		System.out.println("Enter your credentials below.");
		System.out.println("------------------------------");
		System.out.println("Username: ");
		System.out.println("Password: ");
		
	}
	
	public void customerMenu() {
		System.out.println("Welcome!!!!");
		
		System.out.println("Please select the following options");
		
		System.out.println("1. Deposit Amount");
		
		System.out.println("2. Withdraw Amount");
		
		System.out.println("3. Transfer Amount");
		
		System.out.println("4. View 5 recent transaction histories");
		
		System.out.println("5. Display Customer Information");
		
		System.out.println("6. Sign Out");
		
		System.out.println("7. Exit");
		
	}

}
