package com.surendiran.services;

import java.util.List;

import com.surendiran.entity.Customer;

public interface CustomerService {

	public List<Customer> getCustomers();
	
	public void saveCustomer(Customer myCustomer);
	
	public Customer getCustomer(int customerId);
}
