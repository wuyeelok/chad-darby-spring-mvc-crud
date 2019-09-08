package com.luv2code.springdemo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.luv2code.springdemo.constant.FormMode;
import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;

@Controller
@SessionAttributes({ "formMode", "showId" })
@RequestMapping("/customer")
public class CustomerController {

	private final CustomerService customerService;

	@Autowired
	public CustomerController(final CustomerService customerService) {
		this.customerService = customerService;
	}

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		binder.registerCustomEditor(String.class, stringTrimmerEditor);
	}

	@GetMapping("/list")
	public String listCustomers(ModelMap theModel) {

		List<Customer> customers = this.customerService.getCustomers();

		theModel.addAttribute("customers", customers);

		return "list-customers";
	}

	@GetMapping("/showFormForAdd")
	public String createCustomer(ModelMap theModel) {

		theModel.addAttribute("formMode", FormMode.CREATE);

		theModel.addAttribute("showId", false);

		Customer newCustomer = new Customer();
		newCustomer.setId(0);
		theModel.addAttribute("customer", newCustomer);

		return "edit-customer";
	}

	@PostMapping("/customerCreate")
	public String createCustomer(ModelMap theModel, @Valid @ModelAttribute Customer customer, BindingResult result) {

		String view = "";

		if (result.hasErrors()) {
			view = "edit-customer";
		} else {
			this.customerService.createCustomer(customer);
			
			theModel.clear();
			view = "redirect:list";
		}

		return view;
	}
}
