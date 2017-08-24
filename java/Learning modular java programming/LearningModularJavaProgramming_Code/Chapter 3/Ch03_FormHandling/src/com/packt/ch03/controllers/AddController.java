package com.packt.ch03.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.packt.ch03.pojo.Contact;
import com.packt.ch03.pojo.Gender;

@Controller
public class AddController {

	@ModelAttribute("genderList")
	public List<Gender> addGenders() {
		List<Gender> genders = new ArrayList<Gender>();
		Gender genderF = new Gender();
		genderF.setId(1);
		genderF.setValue("Female");

		Gender genderM = new Gender();
		genderM.setId(1);
		genderM.setValue("Male");

		genders.add(genderF);
		genders.add(genderM);
		return genders;
	}

	@RequestMapping("/showForm.htm")
	public ModelAndView showContactForm(HttpServletRequest request,
			HttpServletResponse response, ModelMap map) throws Exception {

		Contact contact = new Contact();
		map.addAttribute(contact);
		return new ModelAndView("contactForm");
	}

	@RequestMapping("/addContact.htm")
	public ModelAndView addContact(@ModelAttribute("contact") Contact contact)
			throws Exception {

		// will add code here to add data to persistance layer
		// we will get object and return it to display it

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("manageContact");
		modelAndView.addObject("mycontact", contact);
		return modelAndView;
	}

}
