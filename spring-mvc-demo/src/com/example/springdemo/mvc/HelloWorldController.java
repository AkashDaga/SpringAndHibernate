package com.example.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("hello")
public class HelloWorldController {
	
	// need a controller method to show initial HTML form
	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}
	
	//need a controller method to process the HTML form
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}
	
	// new controller method to read form data and add data to model
	@RequestMapping("/processFormVersionTwo")
	public String letsShoutDude(HttpServletRequest httpServletRequest, Model model) {
		// read  the request params from the HTML form i.e. form request parameters
		String name = httpServletRequest.getParameter("studentName");
		// convert the data in all upperCase
		name = name.toUpperCase();
		// create the message
		String message = "Yo! "+ name;
		// add the message to the models
		model.addAttribute("message",message);
		return "helloworld";
	}
	
	// new controller method to read form data and add data to model
	@RequestMapping("/processFormVersionThree")
	public String processFormVesrionThree(@RequestParam("studentName") String name, Model model) {
		// convert the data in all upperCase
		name = name.toUpperCase();
		// create the message
		String message = "Yo! "+ name+" holla, wassup";
		// add the message to the models
		model.addAttribute("message",message);
		return "helloworld";
	}

}
