package com.luv2code.springdemo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "customer")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull(message = "Id can't be empty.  This shouldn't be happening!")
	@Column(name = "id")
	private Integer id;

	@NotNull(message = "Please enter first name.")
	@Size(min = 1, max = 100, message = "The field must be between {min} and {max} characters.")
	@Column(name = "first_name")
	private String firstName;

	@NotNull(message = "Please enter last name.")
	@Size(min = 1, max = 100, message = "The field must be between {min} and {max} characters.")
	@Column(name = "last_name")
	private String lastName;

	@NotNull(message = "Please enter email.")
	@Size(min = 1, max = 200, message = "The field must be between {min} and {max} characters.")
	@Column(name = "email")
	private String email;

	public Customer() {

	}

	public Customer(String firstName, String lastName, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + "]";
	}

}
