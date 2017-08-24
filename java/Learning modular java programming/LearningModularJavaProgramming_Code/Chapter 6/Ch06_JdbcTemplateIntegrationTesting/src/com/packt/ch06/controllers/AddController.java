package com.packt.ch06.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.packt.ch06.bussiness.ContactBussiness;
import com.packt.ch06.dao.ContactDAO;
import com.packt.ch06.pojo.Contact;
import com.packt.ch06.pojo.Gender;

@Controller
public class AddController {
	@Autowired
	ContactBussiness contactBussiness;

	public void setContactBussiness(ContactBussiness contactBussiness) {
		this.contactBussiness = contactBussiness;
	}

	@ModelAttribute("genderList")
	public List<Gender> addGenders() {
		List<Gender> genders = new ArrayList<Gender>();
		Gender genderF = new Gender();
		genderF.setId(1);
		genderF.setValue("F");

		Gender genderM = new Gender();
		genderM.setId(1);
		genderM.setValue("M");

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
	public ModelAndView addContact(
			@Valid @ModelAttribute("contact") Contact contact,
			BindingResult result) throws Exception {
		if (result.hasErrors()) {
			return new ModelAndView("contactForm");
		} else {
			System.out.println("method invoked");
			int record = contactBussiness.addContact(contact);
			if (record > 0) {
				System.out.println("you inserted record");
				return new ModelAndView("manageContact", "id",
						contact.getEmail());
			}
		}
		return new ModelAndView("contactForm","error","Data Cannot be inserted Email is already registered");
	}

}
