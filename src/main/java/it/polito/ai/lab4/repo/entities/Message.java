package it.polito.ai.lab4.repo.entities;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "messages")
public class Message {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "sender_id")
	private User sender;

	private String text;

	private Calendar sendingTime;

	@ManyToOne
	@JoinColumn(name = "topic_id")
	private Topic topic;
	
	public Message() {
	}
	
	public Message(User sender, String text, Calendar sendingTime, Topic topic) {
		this.sender = sender;
		this.text = text;
		this.sendingTime = sendingTime;
		this.topic = topic;
	}

	public Long getId() {
		return id;
	}

	public User getSender() {
		return sender;
	}

	public String getText() {
		return text;
	}

	public Calendar getSendingTime() {
		return sendingTime;
	}

	public Topic getTopic() {
		return topic;
	}

}
