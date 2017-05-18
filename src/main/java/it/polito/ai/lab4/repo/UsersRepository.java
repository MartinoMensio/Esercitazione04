package it.polito.ai.lab4.repo;

import java.util.Set;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import it.polito.ai.lab4.repo.entities.User;

public interface UsersRepository extends CrudRepository<User, Long> {
	
	@Modifying
	@Query(value = "INSERT INTO users(nickname, email, password) "
			+ "VALUES (:nickname, :mail, crypt(:password, gen_salt('bf')))", nativeQuery = true)
	public int saveUserWithEncPwd(@Param("nickname") String nickname, @Param("mail") String mail, @Param("password") String password); 
	
	
	User findByEmail(String email);
	
	
	@Modifying
	@Query(value = "UPDATE users "
			+ "SET status_id = 2"
			+ "WHERE email = :email", nativeQuery = true)
	public int enableUser(@Param("email") String email);
	
	@Modifying
	@Query(value = "UPDATE users "
			+ "SET password = crypt(:pwd, gen_salt('bf')) "
			+ "WHERE email = :email", nativeQuery = true)
	public int changeUserPassword(@Param("email") String email, @Param("pwd") String newPassword);
	
	public Set<User> findAll();
}
