package com.packt.ch06.controllers.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.web.servlet.ModelAndView;
import org.junit.runner.RunWith;

import com.packt.ch06.bussiness.ContactBussiness;
import com.packt.ch06.bussiness.ContactBussinessImpl;
import com.packt.ch06.controllers.AddController;
import com.packt.ch06.pojo.Contact;

@ContextConfiguration({ "file:WebContent/WEB-INF/DataWeb-servlet.xml",
		"classpath:connection.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class TestAddController_standAlone {
	private MockMvc mockMvc;

	@Autowired
	AddController addController;

	@Before
	public void setUp() throws Exception {

		mockMvc = MockMvcBuilders.standaloneSetup(addController).build();

	}
	
	@Test
	public void testAddContact() {

		try {

			mockMvc.perform(
					MockMvcRequestBuilders.post("/addContact.htm")
							.contentType(MediaType.APPLICATION_FORM_URLENCODED)
							.param("email", "packt1@test.com")
							.param("firstName", "first_n")
							.param("lastName", "last_n")
							.param("address", "testing address")
							.param("phone_number", "9191919191")
							.param("gender", "1")
							.requestAttr("contact", new Contact()))
					.andExpect(
							MockMvcResultMatchers.view().name("manageContact"))
					.andExpect(
							MockMvcResultMatchers.model().attribute("id",
									"packt1@test.com"))
					.andDo(MockMvcResultHandlers.print());
			;
		} catch (Exception e) {
			// TODO: handle exception
			fail(e.getMessage());
			e.printStackTrace();
		}
	}

	@Test
	public void testAddContact_negative() {
		try {

			mockMvc.perform(
					MockMvcRequestBuilders.post("/addContact.htm")
							.contentType(MediaType.APPLICATION_FORM_URLENCODED)
							.param("email", "packt").param("firstName", "f")
							.param("lastName", "last_n")
							.param("address", "testing address")
							.param("phone_number", "9191919191")
							.param("gender", "1")
							.requestAttr("contact", new Contact()))

					.andExpect(MockMvcResultMatchers.view().name("contactForm"))
					.andExpect(
							MockMvcResultMatchers
									.model()
									.attributeHasFieldErrors("contact", "email"))
					.andExpect(
							MockMvcResultMatchers.model()
									.attributeHasFieldErrors("contact",
											"firstName"))
					.andDo(MockMvcResultHandlers.print());
			;
		} catch (Exception e) {
			// TODO: handle exception
			fail(e.getMessage());
			e.printStackTrace();
		}
	}

	@Test
	public void testShowContactForm() {
		try {
			Contact contact = new Contact();
			ExtendedModelMap map=new ExtendedModelMap();
			map.addAttribute(contact);
			mockMvc.perform(MockMvcRequestBuilders.post("/addContact.htm"))
					.andExpect(MockMvcResultMatchers.status().isOk())
					.andExpect(MockMvcResultMatchers.view().name("contactForm"))
					.andExpect(
							MockMvcResultMatchers.model().attributeExists(
									"contact")).andDo(MockMvcResultHandlers.print());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail(e.getMessage());
		}

	}

}
