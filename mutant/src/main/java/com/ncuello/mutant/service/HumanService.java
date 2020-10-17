package com.ncuello.mutant.service;

import java.util.List;

import com.ncuello.mutant.dto.StatsDTO;

public interface HumanService {
	
	boolean isMutant(List<String> dna);
	
	StatsDTO getStats();

}
