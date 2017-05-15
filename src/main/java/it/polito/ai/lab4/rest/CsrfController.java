package it.polito.ai.lab4.rest;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.polito.ai.lab4.business.services.chat.ChatService;
import it.polito.ai.lab4.repo.entities.Topic;

@RestController
public class CsrfController {

	@Autowired
	private ChatService chatService;
	
	
	/**
	 * Returns the csrf token for connecting to the secured WebSocket
	 * @param token
	 * @return
	 */
    @RequestMapping("/rest/csrf")
    public CsrfToken csrf(CsrfToken token) {
        return token;
    }
    
    @RequestMapping("/rest/topics")
    public Set<Topic> topicsReturn() {
        return chatService.getTopics();
    }
}