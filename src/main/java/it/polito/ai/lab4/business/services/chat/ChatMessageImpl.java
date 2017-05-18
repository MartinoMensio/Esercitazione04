package it.polito.ai.lab4.business.services.chat;

import java.util.Calendar;

import it.polito.ai.lab4.repo.entities.Image;
import it.polito.ai.lab4.repo.entities.Message;
import it.polito.ai.lab4.repo.entities.UserProfile;

public class ChatMessageImpl implements ChatMessage {
	private Calendar sendingTime;
	private long userId;
	private String userNickname;
	private String userImageUrl;
	private String text;
	private String imageUrl;
	
	
	public ChatMessageImpl(Message message) {
		this.sendingTime = message.getSendingTime();
		this.userId = message.getSender().getId();
		this.userNickname = message.getSender().getNickname();
		this.text = message.getText();
		
		UserProfile userProfile = message.getSender().getProfile();
		if (userProfile != null) {
			Image profileImage = userProfile.getImage();
			if (profileImage != null) {
				this.userImageUrl = "/images/" + profileImage.getId();
			}
		}
		Image messageImage = message.getImage();
		if (messageImage != null) {
			// build the link to the image
			this.imageUrl = "/images/" + message.getImage().getId();
		}
	}

	@Override
	public Calendar getSendingTime() {
		return sendingTime;
	}
	
	@Override
	public long getUserId() {
		return userId;
	}

	@Override
	public String getUserNickname() {
		return userNickname;
	}

	@Override
	public String getUserImageUrl() {
		return userImageUrl;
	}

	@Override
	public String getText() {
		return text;
	}

	@Override
	public String getImageUrl() {
		return imageUrl;
	}
}
