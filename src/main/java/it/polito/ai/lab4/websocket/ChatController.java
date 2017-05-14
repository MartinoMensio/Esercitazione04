package it.polito.ai.lab4.websocket;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import it.polito.ai.lab4.business.services.authentication.CurrentUserService;
import it.polito.ai.lab4.business.services.chat.ChatMessage;
import it.polito.ai.lab4.business.services.chat.ChatMessageImpl;
import it.polito.ai.lab4.business.services.chat.ChatService;
import it.polito.ai.lab4.repo.entities.Message;
import it.polito.ai.lab4.repo.entities.Topic;
import it.polito.ai.lab4.repo.entities.User;

@Controller
public class ChatController {

	// interface towards the broker
	@Autowired
	private SimpMessagingTemplate messagingTemplate;

	@Autowired
	private CurrentUserService currentUserService;

	@Autowired
	ChatService chatService;

	@MessageMapping("/{topicId}")
	public void handleMessage(SimpMessageHeaderAccessor hs, @DestinationVariable String topicId, WebSocketMessage webSocketMessage) throws Exception {
		User sender = currentUserService.getCurrentUser();
		if (sender != null) {
			Topic topic = chatService.getTopicByName(topicId);
			if (topic != null) {
				Message messageEntity = new Message(sender, webSocketMessage.getContent(), Calendar.getInstance(), topic);
				// TODO use chatService and store the message there
				ChatMessage chatMessage = new ChatMessageImpl(messageEntity);
				messagingTemplate.convertAndSend("/topic/" + topic.getValue(), chatMessage);
			} else {
				// inexistent topic
				System.err.println("Inexistent topic " + topicId);
			}
		} else {
			// should never be there because the endpoint requires
			// authentication
			System.err.println("Message from unknown user!!");
		}
	}

}
