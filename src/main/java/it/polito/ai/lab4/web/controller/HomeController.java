package it.polito.ai.lab4.web.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping({"/", "/home", "/index"})
public class HomeController{
	
	@RequestMapping(method = RequestMethod.GET)
	public String showHomePage(Principal principal) {
		if(principal!=null){
			return "home/homeSignedIn";
		}
		return "home/homeNotSignedIn";
	}
	

}
