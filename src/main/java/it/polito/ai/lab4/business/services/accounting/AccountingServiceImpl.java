package it.polito.ai.lab4.business.services.accounting;

import org.springframework.beans.factory.annotation.Autowired;

public class AccountingServiceImpl implements AccountingService {
	/*@Autowired
	UsersRepository*/
	
	@Override
	public ResultInfo addNewUser(String mail, String nickname, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultInfo addUserProfileInfo(String mail, UserProfileInfo profileInfo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultInfo updateUserProfileInfo(String username, UserProfileInfo profileInfo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserProfileInfo getUserProfileInfo(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultInfo login(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultInfo logout(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultInfo changePassword(String username, String oldPassword, String newPassword,
			String newConfirmedPassword) {
		// TODO Auto-generated method stub
		return null;
	}

}
