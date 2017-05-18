package it.polito.ai.lab4.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.polito.ai.lab4.business.services.users.UsersService;
import it.polito.ai.lab4.rest.entities.AnonymizedUser;

@RestController
public class UsersController {
	
	@Autowired
	private UsersService usersService;
    
    @RequestMapping("/rest/users")
    public Page<AnonymizedUser> usersReturn(Pageable pageable) {
        return usersService.findAllUsers(pageable).map(u -> new AnonymizedUser(u)); 
} 
}