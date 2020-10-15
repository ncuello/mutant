package com.ncuello.mutant.service.detector;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class DiagonalTopRightDetector extends DetectorDna {

	private static final Integer MINIMAL_SEQUENCES = 2;
	private static final Integer LENGTH_SEQUENCE = 4;
	
	@Override
	public Integer repetitions(List<String> dna) {
		
		Integer sequences = 0;
		Character prevChar;
		Integer charRepeats = 0;
		Integer totalRow = dna.size();
		Integer row = totalRow - 1;
		Integer column = 1;
		Integer initColumn = 1;
		
		while(initColumn < totalRow) {
			prevChar = dna.get(row).charAt(initColumn);
			column = initColumn;
			while(column < totalRow) {
				if(prevChar.equals(dna.get(row).charAt(column))) {
					charRepeats++;
				} else {
					charRepeats = 1;
				}
				
				if(charRepeats == LENGTH_SEQUENCE) {
					sequences++;
					charRepeats = 0;
				}
//				if(sequences == MINIMAL_SEQUENCES)
//					break;
				prevChar = dna.get(row).charAt(column);
				column++;
				row--;
			}
//			if(sequences == MINIMAL_SEQUENCES)
//				break;
			
			initColumn++;
			row = totalRow - 1;
			charRepeats = 0;
		}
		
		return sequences;
	}
}
