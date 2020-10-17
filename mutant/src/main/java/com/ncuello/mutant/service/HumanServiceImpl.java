package com.ncuello.mutant.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ncuello.mutant.dto.StatsDTO;
import com.ncuello.mutant.model.Human;
import com.ncuello.mutant.repository.HumanRepository;
import com.ncuello.mutant.service.detector.DetectorDna;
import com.ncuello.mutant.util.ValidatorDna;

@Service
public class HumanServiceImpl implements HumanService {
	
	private static final Logger log = LoggerFactory.getLogger(HumanServiceImpl.class);
	
	private static final Integer MINIMAL_SEQUENCES = 2;
	
	@Autowired
	private HumanRepository repository;
	
	@Autowired
	private List<DetectorDna> detectors;

	@Override
	public boolean isMutant(List<String> dna) {

		ValidatorDna.validate(dna);
		
		log.info("Find by dna");
		Human human = repository.findByDna(dna.toString());
		
		if(human != null) {
			log.info("Human exists in database.");
			return human.isMutant();
		}
		
		Integer sequences = repetitions(dna);
		boolean isMutant = sequences >= MINIMAL_SEQUENCES;
		log.info("Sequences= " + sequences);
		
		human = new Human();
		human.setDna(dna.toString());
		human.setIsMutant(isMutant);
		
		human = repository.save(human);
		log.info("Human created");
		log.info("Id: " + human.getId());
		log.info("Dna" + human.getDna());
		log.info("Human is mutant? " + human.isMutant());
		
		return isMutant;
	}

	@Override
	public StatsDTO getStats() {
		Long countHuman = repository.count();
		if(countHuman > 0) {
			Long countMutant = repository.countByIsMutantTrue();
			
			BigDecimal bdHuman = BigDecimal.valueOf(countHuman);
			BigDecimal bdMutant = BigDecimal.valueOf(countMutant);
			
			Double ratio = bdMutant.divide(bdHuman, 2, RoundingMode.CEILING).doubleValue();
			
			StatsDTO stats = new StatsDTO(countMutant, countHuman, ratio);
			return stats;
		}
		return new StatsDTO();
	}
	
	public Integer repetitions(List<String> dna) {
		return detectors.parallelStream().mapToInt(d -> d.repetitions(dna)).sum();
	}
	
}
