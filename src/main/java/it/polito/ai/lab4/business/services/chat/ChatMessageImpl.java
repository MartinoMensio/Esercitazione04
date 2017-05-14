package it.polito.ai.lab4.business.services.chat;

import java.util.Calendar;

import it.polito.ai.lab4.repo.entities.Message;

public class ChatMessageImpl implements ChatMessage {
	private Calendar sendingTime;
	private String userNickname;
	private Object userImage;
	private ContentType contentType;
	private String text;
	private Object image;
	
	
	public ChatMessageImpl(Message message) {
		this.sendingTime = message.getSendingTime();
		this.userNickname = message.getSender().getNickname();
		// TODO check actual type of Message
		this.contentType = ContentType.TEXT;
		this.text = message.getText();
		this.userImage = null;
		this.image = null;
	}

	@Override
	public Calendar getSendingTime() {
		return sendingTime;
	}

	@Override
	public String getUserNickname() {
		return userNickname;
	}

	@Override
	public Object getUserImage() {
		return userImage;
	}

	@Override
	public ContentType getContentType() {
		return contentType;
	}

	@Override
	public String getText() {
		return text;
	}

	@Override
	public Object getImage() {
		return image;
	}
}
