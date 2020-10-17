package com.ncuello.mutant.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "Humans")
public class Human {
	
	@GeneratedValue
	@Id
	private Long id;
	
	@Column(length = 1000)
	private String dna;
	
	@Column(name = "is_mutant")
	private Boolean isMutant;
	
	public Human() {
		super();
	}
	public Human(Long id, String dna, Boolean isMutant) {
		super();
		this.id = id;
		this.dna = dna;
		this.isMutant = isMutant;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDna() {
		return dna;
	}
	public void setDna(String dna) {
		this.dna = dna;
	}
	public Boolean isMutant() {
		return isMutant;
	}
	public void setIsMutant(Boolean isMutant) {
		this.isMutant = isMutant;
	}
}
