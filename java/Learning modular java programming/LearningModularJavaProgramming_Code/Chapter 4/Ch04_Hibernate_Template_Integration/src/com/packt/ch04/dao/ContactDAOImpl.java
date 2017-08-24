package com.packt.ch04.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.packt.ch04.pojo.Contact;

public class ContactDAOImpl implements ContactDAO {

	HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public int addContact(Contact contact) {
		// TODO Auto-generated method stub
		try {
			hibernateTemplate.persist(contact);
			return 1;
		} catch (DataAccessException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return 0;
	}

	public Contact findContact(String email) {
		return (Contact) hibernateTemplate.get(Contact.class, email);
	}

	public List<Contact> findAllContcats() {
		List<Contact> contacts = hibernateTemplate.loadAll(Contact.class);
		return contacts;
	}

}
