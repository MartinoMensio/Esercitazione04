package it.polito.ai.lab4.repo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="travelDocuments")
public class TravelDocument {
	@Id
	private Long id;
	@Column
	private String name;
	
	/*
	 * TODO
	 * cost, description
	 */
	
	
	public Long getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
}
