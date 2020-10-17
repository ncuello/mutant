package com.ncuello.mutant.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ValidatorDnaTest {

	@Test
	public void dnaIncorrect4Rows2Columns() {
		String adnRow0 = "AA";
		
		final List<String> adn = new ArrayList<String>();
		adn.add(adnRow0);
		adn.add(adnRow0);
		adn.add(adnRow0);
		adn.add(adnRow0);
		
		RuntimeException exception = assertThrows(
				RuntimeException.class, 
				() -> ValidatorDna.validate(adn)
		);

		String expectedMessage = "Wrong structure";
		
		assertEquals(expectedMessage, exception.getMessage());
	}
	
	@Test
	public void dnaWithWrongLetters() {
		String adnRow0 = "ACTW";
		
		final List<String> adn = new ArrayList<String>();
		adn.add(adnRow0);
		adn.add(adnRow0);
		adn.add(adnRow0);
		adn.add(adnRow0);
		
		RuntimeException exception = assertThrows(
				RuntimeException.class, 
				() -> ValidatorDna.validate(adn)
		);

		String expectedMessage = "Wrong structure";
		
		assertEquals(expectedMessage, exception.getMessage());
	}
	
	@Test
	public void dnaCorrect() {
		String adnRow0 = "ACTG";
		
		final List<String> adn = new ArrayList<String>();
		adn.add(adnRow0);
		adn.add(adnRow0);
		adn.add(adnRow0);
		adn.add(adnRow0);
		
		ValidatorDna.validate(adn);
	}
}
