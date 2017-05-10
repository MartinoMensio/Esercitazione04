package it.polito.ai.lab4.repo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="fuels")
public class Fuel {
	@Id
	private Long id;
	@Column
	private String value;
	
	
	public Long getId() {
		return id;
	}
	
	public String getValue() {
		return value;
	}
}
