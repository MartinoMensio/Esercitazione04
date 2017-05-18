package it.polito.ai.lab4.business.services.accounting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCrypt;
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
	public User addUserProfileInfo(String email, UserProfile userProfile) {
		User user = usersRepository.findByEmail(email);
		user.setProfile(userProfile);
	
		usersRepository.save(user);
		usersRepository.enableUser(email);
		
		return user;
	}

	@Override
	@PreAuthorize("hasRole('ROLE_USER')")
	public ResultInfo updateUserProfileInfo(String username, UserProfileInfo userProfile) {
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
	public ResultInfo changePassword(String email, String oldPassword, String newPassword,
			String newConfirmedPassword) {
		
		/* Check if the new password is equal to the confirmed password.
		 * If not return error.
		 */
		if (newPassword.equals(newConfirmedPassword) == false) {
			return ResultInfo.PASSWORD_CHANGE_FAILED;
		}
		
		// Get the user data from the DB
		User user = usersRepository.findByEmail(email);
		
		/*
		 * Check if the old inserted password is equal to the stored password
		 * If not return error
		 */
		if (BCrypt.checkpw(oldPassword, user.getPassword()) == false) {
			return ResultInfo.PASSWORD_CHANGE_FAILED;
		}
		
		// Store the new password into the DB
		usersRepository.changeUserPassword(email, newPassword);

		return ResultInfo.PASSWORD_CHANGE_OK;
	}

}
