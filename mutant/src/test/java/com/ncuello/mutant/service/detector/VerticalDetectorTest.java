package com.ncuello.mutant.service.detector;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import com.ncuello.mutant.service.detector.VerticalDetector;

@SpringBootTest
public class VerticalDetectorTest {

	@InjectMocks
	private VerticalDetector detector;
	
	@Test
	public void dnaWith2Repetitions() {
		String adnRow0 = "AAAB";
		String adnRow1 = "ZAZB";
		String adnRow2 = "ZAXB";
		String adnRow3 = "ZAZB";
		
		final List<String> adn = new ArrayList<String>();
		adn.add(adnRow0);
		adn.add(adnRow1);
		adn.add(adnRow2);
		adn.add(adnRow3);
		
		Integer quantity = detector.repetitions(adn);
		assertEquals(2, quantity);
	}
	
	@Test
	public void dnaWith0Repetitions() {
		String adnRow0 = "AAAB";
		String adnRow1 = "ZDZX";
		String adnRow2 = "ZAXB";
		String adnRow3 = "ZAZB";
		
		final List<String> adn = new ArrayList<String>();
		adn.add(adnRow0);
		adn.add(adnRow1);
		adn.add(adnRow2);
		adn.add(adnRow3);
		
		Integer quantity = detector.repetitions(adn);
		assertEquals(0, quantity);
	}
	
	@Test
	public void dnaWith2RepetitionsIn8Rows() {
		String adnRow0 = "ZAABERTR";
		String adnRow1 = "ZDZBFDSC";
		String adnRow2 = "WAXBOUTN";
		String adnRow3 = "ZAZBNBNY";
		
		final List<String> adn = new ArrayList<String>();
		adn.add(adnRow0);
		adn.add(adnRow1);
		adn.add(adnRow2);
		adn.add(adnRow3);
		adn.add(adnRow0);
		adn.add(adnRow1);
		adn.add(adnRow2);
		adn.add(adnRow3);
		
		Integer quantity = detector.repetitions(adn);
		assertEquals(2, quantity);
	}
	
	@Test
	public void dnaWith4RepetitionsIn8Rows() {
		String adnRow0 = "ZAABERTR";
		String adnRow1 = "ZDZBFDSC";
		String adnRow2 = "ZAXBOUTN";
		String adnRow3 = "ZAZBNBNY";
		
		final List<String> adn = new ArrayList<String>();
		adn.add(adnRow0);
		adn.add(adnRow1);
		adn.add(adnRow2);
		adn.add(adnRow3);
		adn.add(adnRow0);
		adn.add(adnRow1);
		adn.add(adnRow2);
		adn.add(adnRow3);
		
		Integer quantity = detector.repetitions(adn);
		assertEquals(4, quantity);
	}
}
