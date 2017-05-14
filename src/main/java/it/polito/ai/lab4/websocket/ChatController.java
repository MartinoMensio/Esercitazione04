package it.polito.ai.lab4.websocket;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import it.polito.ai.lab4.business.services.authentication.CurrentUserService;
import it.polito.ai.lab4.repo.entities.Message;
import it.polito.ai.lab4.repo.entities.User;

@Controller
public class ChatController {

	// interface towards the broker
	@Autowired
	private SimpMessagingTemplate messagingTemplate;

	@Autowired
	private CurrentUserService currentUserService;

	@MessageMapping("/{topicId}")
	public void greeting(SimpMessageHeaderAccessor hs, @DestinationVariable String topicId, WebSocketMessage message) throws Exception {
		User sender = currentUserService.getCurrentUser();
		if (sender != null) {
			Message craftedMessage = new Message(sender, message.getContent(), Calendar.getInstance());
			// TODO use chatService and store the message there
			messagingTemplate.convertAndSend("/topic/" + topicId, craftedMessage);
		} else {
			// should never be there because the endpoint requires authentication
			System.err.println("Message from unknown user!!");
		}
	}

}
