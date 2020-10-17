package com.ncuello.mutant.service.detector;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import com.ncuello.mutant.service.detector.DiagonalTopLeftDetector;

@SpringBootTest
public class DiagonalTopLeftDetectorTest {

	@InjectMocks
	private DiagonalTopLeftDetector detector;
	
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
		assertEquals(6, quantity);
	}
	
}
