package com.luv2code.springdemo.service;

import java.util.List;

import javax.validation.Valid;

import com.luv2code.springdemo.entity.Customer;

public interface CustomerService {

	public List<Customer> getCustomers();

	public void createCustomer(Customer theCustomer);

	public Customer getCustomer(int id);

	public void updateCustomer(@Valid Customer customer);

}
