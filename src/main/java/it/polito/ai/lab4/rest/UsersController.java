package it.polito.ai.lab4.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.polito.ai.lab4.repo.UserProfilesRepository;
import it.polito.ai.lab4.repo.entities.UserProfile;

@RestController
public class UsersController {
	
	@Autowired
	private UserProfilesRepository usersprofiles;
    
    @RequestMapping("/rest/users")
    public Iterable<UserProfile> usersReturn() {
        return usersprofiles.findAll();
    }
}