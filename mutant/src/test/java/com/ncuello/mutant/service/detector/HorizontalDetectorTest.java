package com.ncuello.mutant.service.detector;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import com.ncuello.mutant.service.detector.HorizontalDetector;

@SpringBootTest
public class HorizontalDetectorTest {
	
	@InjectMocks
	private HorizontalDetector detector;
	
	@Test
	public void dnaWith2Repetitions() {
		String adnRow0 = "AAAA";
		String adnRow1 = "ZAZA";
		
		final List<String> adn = new ArrayList<String>();
		adn.add(adnRow0);
		adn.add(adnRow1);
		adn.add(adnRow0);
		adn.add(adnRow1);
		
		Integer quantity = detector.repetitions(adn);
		assertEquals(2, quantity);
	}
	
	@Test
	public void dnaWith0Repetitions() {
		String adnRow0 = "AACA";
		String adnRow1 = "ZAZA";
		
		final List<String> adn = new ArrayList<String>();
		adn.add(adnRow0);
		adn.add(adnRow1);
		adn.add(adnRow0);
		adn.add(adnRow1);
		
		Integer quantity = detector.repetitions(adn);
		assertEquals(0, quantity);
	}
	
	@Test
	public void dnaWith2RepetitionsIn8Rows() {
		String adnRow0 = "AAAAAAAA";
		String adnRow1 = "ZAZAZAZA";
		
		final List<String> adn = new ArrayList<String>();
		adn.add(adnRow0);
		adn.add(adnRow1);
		adn.add(adnRow1);
		adn.add(adnRow1);
		adn.add(adnRow1);
		adn.add(adnRow1);
		adn.add(adnRow1);
		adn.add(adnRow1);
		
		Integer quantity = detector.repetitions(adn);
		assertEquals(2, quantity);
	}
}
