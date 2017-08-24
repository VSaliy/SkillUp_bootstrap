package com.packt.ch02.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	@RequestMapping(value="/hello.htm",method=RequestMethod.GET)
  	public ModelAndView sayHello(HttpServletRequest request)
	{
		String name=request.getParameter("name");
		ModelAndView mv=new ModelAndView();
		mv.setViewName("hello");
		String message="Hello "+name +" From Spring";
		mv.addObject("message",message);
		return mv;
	}

}
