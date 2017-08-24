package com.packt.ch06.controllers.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

import com.packt.ch06.controllers.AddController;
import com.packt.ch06.pojo.Contact;

@WebAppConfiguration
@ContextConfiguration({ "file:WebContent/WEB-INF/DataWeb-servlet.xml",
		"classpath:connection.xml" })
@RunWith(value = SpringJUnit4ClassRunner.class)
public class TestAddController {

	MockHttpServletRequest request;
	MockHttpServletResponse response;
	ModelAndView modelAndView;

	@Autowired
	AddController addController;

	@Before
	public void setUp() throws Exception {
		modelAndView = new ModelAndView();
		response = new MockHttpServletResponse();
		

	}

	@After
	public void tearDown() throws Exception {
		modelAndView = null;
		addController = null;
		response = null;

	}

	@Test
	public void testAddContact() {
		Contact contact = new Contact();
		contact.setAddress("Mumbai");
		contact.setEmail("com1@packt.com");
		contact.setFirstName("t_first");
		contact.setGender(1);
		contact.setLastName("t_last");
		contact.setPhone_number("9876008990");

		BindingResult bindingResult = new BeanPropertyBindingResult(contact,
				"contact");
		ModelAndView modelAndView;
		try {
			modelAndView = addController.addContact(contact, bindingResult);
			assertEquals("manageContact", modelAndView.getViewName());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testAddContact_negative() {
		try {
			Contact contact = new Contact();
			BindingResult bindingResult = new BeanPropertyBindingResult(
					contact, "contact");
			bindingResult.reject("NotEmpty.contact.email", "default message");
			bindingResult.reject("NotEmpty.contact.FirstName", "name must be filled");
			modelAndView=addController.addContact(contact, bindingResult);
			assertEquals("contactForm",modelAndView.getViewName());
			assertEquals("NotEmpty.contact.email", bindingResult.getAllErrors()
					.get(0).getCode());
			assertEquals(2,bindingResult.getAllErrors().size());
						
		} catch (Exception e) {
			// TODO: handle exception
			//fail("test failed"+e.getMessage());
			
			e.printStackTrace();
		}
	}

	
	

}
