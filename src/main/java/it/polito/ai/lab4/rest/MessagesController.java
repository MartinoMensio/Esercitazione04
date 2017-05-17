package it.polito.ai.lab4.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.polito.ai.lab4.business.services.chat.ChatMessage;
import it.polito.ai.lab4.business.services.chat.ChatService;
import it.polito.ai.lab4.repo.entities.Topic;

@RestController
public class MessagesController {

	@Autowired
	private ChatService chatService;
    
    @RequestMapping("/rest/messages/{topicName}")

    public Page<ChatMessage> messagesReturn(@PathVariable("topicName") String topicName, Pageable pageable) {
    	Topic topic = chatService.getTopicByName(topicName);
        return chatService.findByTopic(topic, pageable);
    }
}