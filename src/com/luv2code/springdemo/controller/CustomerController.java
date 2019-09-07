package com.luv2code.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	private final CustomerService customerService;

	@Autowired
	public CustomerController(final CustomerService customerService) {
		this.customerService = customerService;
	}

	@GetMapping("/list")
	public String listCustomers(ModelMap theModel) {

		List<Customer> customers = this.customerService.getCustomers();

		theModel.addAttribute("customers", customers);

		return "list-customers";
	}

}
