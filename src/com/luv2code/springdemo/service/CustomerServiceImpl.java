package com.luv2code.springdemo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luv2code.springdemo.dao.CustomerDAO;
import com.luv2code.springdemo.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	private final CustomerDAO customerDAO;

	@Autowired
	public CustomerServiceImpl(final CustomerDAO customerDAO) {
		this.customerDAO = customerDAO;
	}

	@Override
	@Transactional
	public List<Customer> getCustomers() {
		return this.customerDAO.getCustomers();
	}

	@Override
	@Transactional
	public void createCustomer(Customer theCustomer) {
		this.customerDAO.createCustomer(theCustomer);
	}

	@Override
	@Transactional
	public Customer getCustomer(int theId) {
		return this.customerDAO.getCustomer(theId);
	}

	@Override
	@Transactional
	public void updateCustomer(Customer theCustomer) {
		this.customerDAO.updateCustomer(theCustomer);
	}

	@Override
	@Transactional
	public void deleteCustomer(Customer theCustomer) {
		this.customerDAO.deleteCustomer(theCustomer);		
	}
}
