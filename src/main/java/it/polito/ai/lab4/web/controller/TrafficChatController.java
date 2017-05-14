package it.polito.ai.lab4.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.polito.ai.lab4.business.services.chat.ChatService;
import it.polito.ai.lab4.repo.entities.Topic;

@Controller
@RequestMapping({"/traffic"})
public class TrafficChatController {
	
	@Autowired
	ChatService chatService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String showLogin(ModelMap model){
		model.put("topics", chatService.getTopics());
		// TODO this is only an example, should get the topic from some queryParam
		Topic topic = chatService.getTopicByName("Metro");
		model.put("lastMessages", chatService.getLastMessages(topic, 10));
		return "traffic";
	}
}
