package it.polito.ai.lab4.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.polito.ai.lab4.business.services.accounting.AccountingService;

@Controller
@RequestMapping({"/updateProfile"})
public class UpdateProfileController extends AbstractPageWithHeaderController {
	@Autowired
	private AccountingService accountingService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String showForm(ModelMap model) {
		super.attachData(model);
		
		return "updateProfile";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String submitForm(ModelMap model) {
		accountingService.addUserProfileInfo(currentUserService.getCurrentUser().getEmail(), null);
		return "redirect:home";
	}
}
