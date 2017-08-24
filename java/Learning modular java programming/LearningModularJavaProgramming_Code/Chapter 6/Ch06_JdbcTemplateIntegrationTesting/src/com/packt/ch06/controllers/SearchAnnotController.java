package com.packt.ch06.controllers;

import java.util.ArrayList;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.servlet.ModelAndView;


import com.packt.ch06.bussiness.ContactBussiness;
import com.packt.ch06.dao.ContactDAO;
import com.packt.ch06.pojo.Contact;

@Controller
public class SearchAnnotController {
	@Autowired
	ContactBussiness contactBussiness;

	@RequestMapping(value = "/searchFromAnnot.htm")
	public ModelAndView getContcat(@RequestParam("id")String email) {

		// will add code here to search from persistance layer
		// we will get object and return it to display it

		Contact contact=contactBussiness.findContact(email);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("display");
		mv.addObject("contact",contact);
		return mv;
	}
	
	@RequestMapping("/showRecords.htm")
	public ModelAndView showAllContacts(ModelMap map)
	{
		List<Contact>contacts=contactBussiness.findAllContcats();		
		if(contacts.size()>0)
		{
			map.addAttribute("myList",contacts);
			return new ModelAndView("showContacts");
		}
		return new ModelAndView("error");
	}

	
	
}
