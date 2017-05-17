package it.polito.ai.lab4.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.polito.ai.lab4.business.services.chat.ChatMessage;
import it.polito.ai.lab4.business.services.chat.ChatService;
import it.polito.ai.lab4.repo.entities.Topic;

@RestController
public class MessagesController {

	@Autowired
	private ChatService chatService;
    
    @RequestMapping("/rest/messages")
    public List<ChatMessage> messagesReturn(Topic topic, int lastMessages) {
        return chatService.getLastMessages(topic, lastMessages);
    }
}