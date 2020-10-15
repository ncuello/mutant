package com.ncuello.mutant.service.detector;

import java.util.List;

public abstract class DetectorDna {
	
	private static final Integer MINIMAL_SEQUENCES = 2;
	private static final Integer LENGTH_SEQUENCE = 4;
	
	protected Integer iterationss;
	protected List<String> dna;
	
	
	
	public void initializeDirection(List<String> dna) {
		this.iterationss = dna.size();
		this.dna = dna;
	}

	public Integer repetitions(List<String> dna) {
		Integer sequences = 0;
		Character prevChar;
		Integer charRepeats = 0;
		Integer iterations = dna.size();
		Integer row = 0;
		Integer column = 0;
		
		while(row < iterations) {
			prevChar = dna.get(row).charAt(column);
			
			while(column < iterations) {
				if(prevChar.equals(dna.get(row).charAt(column))) {
					charRepeats++;
				} else {
					charRepeats = 1;
				}
				
				if(charRepeats == LENGTH_SEQUENCE) {
					sequences++;
					charRepeats = 0;
				}
				if(sequences == MINIMAL_SEQUENCES)
					break;
				prevChar = dna.get(row).charAt(column);
				column++;
			}
			if(sequences == MINIMAL_SEQUENCES)
				break;
			
			row++;
			column = 0;
			charRepeats = 0;
		}
		
		
		return sequences;
	}
}
