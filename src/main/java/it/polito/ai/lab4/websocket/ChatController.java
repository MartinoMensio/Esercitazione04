package it.polito.ai.lab4.websocket;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
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
	public void greeting(SimpMessageHeaderAccessor hs, @DestinationVariable String topicId, WebSocketMessage message) throws Exception {
		// get the userId from the HttpSession
		String sessionId = (String) hs.getSessionAttributes().get("sessionId");
		// TODO get user details (username, picture) from the userService
		ChatMessage craftedMessage = new ChatMessageImpl(new Date(), sessionId, ContentType.TEXT, message.getContent());
		// TODO use chatService and store the message there
		messagingTemplate.convertAndSend("/topic/" + topicId, craftedMessage);
	}

}
