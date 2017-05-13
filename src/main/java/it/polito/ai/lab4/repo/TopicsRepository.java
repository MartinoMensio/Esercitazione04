package it.polito.ai.lab4.repo;

import org.springframework.data.repository.CrudRepository;

import it.polito.ai.lab4.repo.entities.Topic;

public interface TopicsRepository extends CrudRepository<Topic, Long> {

}
