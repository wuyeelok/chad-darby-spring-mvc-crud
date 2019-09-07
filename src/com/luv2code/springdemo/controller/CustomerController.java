package com.luv2code.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.luv2code.springdemo.dao.CustomerDAO;
import com.luv2code.springdemo.entity.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	private final CustomerDAO customerDAO;

	@Autowired
	public CustomerController(final CustomerDAO customerDAO) {
		this.customerDAO = customerDAO;
	}

	@GetMapping("/list")
	public String listCustomers(ModelMap theModel) {

		List<Customer> customers = this.customerDAO.getCustomers();

		theModel.addAttribute("customers", customers);

		return "list-customers";
	}

}
