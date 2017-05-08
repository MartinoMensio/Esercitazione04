package it.polito.ai.lab4.business.services.chat;

import java.util.Date;

public class ChatMessageImpl implements ChatMessage {
	private Date date;
	private String userNickname;
	private Object userImage;
	private ContentType contentType;
	private String text;
	private Object image;
	
	
	public ChatMessageImpl(Date date, String userNickname, ContentType contentType, String text) {
		this.date = date;
		this.userNickname = userNickname;
		this.contentType = contentType;
		this.text = text;
		
		this.userImage = null;
		this.image = null;
	}

	public ChatMessageImpl(Date date, String userNickname, Object userImage, ContentType contentType, String text,
			Object image) {
		this.date = date;
		this.userNickname = userNickname;
		this.userImage = userImage;
		this.contentType = contentType;
		this.text = text;
		this.image = image;
	}

	@Override
	public Date getDate() {
		return date;
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
