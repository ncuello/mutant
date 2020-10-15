package com.ncuello.mutant.service.detector;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class DiagonalTopLeftDetector extends DetectorDna {

	private static final Integer MINIMAL_SEQUENCES = 2;
	private static final Integer LENGTH_SEQUENCE = 4;
	
	@Override
	public Integer repetitions(List<String> dna) {
		
		Integer sequences = 0;
		Character prevChar;
		Integer charRepeats = 0;
		Integer totalRow = dna.size();
		Integer row = totalRow - 1;
		Integer initRow = totalRow - 1;
		Integer column = 0;
		
		while(initRow >= 0) {
			prevChar = dna.get(initRow).charAt(column);
			row = initRow;
			while(row >= 0) {
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
			
			initRow--;
			column = 0;
			charRepeats = 0;
		}
		
		return sequences;
	}
}
