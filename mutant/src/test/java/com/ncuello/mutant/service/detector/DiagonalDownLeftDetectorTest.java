package com.ncuello.mutant.service.detector;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import com.ncuello.mutant.service.detector.DiagonalDownLeftDetector;

@SpringBootTest
public class DiagonalDownLeftDetectorTest {
	
	@InjectMocks
	private DiagonalDownLeftDetector detector;
	
	@Test
	public void diagonalWith8Rows() {
		String adnRow0 = "AZAZAZAZ";
		String adnRow1 = "ZAZAZAZA";
		
		final List<String> dna = new ArrayList<String>();
		dna.add(adnRow0);
		dna.add(adnRow1);
		dna.add(adnRow0);
		dna.add(adnRow1);
		dna.add(adnRow0);
		dna.add(adnRow1);
		dna.add(adnRow0);
		dna.add(adnRow1);
		
		Integer quantity = detector.repetitions(dna);
		
		assertEquals(6, quantity);
	}
	
	@Test
	public void diagonalWith4Rows() {
		String adnRow0 = "AZAZ";
		String adnRow1 = "ZAZA";
		
		final List<String> dna = new ArrayList<String>();
		dna.add(adnRow0);
		dna.add(adnRow1);
		dna.add(adnRow0);
		dna.add(adnRow1);
		
		Integer quantity = detector.repetitions(dna);
		
		assertEquals(1, quantity);
	}

	
}
