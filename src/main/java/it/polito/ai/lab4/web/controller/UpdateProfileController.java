package it.polito.ai.lab4.web.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.polito.ai.lab4.business.services.accounting.AccountingService;
import it.polito.ai.lab4.repo.CarSharingServicesRepository;
import it.polito.ai.lab4.repo.EducationLevelsRepository;
import it.polito.ai.lab4.repo.EmploymentsRepository;
import it.polito.ai.lab4.repo.FuelsRepository;
import it.polito.ai.lab4.repo.TravelDocumentsRepository;
import it.polito.ai.lab4.repo.entities.UserProfile;
import it.polito.ai.lab4.web.controller.forms.ProfileForm;

@Controller
@RequestMapping({"/updateProfile"})
public class UpdateProfileController extends AbstractPageWithHeaderController {
	@Autowired
	private AccountingService accountingService;
	@Autowired
	private EducationLevelsRepository educationLevels;
	@Autowired
	private EmploymentsRepository employments;
	@Autowired
	private FuelsRepository fuels;
	@Autowired
	private CarSharingServicesRepository carSharingServices;
	@Autowired
	private TravelDocumentsRepository travelDocs;
	
	
	@RequestMapping(method = RequestMethod.GET)
	public String showForm(ModelMap model) {
		super.attachData(model);
		
		UserProfile userProfile = currentUserService.getCurrentUser().getProfile();
		if (userProfile == null ) {
			model.addAttribute("profileForm", new ProfileForm());
		}
		else {
			model.addAttribute("profileForm", new ProfileForm(userProfile));
		}
		
		model.addAttribute("fuels", fuels.findAll());
		model.addAttribute("eduLevels", educationLevels.findAll());
		model.addAttribute("employments", employments.findAll());
		model.addAttribute("carSharingServices", carSharingServices.findAll());
		model.addAttribute("travelDocs", travelDocs.findAll());
		
		return "updateProfile";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String submitForm(@Valid @ModelAttribute("profileForm") ProfileForm profileFormTest, BindingResult result, ModelMap model) {
		
		if (!result.getFieldValue("carRegistrationYear").equals("") && result.hasErrors()) {
			System.out.println("Errori");
			return "redirect:updateProfile";
		}
		
		// Create the userProfile object from the form. It is just a conversion
		UserProfile userProfile = profileFormToUserProfile(profileFormTest);
		
		// Save the user profile data
		accountingService.addUserProfileInfo(currentUserService.getCurrentUser().getEmail(), userProfile);
		
		return "redirect:profile";
	}
	
	private UserProfile profileFormToUserProfile(ProfileForm profileForm) {
		UserProfile userProfile = new UserProfile();
		
		userProfile.setSex(profileForm.getSex());
		userProfile.setDateOfBirth(profileForm.getDateOfBirth());
		
		userProfile.setEducationLevel(profileForm.getEducationLevel());
		userProfile.setEmployment(profileForm.getEmployment());
		                                                                           
		userProfile.setPrivateCarOwnership(profileForm.getPrivateCarOwnership());
		if (userProfile.getPrivateCarOwnership() == true) {
			userProfile.setCarRegistrationYear(profileForm.getCarRegistrationYear());
			userProfile.setCarFuel(profileForm.getCarFuel());
		}
		else {
			userProfile.setCarRegistrationYear(null);
			userProfile.setCarFuel(null);
		}
		                                                                  
		userProfile.setCarSharingUsage(profileForm.getCarSharingUsage());
		if (userProfile.getCarSharingUsage() == true) {
			userProfile.setCarSharingService(profileForm.getCarSharingService());
		}
		else {
			userProfile.setCarSharingService(null);
		}
		                                                                       
		userProfile.setBikeUsage(profileForm.getBikeUsage());
		if (userProfile.getBikeUsage() == true) {
			userProfile.setPrivateBikeUsage(profileForm.getPrivateBikeUsage());
			userProfile.setBikeSharingUsage(profileForm.getBikeSharingUsage());
		}
		else {
			userProfile.setPrivateBikeUsage(null);
			userProfile.setBikeSharingUsage(null);
		}
		
		userProfile.setPublicTransportUsage(profileForm.getPublicTransportUsage());
		if (userProfile.getPublicTransportUsage() == true) {
			userProfile.setHabitualTravelDocument(profileForm.getHabitualTravelDocument());
		}
		else {
			userProfile.setHabitualTravelDocument(null);
		}
		
		return userProfile;
	}
}
