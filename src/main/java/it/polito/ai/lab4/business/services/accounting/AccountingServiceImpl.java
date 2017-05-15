package it.polito.ai.lab4.business.services.accounting;

import javax.persistence.RollbackException;

import org.postgresql.util.PSQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.NonTransientDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.polito.ai.lab4.repo.UsersRepository;
import it.polito.ai.lab4.repo.entities.User;

@Service
@Transactional
public class AccountingServiceImpl implements AccountingService {
	@Autowired
	private UsersRepository usersRepository;
	
	@Override
	@Transactional(rollbackFor = {Throwable.class})
	public ResultInfo addNewUser(String mail, String nickname, String password) {
		User newUser = new User(nickname, mail, password);
		
		// save the new user into the DB
		try {
			usersRepository.saveUserWithEncPwd(nickname, mail, password);
			
			//newUser = usersRepository.save(newUser);
		}
		catch (DataIntegrityViolationException e) {
			return ResultInfo.REGISTRATION_ERR_USERNAME_ALREADY_EXISTS;
		}
		/*catch (DataIntegrityViolationException e) {
			e.printStackTrace();
			return ResultInfo.REGISTRATION_ERR_USERNAME_ALREADY_EXISTS;
		}*/
		//catch (Exception e) {
			//e.printStackTrace();
			//return ResultInfo.REGISTRATION_ERROR;
		//}
		
		
		return ResultInfo.REGISTRATION_OK;
		// TODO Auto-generated method stub
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
