package it.polito.ai.lab4.repo;

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
}
