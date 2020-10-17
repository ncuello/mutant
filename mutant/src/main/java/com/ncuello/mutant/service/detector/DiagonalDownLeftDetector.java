package com.ncuello.mutant.service.detector;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class DiagonalDownLeftDetector extends DetectorDna {

	private Integer initRow;
	
	@Override
	public void initializeDirection(List<String> dna) {
		super.initializeDirection(dna);
		this.initRow = 0;
		this.column = 0;
	}
	
	@Override
	public boolean existsNextLine() {
		return initRow < iterations;
	}

	@Override
	public Character getCharInitLine() {
		row = initRow;
		return dna.get(initRow).charAt(column);
	}

	@Override
	public boolean existsNextChar() {
		return row < iterations;
	}

	@Override
	public void nextChar() {
		column++;
		row++;
	}

	@Override
	public void nextLine() {
		initRow++;
		column = 0;
	}
}
