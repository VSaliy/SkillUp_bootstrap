package com.packt.ch03.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SearchAnnotController {

	@RequestMapping(value = "/searchFromAnnot.htm")
	public ModelAndView sayHello(@RequestParam("id") int id) {

		// will add code here to search from persistance layer
		// we will get object and return it to display it

		ModelAndView mv = new ModelAndView();
		mv.setViewName("display");
		String message = "Hello " + id;
		mv.addObject("searchObject", message);
		return mv;
	}
}
