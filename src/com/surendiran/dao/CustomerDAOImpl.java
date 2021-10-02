package com.surendiran.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.surendiran.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	// need to inject the session factory
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public List<Customer> getCustomers() {
		
		// get the current Hibernate session
		Session session = sessionFactory.getCurrentSession();
		
		// create a query
		Query<Customer> theQuery = session.createQuery("from Customer order by lastName", Customer.class);
		
		// get the customer list from query
		List<Customer> customersList = theQuery.getResultList();
		
		//return list of customers
		return customersList;
	}


	@Override
	public void saveCustomer(Customer myCustomer) {
		
		Session session = sessionFactory.getCurrentSession();
		
		if (myCustomer.getRowId() > 0) {
			session.saveOrUpdate(myCustomer);
		}
		else {
			session.save(myCustomer);
		}
	}


	@Override
	public Customer getCustomer(int customerId) {
		
		Session session = sessionFactory.getCurrentSession();
		
		Customer customer = session.get(Customer.class,	customerId);
		
		return customer;
	}
	
	
	
	
}
