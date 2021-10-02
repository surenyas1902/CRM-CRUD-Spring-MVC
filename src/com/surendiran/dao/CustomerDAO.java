package com.surendiran.dao;

import java.util.List;

import com.surendiran.entity.Customer;

public interface CustomerDAO {

	public List<Customer> getCustomers();
	
	public void saveCustomer(Customer myCustomer);
	
	public Customer getCustomer(int customerId);
}
