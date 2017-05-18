package it.polito.ai.lab4.web.controller;

import java.io.IOException;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import it.polito.ai.lab4.business.services.authentication.CurrentUserService;
import it.polito.ai.lab4.business.services.images.ImagesService;
import it.polito.ai.lab4.repo.entities.Image;
import it.polito.ai.lab4.repo.entities.User;
import it.polito.ai.lab4.repo.entities.UserProfile;

@Controller
public class ImagesController {

	@Autowired
	ImagesService imagesService;
	
	@Autowired
	CurrentUserService currentUserService;

	@GetMapping("/images/{id}")
	public void getImage(@PathVariable("id") Long imageId, HttpServletResponse response) {
		Image image = imagesService.getImage(imageId);
		byte[] imageBytes = image.getValue();

		response.setContentType("image/jpeg");

		try {
			ServletOutputStream responseOutputStream = response.getOutputStream();
			responseOutputStream.write(imageBytes);
			responseOutputStream.flush();
			responseOutputStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@PostMapping("/setProfileImage")
	public String setProfileImage(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
		if (file.isEmpty()) {
			// TODO handle that
			return "redirect:/fileEmpty";
		}
		
		User user = currentUserService.getCurrentUser();
		if (user == null) {
			// TODO
			return "redirect:/nouser";
		}
		UserProfile userProfile = user.getProfile();
		if (userProfile == null) {
			// this should not be possible because profile must be complete
			return "redirect:/incomplete";
		}

		try {
			byte[] bytes = file.getBytes();

			imagesService.saveUserImage(userProfile, bytes);

			redirectAttributes.addFlashAttribute("message",
					"You successfully uploaded '" + file.getOriginalFilename() + "'");

		} catch (IOException e) {
			// TODO handle that
			e.printStackTrace();
		}

		// TODO handle that
		return "redirect:/";
	}
}
