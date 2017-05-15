package it.polito.ai.lab4.web.controller.forms;

import javax.validation.constraints.NotNull;

public class RegistrationForm {
	@NotNull
	//TODO add email constraint
	private String email;
	@NotNull
	private String nickname;
	@NotNull
	// TODO add pwd constraints
	private String password;
	
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getNickname() {
		return nickname;
	}
	
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
}
