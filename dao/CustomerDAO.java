package com.dollarsbank.dao;

import java.util.List;

import com.dollarsbank.model.Customer;

public interface CustomerDAO {
	
	public int updateBalance(String custID, double balance);
	public int delete(int id);
	public int save(Customer e);
	public void saveHistory(String custID, String historyMessage);
	public Customer getCustomerById(int id);
	public List<String> getHistory(String custID);
	public List<Customer> getAllAccounts();

}
