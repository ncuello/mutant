package com.ncuello.mutant.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ncuello.mutant.dto.HumanDTO;
import com.ncuello.mutant.dto.StatsDTO;
import com.ncuello.mutant.service.HumanService;

@RestController
public class HumanController {
	
	private static final Logger log = LoggerFactory.getLogger(HumanController.class);
	
	@Autowired
	private HumanService service;

	@PostMapping("/mutant")
	public ResponseEntity<String> register(@RequestBody HumanDTO mutant){
		try {
			boolean isMutant = service.isMutant(mutant.getDna());
			
			if(isMutant) {
				return ResponseEntity.ok().build();
			} else {
				return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
			}
		} catch (Exception e) {
			log.error(e.getMessage());
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/stats")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public StatsDTO stats() {
		StatsDTO stats = service.getStats();
		log.info(stats.toString());
		return stats;
	}
	
}
