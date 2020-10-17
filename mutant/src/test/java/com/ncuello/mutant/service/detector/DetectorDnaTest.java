package com.ncuello.mutant.service.detector;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ncuello.mutant.service.HumanServiceImpl;

@SpringBootTest
public class DetectorDnaTest {
	
	@Autowired
	private HumanServiceImpl service;
	
	@Test
	public void diagonals2Detector() {
		String adnRow0 = "ACCA";
		String adnRow1 = "CAAC";
		String adnRow2 = "CAAC";
		String adnRow3 = "ACCA";
		
		final List<String> adn = new ArrayList<String>();
		adn.add(adnRow0);
		adn.add(adnRow1);
		adn.add(adnRow2);
		adn.add(adnRow3);
		
		Integer repetitions = service.repetitions(adn);
		
		assertEquals(2, repetitions);
	}
	
	@Test
	public void horizontal1Vertical2Detector() {
		String adnRow0 = "AAAA";
		String adnRow1 = "CAAC";
		String adnRow2 = "CAAC";
		String adnRow3 = "TAAT";
		
		final List<String> adn = new ArrayList<String>();
		adn.add(adnRow0);
		adn.add(adnRow1);
		adn.add(adnRow2);
		adn.add(adnRow3);
		
		Integer repetitions = service.repetitions(adn);
		
		assertEquals(3, repetitions);
	}
}
