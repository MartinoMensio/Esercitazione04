package it.polito.ai.lab4.repo;

import org.springframework.data.repository.CrudRepository;

import it.polito.ai.lab4.repo.entities.Employment;

public interface EmploymentsRepository extends CrudRepository<Employment, Long> {

}
