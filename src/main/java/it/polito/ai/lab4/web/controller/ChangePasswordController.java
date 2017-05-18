package it.polito.ai.lab4.web.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.polito.ai.lab4.web.controller.forms.PasswordForm;

@Controller
@RequestMapping({"/changePassword"})
public class ChangePasswordController {

	@RequestMapping(method = RequestMethod.POST)
	public String submitForm(@Valid @ModelAttribute("passwordForm") PasswordForm passwordForm, BindingResult result, ModelMap model) {
		
		if (result.hasErrors()) {
			//TODO check errors
			System.out.println("Errori");
			return "redirect:updateProfile";
		}
		
		
		
		return "redirect:profile";
	}
}
