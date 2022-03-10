package com.dollarsbank.utility;

import java.util.List;

import com.dollarsbank.model.Customer;

public class DataGeneratorStub {
	
	public static FileStorageUtility fs = new FileStorageUtility();
	
	public boolean stubGenerator(Customer cust) {
		
		String stubHeader = "Thank You for choosing DollarsBank Services " + cust.getCustFName() + " "
				+ "we hope to see you soon."
		
		+ "Bank Stub\n"
		+ "ID: " + cust.getCustID() + "\n"
		+ "First Name: " + cust.getCustFName() + "\n"
		+ "Last Name: " + cust.getCustLName() + "\n"
		+ "Phone Number: " + cust.getPhoneNumber() + "\n"
		+ "Username: " + cust.getUsername() + "\n"
		+ "Password: " + cust.getPassword();
		
	//	String stubBody = transactionHistoryBody(cust.getHistory());
		
		String stubFooter = "---------------------------------";
		fs.fileSave(cust.getCustFName(), cust.getCustLName(), stubHeader + stubFooter);
		
		return false;
		
	}

	public String transactionHistoryBody(List<String> history) {
		
		String transactionHistoryBody = "";
		 for(String string : history) 
		 {
			 transactionHistoryBody += "-" + string.replace("\n", "") + "\n";
		 }
		 transactionHistoryBody += "-\n";
		return transactionHistoryBody;
	}
	

}
