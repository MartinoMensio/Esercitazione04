package it.polito.ai.lab4.rest;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.polito.ai.lab4.repo.UsersRepository;
import it.polito.ai.lab4.rest.users.AnonymizedUser;

@RestController
public class UsersController {
	
	@Autowired
	private UsersRepository usersRepository;
    
    @RequestMapping("/rest/users")
    public Set<AnonymizedUser> usersReturn() { 
        return usersRepository.findAll().stream().map(u -> new AnonymizedUser(u)).collect(Collectors.toSet()); 
} 
}