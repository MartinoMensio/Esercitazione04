package it.polito.ai.lab4.business.services.chat;

import java.util.List;

public interface ChatService {
	
	/**
	 * Return the last messages for the specified topic.
	 * 
	 * @param topic - the requested topic
	 * @param lastMessages - the amount of requested messages
	 * @return the list of requested messages
	 */
	public List<ChatMessage> getLastMessages(String topic, int lastMessages);
}
