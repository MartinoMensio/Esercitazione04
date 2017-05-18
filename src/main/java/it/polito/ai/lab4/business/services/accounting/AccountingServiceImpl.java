package it.polito.ai.lab4.business.services.accounting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.polito.ai.lab4.repo.UserProfilesRepository;
import it.polito.ai.lab4.repo.UsersRepository;
import it.polito.ai.lab4.repo.entities.User;
import it.polito.ai.lab4.repo.entities.UserProfile;

@Service
@Transactional
public class AccountingServiceImpl implements AccountingService {
	@Autowired
	private UsersRepository usersRepository;
	@Autowired
	private UserProfilesRepository usersProfileRepository;
	
	@Override
	public User addNewUser(String mail, String nickname, String password) {
		usersRepository.saveUserWithEncPwd(nickname, mail, password);
		return usersRepository.findByEmail(mail);
	}

	@Override
	@PreAuthorize("hasRole('ROLE_USER')")
	public ResultInfo addUserProfileInfo(String mail, UserProfileInfo profileInfo) {
		// TODO Auto-generated method stub
		usersRepository.enableUser(mail);
		
		return null;
	}

	@Override
	@PreAuthorize("hasRole('ROLE_USER')")
	public ResultInfo updateUserProfileInfo(String username, UserProfileInfo profileInfo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserProfile getUserProfileInfo(String username) {
		User user = usersRepository.findByEmail(username);
		if (user == null)
			return null;
		
		return user.getProfile();
	}

	@Override
	@PreAuthorize("hasRole('ROLE_USER')")
	public ResultInfo changePassword(String username, String oldPassword, String newPassword,
			String newConfirmedPassword) {
		// TODO Auto-generated method stub
		return null;
	}

}
