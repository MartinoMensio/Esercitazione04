package it.polito.ai.lab4.business.services.chat;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ChatServiceImpl implements ChatService {
	/*@Autowired
	MessageRpository*/
	
	@Override
	public List<ChatMessage> getLastMessages(String topic, int lastMessages) {
		// TODO Auto-generated method stub
		return null;
	}

}
