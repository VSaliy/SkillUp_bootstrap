package test;

import static org.junit.Assert.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Validator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockFilterChain;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.ModelAndViewAssert;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultHandler;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.FlashMap;
import org.springframework.web.servlet.HandlerExecutionChain;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.annotation.AnnotationMethodHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.packt.ch06.bussiness.ContactBussiness;
import com.packt.ch06.controllers.AddController;
import com.packt.ch06.pojo.Contact;

import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.ModelMap;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;

@WebAppConfiguration
@ContextConfiguration({ "file:WebContent/WEB-INF/DataWeb-servlet.xml",
		"classpath:connection.xml" })
@RunWith(value = SpringJUnit4ClassRunner.class)
public class TestAddController {

	@Autowired
	private WebApplicationContext context;

	@Autowired
	private AddController addController;

	MockMvc mockMvc;

	@Before
	public void setUp() throws Exception {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}

	@Test
	public void testAddContact() {
		try {

			this.mockMvc
					.perform(
							MockMvcRequestBuilders
									.post("/addContact.htm")
									.contentType(
											MediaType.APPLICATION_FORM_URLENCODED)
									.param("email", "packt@test.com")
									.param("firstName", "first_n")
									.param("lastName", "last_n")
									.param("address", "testing address")
									.param("phone_number", "9191919191")
									.param("gender", "1")
									.requestAttr("contact", new Contact()))
					.andExpect(MockMvcResultMatchers.status().isOk())
					.andExpect(
							MockMvcResultMatchers.view().name("manageContact"))
					.andExpect(
							MockMvcResultMatchers.model().attributeHasNoErrors(
									"contact"))
					.andExpect(model().attribute("id", is("packt@test.com")))
					.andDo(MockMvcResultHandlers.print());

		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
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

		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	@Test
	public void testShowContactForm() {
		try {
			Contact contact = new Contact();
			ExtendedModelMap map=new ExtendedModelMap();
			map.addAttribute(contact);
			mockMvc.perform(MockMvcRequestBuilders.post("/showForm.htm"))
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

	
	@Test
	public void testGetContact_positive() {
		try {

			Contact contact = new Contact();
			contact.setEmail("test2@test.com");
			this.mockMvc
					.perform(
							MockMvcRequestBuilders.post("/searchFromAnnot.htm")
									.param("id", "test2@test.com"))
					.andExpect(MockMvcResultMatchers.status().isOk())
					.andExpect(MockMvcResultMatchers.view().name("display"))
					.andExpect(model().attributeExists("contact"))
					.andExpect(model().attribute("contact", contact))
					.andDo(MockMvcResultHandlers.print());
		} catch (Exception e) { // TODO: handle exception
			fail("no contact available");
		}
	}

	@Test
	public void testGetContact_negative() {
		try {
			Contact contact = new Contact();
			this.mockMvc
					.perform(
							MockMvcRequestBuilders.post("/searchFromAnnot.htm")
									.param("id", "a@a.com"))
					.andExpect(MockMvcResultMatchers.status().isOk())
					.andExpect(MockMvcResultMatchers.view().name("display"))
					.andExpect(model().attributeDoesNotExist("contact"))
					.andDo(MockMvcResultHandlers.print());
		} catch (Exception e) { // TODO:
			fail("no contact available");
		}
	}


}
