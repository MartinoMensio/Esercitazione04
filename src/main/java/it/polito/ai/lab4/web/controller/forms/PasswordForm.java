package it.polito.ai.lab4.web.controller.forms;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class PasswordForm {
	@NotNull
	@Size(min=8)
	private String oldPassword;
	@NotNull
	@Size(min=8)
	private String newPassword;
	@NotNull
	@Size(min=8)
	private String confirmedPassword;
	
	
	public String getOldPassword() {
		return oldPassword;
	}
	
	public String getNewPassword() {
		return newPassword;
	}
	
	public String getConfirmedPassword() {
		return confirmedPassword;
	}
}
