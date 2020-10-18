package com.ncuello.mutant.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ncuello.mutant.model.Human;

public interface HumanRepository extends JpaRepository<Human, Long> {

	/**
	 * Find Human by DNA.
	 * 
	 * @param String dna
	 * @return Human
	 */
	Human findByDna(String dna);
	
	
	/**
	 * Returns number of mutants.
	 * 
	 * @return Long
	 */
	Long countByIsMutantTrue();
}
