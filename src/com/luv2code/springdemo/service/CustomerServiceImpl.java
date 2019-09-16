package com.luv2code.springdemo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
	public void deleteCustomer(int theId) {

		Customer theCustomer = this.customerDAO.getCustomer(theId);

		if (theCustomer != null) {
			this.customerDAO.deleteCustomer(theCustomer);
		}

	}

	@Override
	@Transactional
	public List<Customer> searchCustomers(String theSearchName) {

		List<Customer> searchResults = new ArrayList<>();

		if (!"".equals(Objects.toString(theSearchName, ""))) {
			searchResults = this.customerDAO.searchCustomers(theSearchName);
		} else {
			searchResults = this.customerDAO.getCustomers();
		}

		return searchResults;

	}
}
