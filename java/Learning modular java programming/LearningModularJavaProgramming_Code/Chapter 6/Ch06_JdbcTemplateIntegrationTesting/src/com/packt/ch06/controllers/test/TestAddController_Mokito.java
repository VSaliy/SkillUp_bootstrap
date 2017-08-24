package com.packt.ch06.controllers.test;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.setup.StandaloneMockMvcBuilder;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import com.packt.ch06.bussiness.ContactBussinessImpl;
import com.packt.ch06.controllers.AddController;
import com.packt.ch06.controllers.SearchAnnotController;
import com.packt.ch06.pojo.Contact;
import com.packt.ch06.pojo.Gender;
import org.mockito.runners.MockitoJUnitRunner;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;


public class TestAddController_Mokito {

	MockMvc mockMvc;

	@InjectMocks
	SearchAnnotController searchAnnotController;
	
	@InjectMocks
	AddController addController;

	@Mock
	BeanPropertyBindingResult bindingResult;
	@Mock
	ContactBussinessImpl bussinessImpl;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testGetContact()
	{
		Contact contact = new Contact();
		contact.setAddress("address1");
		contact.setEmail("abc@abc.com");
		contact.setFirstName("first");
		contact.setLastName("last");
		contact.setGender(1);
		contact.setPhone_number("1212121212");
		when(bussinessImpl.findContact("abc@abc.com")).thenReturn(contact);

		ModelAndView modelAndView=searchAnnotController.getContcat("abc@abc.com");
		Set<Map.Entry<String,Object>> entries=modelAndView.getModel().entrySet();
		Iterator iterator=entries.iterator();
		Contact contact2=null;
		while (iterator.hasNext()) {
			Map.Entry entry=(Map.Entry)iterator.next();
			contact2=(Contact)entry.getValue();
		}
		assertEquals(contact.getEmail(),contact2.getEmail());
	}
	@Test
	public void testAddContact()
	{
		Contact contact = new Contact();
		contact.setAddress("address1");
		contact.setEmail("abc@abc.com");
		contact.setFirstName("first");
		contact.setLastName("last");
		contact.setGender(1);
		contact.setPhone_number("1212121212");
		when(bussinessImpl.addContact(contact)).thenReturn(1);
		
		try {
			ModelAndView modelAndView=addController.addContact(contact, bindingResult);
			Set<Map.Entry<String,Object>> entries=modelAndView.getModel().entrySet();
			Iterator iterator=entries.iterator();
		    String val=null;
			while (iterator.hasNext()) {
				Map.Entry entry=(Map.Entry)iterator.next();
				val=(String)entry.getValue();
			}
			assertEquals(1,entries.size());
			assertEquals("abc@abc.com",val);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail(e.getMessage());
		}
	}

	
}
