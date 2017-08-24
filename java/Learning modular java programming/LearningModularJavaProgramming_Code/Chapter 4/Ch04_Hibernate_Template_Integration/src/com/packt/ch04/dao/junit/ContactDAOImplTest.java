package com.packt.ch04.dao.junit;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.packt.ch04.dao.ContactDAO;
import com.packt.ch04.pojo.Contact;

public class ContactDAOImplTest {

	ContactDAO dao;

	@Before
	public void setUp() throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"connection.xml");
		dao = (ContactDAO) context.getBean("contactDao");
	}

	@After
	public void tearDown() throws Exception {
		dao = null;
	}

	@Test
	public void testAddContact() {

		Contact contact = new Contact();
		contact.setEmail("abcd89@abc.com");
		contact.setAddress("Waecity");
		contact.setFirstName("billy");
		contact.setLastName("brown");
		contact.setPhone_number("3456543129");

		int record = dao.addContact(contact);
//		assertEquals(1,record );
	}

	@Test
	public void testAddContact_Negative() {

		Contact contact = new Contact();
		contact.setEmail("abcd89@abc.com");
		contact.setAddress("Waecity");
		contact.setFirstName("billy");
		contact.setLastName("brown");
		contact.setPhone_number("3456543129");

		int record = dao.addContact(contact);
		assertEquals(0, record);
	}

	public void testFindAllContacts() {

		List<Contact>contacts = dao.findAllContcats();
		assertEquals(6,contacts.size());
	}
	
	public void testFindCotact() {

		Contact contact = dao.findContact("abcd@gmail.com");
		assertEquals("787654321",contact.getPhone_number());
	}
	
	public void testFindCotact_negative() {
		Contact contact = dao.findContact("a@gmail.com");
		assertNull(contact);
	}
}
