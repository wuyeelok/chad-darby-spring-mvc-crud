package com.luv2code.springdemo.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	private final SessionFactory sessionFactory;

	@Autowired
	public CustomerDAOImpl(final SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<Customer> getCustomers() {

		Session session = this.sessionFactory.getCurrentSession();

		CriteriaBuilder cb = session.getCriteriaBuilder();

		CriteriaQuery<Customer> cq = cb.createQuery(Customer.class);

		Root<Customer> root = cq.from(Customer.class);

		Order orderByLastNameAsc = cb.asc(root.get("lastName"));

		cq.select(root).orderBy(orderByLastNameAsc);

		Query<Customer> query = session.createQuery(cq);

		return query.getResultList();

	}

	@Override
	public void createCustomer(Customer theCustomer) {

		// Get current hibernate session
		Session session = this.sessionFactory.getCurrentSession();

		// Save the customer
		session.save(theCustomer);

	}

	@Override
	public Customer getCustomer(int theId) {

		// Get current hibernate session
		Session session = this.sessionFactory.getCurrentSession();

		// Get customer by id
		return session.get(Customer.class, theId);

	}

	@Override
	public void updateCustomer(Customer theCustomer) {

		// Get current hibernate session
		Session session = this.sessionFactory.getCurrentSession();

		session.update(theCustomer);

	}

	@Override
	public void deleteCustomer(Customer theCustomer) {

		// Get current hibernate session
		Session session = this.sessionFactory.getCurrentSession();

		session.delete(theCustomer);

	}

}
