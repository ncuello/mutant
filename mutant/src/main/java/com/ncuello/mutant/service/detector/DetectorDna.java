package com.ncuello.mutant.service.detector;

import java.util.List;

public abstract class DetectorDna implements Direction {
	
	private static final Integer MINIMAL_SEQUENCES = 2;
	private static final Integer LENGTH_SEQUENCE = 4;
	
	protected Integer iterations;
	protected List<String> dna;
	protected Integer row;
	protected Integer column;
	
	@Override
	public void initializeDirection(List<String> dna) {
		this.iterations = dna.size();
		this.dna = dna;
	}

	public Integer repetitions(List<String> dna) {
		initializeDirection(dna);
		Integer sequences = 0;
		Character prevChar;
		Integer charRepeats = 0;
		
		while(existsNextLine()) {
			prevChar = getCharInitLine();
			while(existsNextChar()) {
				if(prevChar.equals(getCurrentChar())) {
					charRepeats++;
				} else {
					charRepeats = 1;
				}
				
				if(charRepeats == LENGTH_SEQUENCE) {
					sequences++;
					charRepeats = 0;
				}
				
				// Dejé comentado lo siguiente para realizar los tests 
				//	y calcule la cantidad exacta de repeticiones, 
				//	pero hace mas performante la búsqueda. Y evita seguir buscando si
				//	ya encontró 2 repeticiones.
//				if(sequences >= MINIMAL_SEQUENCES) {
//					return sequences;
//				}
				prevChar = getCurrentChar();
				nextChar();
			}
			nextLine();
			charRepeats = 0;
		}
		
		return sequences;
	}
	
	@Override
	public Character getCurrentChar() {
		return dna.get(row).charAt(column);
	}
	
}
