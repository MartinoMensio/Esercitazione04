package it.polito.ai.lab4.web.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
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
import it.polito.ai.lab4.web.controller.forms.ProfileFormTest;

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
			model.addAttribute("profileFormTest", new ProfileFormTest());
		}
		else {
			model.addAttribute("profileFormTest", new ProfileFormTest(userProfile));
		}
		
		model.addAttribute("fuels", fuels.findAll());
		model.addAttribute("eduLevels", educationLevels.findAll());
		model.addAttribute("employments", employments.findAll());
		model.addAttribute("carSharingServices", carSharingServices.findAll());
		model.addAttribute("travelDocs", travelDocs.findAll());
		
		return "updateProfile";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String submitForm(@Valid @ModelAttribute("profileFormTest") ProfileFormTest profileFormTest, BindingResult result, ModelMap model) {
		
		if (result.hasErrors()) {
			//TODO check errors
			System.out.println("Errori");
		}
		
		// Create the userProfile object from the form. It is just a conversion
		UserProfile userProfile = profileFormToUserProfile(profileFormTest);
		
		// Save the user profile data
		accountingService.addUserProfileInfo(currentUserService.getCurrentUser().getEmail(), userProfile);
		
		return "redirect:home";
	}
	
	private UserProfile profileFormToUserProfile(ProfileFormTest profileForm) {
		UserProfile userProfile = new UserProfile();
		
		userProfile.setSex(profileForm.getSex());
		userProfile.setDateOfBirth(profileForm.getDateOfBirth());
		
		userProfile.setEducationLevel(profileForm.getEducationLevel());
		userProfile.setEmployment(profileForm.getEmployment());
		                                                                           
		userProfile.setPrivateCarOwnership(profileForm.getPrivateCarOwnership());
		userProfile.setCarRegistrationYear(profileForm.getCarRegistrationYear());
		userProfile.setCarFuel(profileForm.getCarFuel());
		                                                                           
		userProfile.setCarSharingUsage(profileForm.getCarSharingUsage());
		userProfile.setCarSharingService(profileForm.getCarSharingService());
		                                                                           
		userProfile.setBikeUsage(profileForm.getBikeUsage());
		userProfile.setPrivateBikeUsage(profileForm.getPrivateBikeUsage());
		userProfile.setBikeSharingUsage(profileForm.getBikeSharingUsage());
		                                                                   
		userProfile.setPublicTransportUsage(profileForm.getPublicTransportUsage());
		userProfile.setHabitualTravelDocument(profileForm.getHabitualTravelDocument());
		
		return userProfile;
	}
}
