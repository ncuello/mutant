package com.ncuello.mutant.service.detector;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import com.ncuello.mutant.service.detector.DiagonalTopRightDetector;

@SpringBootTest
public class DiagonalTopRightDetectorTest {
	
	@InjectMocks
	private DiagonalTopRightDetector detector;
	
	
	@Test
	public void diagonalWith4Rows() {
		String adnRow0 = "AZAZ";
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
	public void diagonalWith5Rows() {
		String adnRow0 = "AZAZA";
		String adnRow1 = "ZAZAZ";
		
		final List<String> adn = new ArrayList<String>();
		adn.add(adnRow0);
		adn.add(adnRow1);
		adn.add(adnRow0);
		adn.add(adnRow1);
		adn.add(adnRow0);
		
		Integer quantity = detector.repetitions(adn);
		assertEquals(1, quantity);
	}
	
	@Test
	public void diagonalWith8Rows() {
		String adnRow0 = "AZAZAZAZ";
		String adnRow1 = "ZAZAZAZA";
		
		final List<String> adn = new ArrayList<String>();
		adn.add(adnRow0);
		adn.add(adnRow1);
		adn.add(adnRow0);
		adn.add(adnRow1);
		adn.add(adnRow0);
		adn.add(adnRow1);
		adn.add(adnRow0);
		adn.add(adnRow1);
		
		Integer quantity = detector.repetitions(adn);
		assertEquals(4, quantity);
	}
	
	@Test
	public void diagonalWith9Rows() {
		String adnRow0 = "AZAZAZAZA";
		String adnRow1 = "ZAZAZAZAZ";
		
		final List<String> adn = new ArrayList<String>();
		adn.add(adnRow0);
		adn.add(adnRow1);
		adn.add(adnRow0);
		adn.add(adnRow1);
		adn.add(adnRow0);
		adn.add(adnRow1);
		adn.add(adnRow0);
		adn.add(adnRow1);
		adn.add(adnRow0);
		
		Integer quantity = detector.repetitions(adn);
		assertEquals(6, quantity);
	}
}
