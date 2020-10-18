package com.ncuello.mutant.service.detector;

import java.util.List;

public interface Direction {

	/**
	 * Initialize start column and row.
	 * 
	 * @param List<String> dna
	 */
	void initializeDirection(List<String> dna);
	
	/**
	 * Check if there is next line in which to find sequence.
	 * 
	 * @return boolean
	 */
	boolean existsNextLine();
	
	/**
	 * Check if there is next character on the line.
	 * 
	 * @return boolean
	 */
	boolean existsNextChar();
	
	/**
	 * Get char init line.
	 * 
	 * @return Character
	 */
	Character getCharInitLine();
	
	
	/**
	 * Get current Char.
	 * 
	 * @return Character
	 */
	Character getCurrentChar();

	/**
	 * Advance to the next character.
	 */
	void nextChar();
	
	/**
	 * Advance to the next line.
	 */
	void nextLine();
}
