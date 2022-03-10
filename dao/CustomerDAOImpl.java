package com.dollarsbank.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dollarsbank.model.Customer;

public class CustomerDAOImpl implements CustomerDAO {
	
	static Connection conn = null;
	
	static Statement stmt = null;
	
	public static Connection getConnection() 
	{
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dollarsbank", "root", "root");
			
			return conn;
		} catch(Exception e) {
			System.out.println("Issue connecting to the database");
		}
		
		return conn;
		
		
	}

	@Override
	public int updateBalance(String custID, double balance) {
		
		try {
			Connection conn = getConnection();

			PreparedStatement pst = conn.prepareStatement("update checking_account set balance=? where account_id=" +"'"+ custID+"'");
			System.out.println(balance);
			pst.setDouble(1, balance);
			pst.executeUpdate();
			System.out.println("updated to database");
		} catch (SQLException e1) {
	
			e1.printStackTrace();
			
		}
		
		return 0;
	}

	@Override
	public int delete(int id) {
		
		int status = 0;
		try {
			Connection conn = getConnection();
			PreparedStatement pst = conn.prepareStatement("delete from customer where cust_id=?");
			pst.setInt(1, id);
			status = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return status;
	}

	@Override
	public int save(Customer e) {
		//create prepared statement
				try {
					Connection conn = getConnection();
//					List<Customer> list = getAllAccounts();
//					for (Customer customer : list)
//					{
//						if(e.getCustID().equals(customer.getCustID()))
//						{
//							return 0;
//						}
//					}
					
					PreparedStatement stmt = conn.prepareStatement("insert into customer(cust_id, cust_first_name, cust_last_name, phone_number, username, password, address) values(?,?,?,?,?,?,?)");
					
					((PreparedStatement) stmt).setInt(1, e.getCustID());	
					((PreparedStatement) stmt).setString(2, e.getCustFName());	
					((PreparedStatement) stmt).setString(3, e.getCustLName());
					((PreparedStatement) stmt).setString(4, e.getPhoneNumber());
					((PreparedStatement) stmt).setString(5, e.getUsername());
					((PreparedStatement) stmt).setString(6, e.getPassword());
					((PreparedStatement) stmt).setString(7, e.getAddress());
					
					stmt.executeQuery();
					System.out.println("saved to database");
				} catch (SQLException e1) {
	                System.out.println("Could not save to database.");
					e1.printStackTrace();
					
				} finally {
					try {
						conn.close();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
		
		return 0;
	}

	@Override
	public void saveHistory(String custID, String historyMessage) {
		
		try {
			Connection conn = getConnection();
			PreparedStatement pst = conn.prepareStatement("insert into accounthistory(userid,history)values(?,?)");
			pst.setString(1, custID);	
			pst.setString(2, historyMessage);
			pst.executeUpdate();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			
		}
		
	}

	@Override
	public Customer getCustomerById(int id) {
		
		Customer c = new Customer();
		
		 try{  
	            Connection con = CustomerDAOImpl.getConnection();  
	            PreparedStatement ps=con.prepareStatement("select * from dollarsbank.customer where cust_id=?");  
	            ps.setInt(1,id);  
	            ResultSet rs=ps.executeQuery();  
	            if(rs.next()){  
//	                e.setEmpId(rs.getInt(1));  
//	                e.seteName(rs.getString(2));  
//	                e.setPassword(rs.getString(3));  
//	                e.setEmail(rs.getString(4));  
//	                e.setCountry(rs.getString(5));  
	            }  
	            con.close();  
	        }catch(Exception ex)
		     {
	        	ex.printStackTrace();
	        }  
	          
	        return c;  
	}

	@Override
	public List<String> getHistory(String custID) {
		
		List<String> list = new ArrayList<>();
		try {
		
		Connection con = getConnection();
		PreparedStatement pst = con.prepareStatement("select * from accounthistory where userid='"+custID+"'");
		ResultSet rs = pst.executeQuery();
		
		while(rs.next())
		{
			list.add(rs.getString(3));
		}
		//System.out.println("TestinglistHistory: "+list.toString());
		
		
		}catch (SQLException e) {
		
		}
		return list;
		
	}

	@Override
	public List<Customer> getAllAccounts() {
		
		// TODO Auto-generated method stub
				List<Customer> list = new ArrayList<Customer>();
				try {
					Connection con = getConnection();
					PreparedStatement pst = con.prepareStatement("select * from account_details");
					ResultSet rs = pst.executeQuery();
					
					while (rs.next())
					{	
						//System.out.println("adding employee to list");
						list.add(new Customer(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6), null));
						
					}
				} catch (Exception e) {
					// TODO: handle exception
				}
				return list;
//		return null;
	}

	public void findById(int custId) {
		
//		Customer c = new Customer();
		
		try {
			conn = getConnection();
			stmt = conn.prepareStatement("Select * from dollarsbank.customer where cust_id = ?");
			((PreparedStatement) stmt).setInt(1, custId);
			ResultSet rs = stmt.executeQuery(null);
			while(rs.next()) {
				System.out.println("Customer ID: " + rs.getInt(1) + "Customer First Name: " + rs.getString(2) + " Customer Last Name: " + rs.getString(3)
				+ "Phone Number: " + rs.getString(4) + "Username: " + rs.getString(5) + "Password: " + rs.getString(6) + "Address " + rs.getString(6));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
