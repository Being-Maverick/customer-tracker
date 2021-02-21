package com.charchit.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.charchit.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getCustomers() {
		Session s = sessionFactory.getCurrentSession();
		
		Query<Customer> query = s.createQuery("from Customer order by lastName", Customer.class);
		
		List<Customer> customers = query.getResultList();
		return customers;
	}

	@Override
	public void saveCustomer(Customer customer) {
		Session s = sessionFactory.getCurrentSession();
		s.saveOrUpdate(customer);
	}

	@Override
	public Customer getCustomer(int theId) {
		Session s = sessionFactory.getCurrentSession();
		Customer c = s.get(Customer.class, theId);
		return c;
	}

	@Override
	public void delete(int theId) {
		// TODO Auto-generated method stub
		Session s = sessionFactory.getCurrentSession();
		Customer c = s.get(Customer.class, theId);
		s.delete(c);
	}

}
