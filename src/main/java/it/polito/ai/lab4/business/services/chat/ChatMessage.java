package it.polito.ai.lab4.business.services.chat;

import java.util.Date;

public interface ChatMessage {
	
	/**
	 * Return the date on which the message has been sent.
	 * 
	 * @return a Date object
	 */
	public Date getDate();
	
	/**
	 * Return the nickname of the user that has sent the message.
	 * 
	 * @return a String object
	 */
	public String getUserNickname();
	
	/**
	 * Return the user's profile message 
	 * 
	 * @return // TODO should be an Image object
	 */
	public Object getUserImage();
	
	/**
	 * Return the content type of the message.
	 * 
	 * @return an enumeration of type ContenType. It can be:
	 * 			<ul>
	 * 				<li>TEXT: the content is a string</li>
	 * 				<li>IMAGE: the content is an image</li>
	 * 			</ul>
	 */
	public ContentType getContentType();
	
	/**
	 * If the content type is TEXT then it returns the contained
	 * text message otherwise null.
	 * 
	 * @return a String object
	 */
	public String getText();
	
	/**
	 * If the content type is IMAGE then it returns the contained
	 * image otherwise null.
	 * 
	 * @return // TODO should be an Image object
	 */
	public Object getImage();
}
