package com.ncuello.mutant.util;

import java.util.List;

public class ValidatorDna {
	
	private static final String CORRECT_CHARACTERS = "^[ACTG]+$";
	
	/**
	 * Valid long columns and rows are equal and valid characters.
	 * 
	 * @param dna
	 */
	public static void validate(List<String> dna) {
		Integer rowQuantity = dna.size();
		
		boolean dnaCorrect = dna.parallelStream().allMatch(row -> 
			row.matches(CORRECT_CHARACTERS) && rowQuantity.equals(row.length()));
		
		if (!dnaCorrect)
			throw new RuntimeException("Wrong structure");
	}

		
}
