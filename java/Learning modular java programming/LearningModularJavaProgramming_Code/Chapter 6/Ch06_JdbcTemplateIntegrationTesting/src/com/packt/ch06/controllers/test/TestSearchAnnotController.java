package com.packt.ch06.controllers.test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.ModelAndView;

import com.packt.ch06.controllers.SearchAnnotController;
import com.packt.ch06.pojo.Contact;

@ContextConfiguration({ "file:WebContent/WEB-INF/DataWeb-servlet.xml",
		"classpath:connection.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class TestSearchAnnotController {

	@Autowired
	SearchAnnotController searchAnnotController;
	MockHttpServletRequest request;
	MockHttpServletResponse response;

	MockMvc mockMvc;

	@Before
	public void setUp() throws Exception {
		response = new MockHttpServletResponse();
		request = new MockHttpServletRequest();
		mockMvc = MockMvcBuilders.standaloneSetup(searchAnnotController)
				.build();

	}

	@Test
	public void testGetContcat() {

		try {
			mockMvc.perform(
					MockMvcRequestBuilders.get("/searchFromAnnot.htm").param(
							"id", "packt@test.com"))
					.andExpect(MockMvcResultMatchers.status().isOk())
					.andExpect(MockMvcResultMatchers.view().name("display"));

		} catch (Exception e) {
			// TODO: handle exception
			fail(e.getMessage());
		}

	}

	@Test
	public void testShowAllContacts() {
		try {
			mockMvc.perform(
					MockMvcRequestBuilders.get("/showRecords.htm"))
					.andExpect(MockMvcResultMatchers.status().isOk())
					.andExpect(
							MockMvcResultMatchers.view().name("showContacts"))
					.andExpect(
							MockMvcResultMatchers.model().attributeExists(
									"myList"));

		} catch (Exception e) {
			// TODO: handle exception
			fail(e.getMessage());
		}

	}

}
