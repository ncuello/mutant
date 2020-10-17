package com.ncuello.mutant.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ncuello.mutant.model.Human;

public interface HumanRepository extends JpaRepository<Human, Long> {

	Human findByDna(String dna);
	
	Long countByIsMutantTrue();
}
