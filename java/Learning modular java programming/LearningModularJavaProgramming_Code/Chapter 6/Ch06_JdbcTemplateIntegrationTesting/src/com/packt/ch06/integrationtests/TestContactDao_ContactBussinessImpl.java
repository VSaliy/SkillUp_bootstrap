package com.packt.ch06.integrationtests;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;

import com.packt.ch06.bussiness.ContactBussiness;
import com.packt.ch06.dao.ContactDAO;
import com.packt.ch06.pojo.Contact;

public class TestContactDao_ContactBussinessImpl {

	ContactBussiness contactBussiness;
	ContactDAO contactDAO;

	@Before
	public void setUp() throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"connection.xml");
		contactDAO = (ContactDAO) context.getBean("contactDao");
		contactBussiness = (ContactBussiness) context
				.getBean("contactBussiness");
	}

	@After
	public void tearDown() throws Exception {
		contactDAO=null;
		contactBussiness=null;
	}

	@Test
	public void testAddContact() {
		Contact contact = new Contact();
		contact.setEmail("xxx@xxx.com");
		contact.setAddress("Mumbai");
		contact.setFirstName("xxxx");
		contact.setLastName("yyy");
		contact.setGender(1);
		contact.setPhone_number("7645342312");

		int data = contactBussiness.addContact(contact);

		Contact contact_search = contactDAO.findContact("xxx@xxx.com");
		assertEquals("7645342312", contact_search.getPhone_number());
	}

	@Test
	public void testFindContact() {
		Contact contact = contactBussiness.findContact("xxx@xxx.com");

		Contact contact2 = contactDAO.findContact("xxx@xxx.com");

		assertEquals(contact2.getFirstName(), contact.getFirstName());
	}

	@Test
	public void testFindAllContcats() {
		List<Contact> contacts = contactBussiness.findAllContcats();
		List<Contact> contacts_dao = contactDAO.findAllContcats();

		assertEquals(contacts_dao.size(),contacts.size());
	}

}
