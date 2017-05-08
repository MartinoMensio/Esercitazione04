package it.polito.ai.lab4.websocket;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import it.polito.ai.lab4.business.services.chat.ChatMessage;
import it.polito.ai.lab4.business.services.chat.ChatMessageImpl;
import it.polito.ai.lab4.business.services.chat.ContentType;

@Controller
public class ChatController {

	// interface towards the broker
	@Autowired
	private SimpMessagingTemplate messagingTemplate;

	@MessageMapping("/{topicId}")
	@SendTo("/topic/greetings")
	public void greeting(@DestinationVariable String topicId, WebSocketMessage message) throws Exception {
		Thread.sleep(1000); // simulated delay
		// TODO use message class that implements Alessio's interface
		ChatMessage craftedMessage = new ChatMessageImpl(new Date(), "TODO_username", ContentType.TEXT, message.getContent());
		messagingTemplate.convertAndSend("/topic/" + topicId, craftedMessage);
	}

}
