package com.dollarsbank.model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CheckingAccount extends Account{
	
	private int accountID;
	
	private double balance;
	
	private final double maxBalance = 10000;
	
	private int custID;
	
	String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
	
	
	public int getAccountID() {
		return accountID;
	}

	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public int getCustID() {
		return custID;
	}

	public void setCustID(int custID) {
		this.custID = custID;
	}

	public String getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

	public double getMaxBalance() {
		return maxBalance;
	}

	
	
	private List<String>transactionHistory = new ArrayList<String>();
	

	public List<String> getTransactionHistory() {
		return transactionHistory;
	}

	public void setTransactionHistory(List<String> transactionHistory) {
		this.transactionHistory = transactionHistory;
	}

	@Override
	public double deposit(double amount) {
		
		addToHistory("Deposited " + amount + " as of" + timeStamp);
		
		return balance += amount;
		
	}

	@Override
	public double withdraw(double amount) {
		
		addToHistory("Withdraw " + amount + " as of " + timeStamp);
		
		return balance -= amount;
		
	}

	@Override
	public double transfer(double amount, String receiverId) {
		
		balance -= amount;
		addToHistory("Withdrew amount of " + amount + 
				" and transferred it to " + receiverId + 
				" as of " + timeStamp);
		// TODO Auto-generated method stub
		
		return amount; //used to add to add/subtract from accounts in controller.
	}

	@Override
	public void printHistory() {
		
		List<String> transactionHistory = new ArrayList<String>();
		
		for(String print : transactionHistory)
		{
			System.out.println(print.toString());
		}
		
	}

	@Override
	public void addToHistory(String text) {
		
		if(transactionHistory.size() == 5) {
			transactionHistory.remove(0);
			System.out.println("Removing Index 0");
			transactionHistory.add(text);
			setTransactionHistory(transactionHistory);
		} else {
			transactionHistory.add(text);
			setTransactionHistory(transactionHistory);
		}
		
	}

	@Override
	public List<String> getHistory() {
		
		return null;
		
	}

}
