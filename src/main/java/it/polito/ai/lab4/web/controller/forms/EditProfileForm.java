package it.polito.ai.lab4.web.controller.forms;

import javax.validation.constraints.NotNull;

import it.polito.ai.lab4.business.services.accounting.UserProfileInfo;
import it.polito.ai.lab4.repo.entities.UserProfile;

public class EditProfileForm {
	@NotNull
	private UserProfile userProfile;
	
	//TODO This should be removed later, now used because the interface is implemented with this class
	@NotNull
	private UserProfileInfo userProfileInfo;
	
	public UserProfileInfo getUserProfileInfo() {
		return userProfileInfo;
	}

	public void setUserProfileInfo(UserProfileInfo userProfileInfo) {
		this.userProfileInfo = userProfileInfo;
	}

	@NotNull
	private String nickname;

	public String getNickname() {
		return nickname;
	}
	
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public UserProfile getUserProfile() {
		return userProfile;
	}
	
	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}


}
