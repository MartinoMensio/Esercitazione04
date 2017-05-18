package it.polito.ai.lab4.rest.resources;

import org.springframework.hateoas.ResourceSupport;

import it.polito.ai.lab4.business.services.chat.ChatMessage;

public class ChatMessageResource extends ResourceSupport{
	
	public String text;
	
	public ChatMessageResource(ChatMessage chatMessage) {
		this.text = chatMessage.getText();
	}

}
