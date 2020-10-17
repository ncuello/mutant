package com.ncuello.mutant.service.detector;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class DiagonalTopLeftDetector extends DetectorDna {
	
	private Integer initRow;
	
	@Override
	public void initializeDirection(List<String> dna) {
		super.initializeDirection(dna);
		this.initRow = iterations - 1;
		this.column = 0;
	}

	@Override
	public boolean existsNextLine() {
		return initRow >= 0;
	}

	@Override
	public Character getCharInitLine() {
		row = initRow;
		return dna.get(initRow).charAt(column);
	}

	@Override
	public boolean existsNextChar() {
		return row >= 0;
	}

	@Override
	public void nextChar() {
		column++;
		row--;
	}

	@Override
	public void nextLine() {
		initRow--;
		column = 0;
	}
	
}
