package it.polito.ai.lab4.business.services.accounting;

public interface AccountingService {
	
	/**
	 * Register a new user to the service.
	 * 
	 * @param mail - The user's mail. It represents also the user ID (must be unique)
	 * @param nickname - The user's nickname
	 * @param password - The user's password
	 * @return the result status of the registration
	 * 				<ul>
	 * 					<li>Success: ResultInfo.REGISTRATION_OK</li>
	 * 					<li>User already exists: ResultInfo.REGISTRATION_ERR_USERNAME_ALREADY_EXISTS</li>
	 * 					<li>Error: REGISTRATION_ERROR</li>
	 * 				</ul>
	 */
	public ResultInfo addNewUser(String mail, String nickname, String password);
	
	/**
	 * Insert the user's profile details 
	 *  
	 * @param mail - The user Id
	 * @param profileInfo - The object that represents the user's profile info
	 * @return The result of the insertion
	 * 				<ul>
	 * 					<li>Success: ResultInfo.USER_PROFILE_UPDATE_OK</li>
	 * 					<li>Failure: ResultInfo.USER_PROFILE_UPDATE_FAILED</li>
	 * 				</ul>
	 */
	public ResultInfo addUserProfileInfo(String mail, UserProfileInfo profileInfo);
	
	/**
	 * Update the user's profile details 
	 * 
	 * @param username - The user's mail
	 * @param profileInfo - The object that represents the user's profile info
	 * @return The result of the update
	 * 				<ul>
	 * 					<li>Success: ResultInfo.USER_PROFILE_UPDATE_OK</li>
	 * 					<li>Failure: ResultInfo.USER_PROFILE_UPDATE_FAILED</li>
	 * 				</ul>
	 */
	public ResultInfo updateUserProfileInfo(String username, UserProfileInfo profileInfo);
	
	/**
	 * Return the user's profile details
	 * 
	 * @param username - The user's mail
	 * @return an user profile object. If the user does not exist returns null
	 */
	public UserProfileInfo getUserProfileInfo(String username);
	
	/**
	 * Perform the login action checking the validity of the credentials.
	 * 
	 * @param username - The user's mail
	 * @param password
	 * @return - The result of the login
	 * 				<ul>
	 * 					<li>Success: ResultInfo.LOGIN_SUCCESSFUL</li>
	 * 					<li>Failure: ResultInfo.LOGIN_FAILED</li>
	 * 				</ul>
	 */
	public ResultInfo login(String username, String password);
	
	/**
	 * Perform the logout action
	 * 
	 * @param username - The user's mail
	 * @return - The result of the logout
	 */
	public ResultInfo logout(String username);
	
	/**
	 * Update the user's password
	 * 
	 * @param username - The user's mail
	 * @param oldPassword - The old password
	 * @param newPassword - The new password
	 * @param newConfirmedPassword - The new confirmed password, must be equal to newPassword
	 * @return The result of the password change
	 * 				<ul>
	 * 					<li>Success: ResultInfo.PASSWORD_CHANGE_OK</li>
	 * 					<li>Failure: ResultInfo.PASSWORD_CHANGE_FAILED</li>
	 * 				</ul>
	 */
	public ResultInfo changePassword(String username, String oldPassword, String newPassword, String newConfirmedPassword);
}
