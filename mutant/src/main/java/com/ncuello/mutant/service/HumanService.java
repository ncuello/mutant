package com.ncuello.mutant.service;

import java.util.List;

import com.ncuello.mutant.dto.StatsDTO;

public interface HumanService {
	
	/**
	 * Check if the human is a mutant.
	 * 
	 * @param List<String> dna
	 * @return boolean
	 */
	boolean isMutant(List<String> dna);
	
	/**
	 * Return Stats mutant.
	 * 
	 * @return StatsDTO
	 */
	StatsDTO getStats();

}
