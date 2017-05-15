package it.polito.ai.lab4.web.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import it.polito.ai.lab4.business.services.accounting.AccountingService;
import it.polito.ai.lab4.business.services.accounting.ResultInfo;
import it.polito.ai.lab4.web.controller.forms.RegistrationForm;

@Controller
@RequestMapping({"/registration"})
public class RegistrationController extends AbstractPageWithHeaderController {
	@Autowired
	private AccountingService accountingService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String showRegistration(ModelMap model) {
		super.attachData(model);
		/*RegistrationForm regForm = (RegistrationForm) model.get("regForm");
		if (regForm == null) {
			regForm = new RegistrationForm();
			model.addAttribute("regForm", regForm);
		}*/
		
		model.addAttribute("regForm", new RegistrationForm());
		return "registration";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String doRegistration(@Valid @ModelAttribute("regForm") RegistrationForm registrationForm, BindingResult result, RedirectAttributes ras) {
		// Validate received data
		if(result.hasErrors()) {
			// If there are errors then show again the previous page
			//TODO error management
			return "registration";
		}
		
		ResultInfo res = accountingService.addNewUser(registrationForm.getEmail(), 
							registrationForm.getNickname(), 
							registrationForm.getPassword());
		
		if (res == ResultInfo.REGISTRATION_OK) {
			System.out.println("Reg OK");
			
			ras.addAttribute("username", registrationForm.getNickname());
			return "redirect:registrationResult";
		}
		else if (res == ResultInfo.REGISTRATION_ERR_USERNAME_ALREADY_EXISTS) {
			System.out.println("Username duplicated");
			
			ras.addAttribute("error", "Duplicated username");
			return "redirect:registrationResult";
		}
		else if (res == ResultInfo.REGISTRATION_ERROR) {
			System.out.println("Reg ERR");
			return "redirect:registrationResult";		
		}
		else {
			System.out.println("Unknown ERR");
			return "redirect:registrationResult";
		}
	}
}
