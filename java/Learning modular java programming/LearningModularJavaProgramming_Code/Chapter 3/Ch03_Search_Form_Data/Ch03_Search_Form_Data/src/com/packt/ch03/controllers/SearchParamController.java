package com.packt.ch03.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SearchParamController {
	@RequestMapping(value="/searchFromRequest.htm")
  	public ModelAndView sayHello(HttpServletRequest request)
	{
		String name=request.getParameter("id");
		
		//will add code here to search from persistance layer
		//we will get object and return it to display it
		
		ModelAndView mv=new ModelAndView();
		mv.setViewName("display");
		String message="Hello "+ name;
		mv.addObject("searchObject",message);
		return mv;
	}

}
