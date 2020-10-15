package com.ncuello.mutant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ncuello.mutant.model.Human;
import com.ncuello.mutant.repository.HumanRepository;
import com.ncuello.mutant.service.detector.DetectorDna;
import com.ncuello.mutant.util.ValidatorDna;

@Service
public class HumanServiceImpl implements HumanService {
	
	@Autowired
	private HumanRepository repository;
	
	@Autowired
	private List<DetectorDna> detectors;

	@Override
	public boolean isMutant(List<String> dna) {

		ValidatorDna.validate(dna);
		
		Human human = repository.findByDna(dna.toString());
		
		if(human != null) {
			return human.isMutant();
		}
		
		Integer sequences = detectors.parallelStream().mapToInt(d -> d.repetitions(dna)).sum();
		
		System.out.println("Sequences " + sequences);
		
		Human humanCreated = new Human();
		humanCreated.setDna(dna.toString());
		humanCreated.setIsMutant(sequences >= 2);
		
		humanCreated = repository.save(humanCreated);
		
		System.out.println("id: " + humanCreated.getId());
		System.out.println("dna" + humanCreated.getDna());
		System.out.println("es mutante? " + humanCreated.isMutant());
		
		
		return sequences >= 2;
	}
}
