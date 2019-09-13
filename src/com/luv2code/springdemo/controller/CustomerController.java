package com.luv2code.springdemo.controller;

import java.util.List;
import java.util.Objects;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.luv2code.springdemo.constant.FormMode;
import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;

@Controller
@SessionAttributes({ "formMode", "formModeLowercase", "showId", "updatingId" })
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
	public String showFormForAdd(ModelMap theModel) {

		theModel.addAttribute("formMode", FormMode.CREATE);
		theModel.addAttribute("formModeLowercase", FormMode.CREATE.toLowerCase());

		theModel.addAttribute("showId", false);

		Customer theCustomer = new Customer();
		theCustomer.setId(0);
		theModel.addAttribute("customer", theCustomer);

		return "customer-form";
	}

	@PostMapping("/createCustomer")
	public String createCustomer(ModelMap theModel, @Valid @ModelAttribute Customer customer, BindingResult result) {

		String view = "";

		if (result.hasErrors()) {
			view = "customer-form";
		} else {
			this.customerService.createCustomer(customer);

			theModel.clear();
			view = "redirect:list";
		}

		return view;
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(ModelMap theModel, @RequestParam(name = "id") int updatingId) {

		String view = "";

		theModel.addAttribute("formMode", FormMode.UPDATE);
		theModel.addAttribute("formModeLowercase", FormMode.UPDATE.toLowerCase());

		theModel.addAttribute("showId", true);

		theModel.addAttribute("updatingId", updatingId);

		Customer theCustomer = this.customerService.getCustomer(updatingId);
		if (theCustomer != null) {
			theModel.addAttribute("customer", theCustomer);
			view = "customer-form";
		} else {
			theModel.clear();
			view = "redirect:list";
		}

		return view;
	}

	@PostMapping("/updateCustomer")
	public String updateCustomer(ModelMap theModel, @Valid @ModelAttribute Customer customer, BindingResult result) {

		String view = "";

		int updatingId = Integer.parseInt(Objects.toString(theModel.get("updatingId"), "-1"));

		boolean validId = updatingId != customer.getId();

		if (result.hasErrors() || validId) {
			if (validId) {
				theModel.addAttribute("idErrorMsg", "Stop messing with the Id field!");
			}

			view = "customer-form";
		} else {

			theModel.clear();
			view = "redirect:list";
		}

		return view;

	}
}
