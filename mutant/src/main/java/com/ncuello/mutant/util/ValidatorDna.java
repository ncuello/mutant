package com.ncuello.mutant.util;

import java.util.List;

public class ValidatorDna {
	
	public static void validate(List<String> dna) {
		Integer rowQuantity = dna.size();
		
		boolean dnaCorrect = dna.parallelStream().allMatch(row -> 
			row.matches("^[ACTGactg]+$") && rowQuantity.equals(row.length()));
		
		if (!dnaCorrect)
			throw new RuntimeException("Wrong structure");
	}

		
}
