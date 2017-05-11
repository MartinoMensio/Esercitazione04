package it.polito.ai.lab4.repo;

import org.springframework.data.repository.CrudRepository;

import it.polito.ai.lab4.repo.entities.User;

public interface UsersRepository extends CrudRepository<User, Long> {
	User findByEmail(String email);
}
