package it.polito.ai.lab4.rest.controllers;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.polito.ai.lab4.business.services.chat.ChatService;
import it.polito.ai.lab4.repo.entities.Topic;

@RestController
public class TopicsController {

	@Autowired
	private ChatService chatService;
    
    @RequestMapping("/rest/topics")
    public Set<Topic> topicsReturn() {
        return chatService.getTopics();
    }
}