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
import it.polito.ai.lab4.repo.entities.User;
import it.polito.ai.lab4.web.controller.forms.EditProfileForm;

@Controller
@RequestMapping({"/editProfile"})
public class EditProfileController extends AbstractPageWithHeaderController {
	@Autowired
	private AccountingService accountingService;

	@RequestMapping(method = RequestMethod.GET)
	public String showForm(ModelMap model) {
		super.attachData(model);
		
		// Get the current user
		User currentUser = currentUserService.getCurrentUser();

		// Get the current data of the user logged in
		model.addAttribute("userProfile", currentUser.getProfile());
		
		// Used to manage the form in editProfile.html
		model.addAttribute("profForm", new EditProfileForm());

		return "editProfile";
	}

	// When data are inserted in the form this method will update the informations in the database
	@RequestMapping(method = RequestMethod.POST)
	public String doEditProfile(@Valid @ModelAttribute("profForm") EditProfileForm editProfileForm, BindingResult result, RedirectAttributes ras) {
		// Check if there are any errors in result
		if(result.hasErrors()) {
			return "redirect:editProfile";
		}

		try {
			// TODO probably UserProfileInfo interface will be removed...
			accountingService.updateUserProfileInfo(editProfileForm.getNickname(), editProfileForm.getUserProfileInfo());
			//better to use something like this, this method DOESN'T EXIST YET.
			//accountingService.updateUserProfile(editProfileForm.getNickname(), editProfileForm.getUserProfile());

		}
		catch (Exception e) {
			ras.addAttribute("error", "Unknown error");
			return "redirect:profile";
		}

		// TODO check if some attributes need to be added
		//ras.addAttribute("username", editProfileForm.getNickname());
		return "redirect:profile";
	}


}
