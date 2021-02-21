package com.charchit.springdemo.service;

import java.util.List;

import com.charchit.springdemo.entity.Customer;

public interface CustomerService {
	public List<Customer> getCustomers();

	public void saveCustomer(Customer customer);

	public Customer getCustomer(int theId);

	public void delete(int theId);
}
