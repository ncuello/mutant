package com.ncuello.mutant.service.detector;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class VerticalDetector extends DetectorDna {
	
	@Override
	public void initializeDirection(List<String> dna) {
		super.initializeDirection(dna);
		this.row = 0;
		this.column = 0;
	}

	@Override
	public boolean existsNextLine() {
		return column < iterations;
	}

	@Override
	public Character getCharInitLine() {
		return dna.get(row).charAt(column);
	}

	@Override
	public boolean existsNextChar() {
		return row < iterations;
	}

	@Override
	public void nextChar() {
		row++;
	}

	@Override
	public void nextLine() {
		column++;
		row = 0;
	}

}
