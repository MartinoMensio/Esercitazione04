package it.polito.ai.lab4.web.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.polito.ai.lab4.business.services.accounting.AccountingService;
import it.polito.ai.lab4.repo.entities.UserProfile;
import it.polito.ai.lab4.web.controller.forms.ProfileFormTest;

@Controller
@RequestMapping({"/updateProfile"})
public class UpdateProfileController extends AbstractPageWithHeaderController {
	@Autowired
	private AccountingService accountingService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String showForm(ModelMap model) {
		super.attachData(model);
		
		UserProfile userProfile = currentUserService.getCurrentUser().getProfile();
		if (userProfile == null ) {
			model.addAttribute("profileFormTest", new ProfileFormTest());
		}
		else {
			model.addAttribute("profileFormTest", new ProfileFormTest(userProfile));
		}
		
		return "updateProfile";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String submitForm(@Valid @ModelAttribute("profileFormTest") ProfileFormTest profileFormTest, BindingResult result, ModelMap model) {
		//TODO check errors
		
		accountingService.addUserProfileInfo(currentUserService.getCurrentUser().getEmail(), null);
		return "redirect:home";
	}
}
