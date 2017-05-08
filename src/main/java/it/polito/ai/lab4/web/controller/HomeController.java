package it.polito.ai.lab4.web.controller;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.thymeleaf.ITemplateEngine;

@Controller
@RequestMapping({"/", "/home", "/index"})
public class HomeController implements ChatToController {

	@Override
	public void process(final HttpServletRequest request, final HttpServletResponse response,
			final ServletContext servletContext, final ITemplateEngine templateEngine) throws Exception {
		
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String showHomePage(ModelMap model) {
		return "home";
	}
	

}
