package it.polito.ai.lab4.repo;

import org.springframework.data.repository.CrudRepository;

import it.polito.ai.lab4.repo.entities.Fuel;

public interface FuelsRepository extends CrudRepository<Fuel, Long> {

}
