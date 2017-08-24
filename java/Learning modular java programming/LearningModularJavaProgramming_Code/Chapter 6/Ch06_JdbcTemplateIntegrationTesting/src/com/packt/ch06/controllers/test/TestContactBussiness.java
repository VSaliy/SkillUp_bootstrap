package com.packt.ch06.controllers.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.packt.ch06.bussiness.ContactBussinessImpl;
import com.packt.ch06.dao.ContactDAOImpl;
import com.packt.ch06.pojo.Contact;

public class TestContactBussiness {

	
	@InjectMocks
	ContactBussinessImpl bussinessImpl;

	@Mock
	ContactDAOImpl contactDAOImpl;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testAddContact() {
		Contact contact = new Contact();
		contact.setAddress("address1");
		contact.setEmail("test2@test.com");
		contact.setFirstName("first");
		contact.setLastName("last");
		contact.setGender(1);
		contact.setPhone_number("1212121212");
		Mockito.when(contactDAOImpl.addContact(contact)).thenReturn(1);
		
		int result=bussinessImpl.addContact(contact);
		assertEquals(1,result);
	}

	@Test
	public void testFindContact() {
		Contact contact = new Contact();
		contact.setAddress("address1");
		contact.setEmail("test2@test.com");
		contact.setFirstName("first");
		contact.setLastName("last");
		contact.setGender(1);
		contact.setPhone_number("1212121212");
		Mockito.when(contactDAOImpl.findContact("test2@test.com")).thenReturn(contact);
		
		Contact contact2=bussinessImpl.findContact("test2@test.com");
		assertEquals("test2@test.com", contact2.getEmail());
	}

	@Test
	public void testFindAllContcats() {
		List<Contact>contacts=new ArrayList<Contact>();
		Contact contact = new Contact();
		contact.setAddress("address1");
		contact.setEmail("test2@test.com");
		contact.setFirstName("first");
		contact.setLastName("last");
		contact.setGender(1);
		contact.setPhone_number("1212121212");
		contacts.add(contact);
		contacts.add(contact);
		Mockito.when(contactDAOImpl.findAllContcats()).thenReturn(contacts);
		List<Contact> contacts2=bussinessImpl.findAllContcats();
		
		assertEquals(contacts.size(),contacts2.size());
	}

}
