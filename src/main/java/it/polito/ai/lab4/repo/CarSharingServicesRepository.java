package it.polito.ai.lab4.repo;

import org.springframework.data.repository.CrudRepository;

import it.polito.ai.lab4.repo.entities.CarSharingService;

public interface CarSharingServicesRepository extends CrudRepository<CarSharingService, Long> {

}
