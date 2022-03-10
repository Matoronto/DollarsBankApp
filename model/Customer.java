package com.dollarsbank.model;

public class Customer {
	
	private int custID;
	private String custFName;
	private String custLName;
	private String address;
	private String phoneNumber;
	private String username;
	private String password;
	
	
	
	public Customer(int id, String fName, String lName, String address, String phoneNumber, String username, String password) {
		this.custID = id;
		this.custFName = fName;
		this.custLName = lName;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.username = username;
		this.password = password;
	}
	
	public Customer() {
		super();
	}

	public int getCustID() {
		return custID;
	}

	public void setCustID(int custID) {
		this.custID = custID;
	}

	public String getCustFName() {
		return custFName;
	}

	public void setCustFName(String custFName) {
		this.custFName = custFName;
	}

	public String getCustLName() {
		return custLName;
	}

	public void setCustLName(String custLName) {
		this.custLName = custLName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Customer [custID=" + custID + ", custFName=" + custFName + ", custLName=" + custLName + ", address="
				+ address + ", phoneNumber=" + phoneNumber + ", username=" + username + ", password=" + password + "]";
	}
	
	
	
	
	
	
	

}
