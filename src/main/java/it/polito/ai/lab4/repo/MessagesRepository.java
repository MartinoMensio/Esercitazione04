package it.polito.ai.lab4.repo;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import it.polito.ai.lab4.repo.entities.Message;
import it.polito.ai.lab4.repo.entities.Topic;

public interface MessagesRepository extends CrudRepository<Message, Long>{
	public List<Message> findByTopic(Topic topic, Pageable pageable);
}
