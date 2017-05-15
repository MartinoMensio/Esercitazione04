package it.polito.ai.lab4.web.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import it.polito.ai.lab4.business.services.accounting.AccountingService;
import it.polito.ai.lab4.web.controller.forms.RegistrationForm;

@Controller
@RequestMapping({"/registration"})
public class RegistrationController extends AbstractPageWithHeaderController {
	@Autowired
	private AccountingService accountingService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String showRegistration(ModelMap model) {
		super.attachData(model);
		RegistrationForm regForm = (RegistrationForm) model.get("regForm");
		if (regForm == null) {
			regForm = new RegistrationForm();
			model.addAttribute("regForm", regForm);
		}
		
		//model.addAttribute("regForm", new RegistrationForm());
		return "registration";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String doRegistration(@Valid @ModelAttribute("regForm") RegistrationForm registrationForm, BindingResult result, RedirectAttributes ras) {
		/* Validate received data.
		 * If there are errors then show again the previous page.
		 */
		if(result.hasErrors()) {
			return "redirect:registration";
		}
		
		try {
			accountingService.addNewUser(registrationForm.getEmail(), 
							registrationForm.getNickname(), 
							registrationForm.getPassword());
		}
		catch (DataIntegrityViolationException e) {
			ras.addAttribute("error", "Duplicated username");
			return "redirect:registrationResult";
		}
		catch (Exception e) {
			ras.addAttribute("error", "Unknown error");
			return "redirect:registrationResult";
		}
		
		ras.addAttribute("username", registrationForm.getNickname());
		return "redirect:registrationResult";
	}
}
