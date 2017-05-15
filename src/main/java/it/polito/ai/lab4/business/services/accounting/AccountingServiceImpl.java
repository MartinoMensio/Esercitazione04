package it.polito.ai.lab4.business.services.accounting;

import javax.persistence.RollbackException;

import org.postgresql.util.PSQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.NonTransientDataAccessException;
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
	public UserProfile getUserProfileInfo(String username) {
		User user = usersRepository.findByEmail(username);
		if (user == null)
			return null;
		
		return user.getProfile();
	}

	@Override
	public ResultInfo changePassword(String username, String oldPassword, String newPassword,
			String newConfirmedPassword) {
		// TODO Auto-generated method stub
		return null;
	}

}
