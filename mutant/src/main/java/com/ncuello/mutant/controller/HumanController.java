package com.ncuello.mutant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ncuello.mutant.dto.HumanDTO;
import com.ncuello.mutant.service.HumanService;

@RestController
public class HumanController {
	
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
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
}
