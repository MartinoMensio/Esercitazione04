package it.polito.ai.lab4.repo;

import org.springframework.data.repository.CrudRepository;

import it.polito.ai.lab4.repo.entities.Message;

public interface MessagesRepository extends CrudRepository<Message, Long>{

}
