package com.ncuello.mutant.service.detector;

import java.util.List;

public interface Direction {

	void initializeDirection(List<String> dna);
	
	boolean existsNextLine();
	
	boolean existsNextChar();
	
	Character getCharInitLine();
	
	Character getCurrentChar();

	void nextChar();
	
	void nextLine();
}
