package com.ncuello.mutant.service.detector;

import java.util.List;

import org.springframework.stereotype.Service;

/**
 * Busca coincidencias iniciando en matriz [iterations - 1][1] y avanzando 1 columna y restando 1 fila.
 * Cuando finaliza línea se avanza una unidad en columna y fila arranca en iterations - 1.
 * 
 * @author ncuello
 *
 */

@Service
public class DiagonalTopRightDetector extends DetectorDna {

	Integer initColumn;
	
	@Override
	public void initializeDirection(List<String> dna) {
		super.initializeDirection(dna);
		this.row = iterations - 1;
		this.initColumn = 1;
	}

	@Override
	public boolean existsNextLine() {
		return initColumn < iterations;
	}

	@Override
	public Character getCharInitLine() {
		column = initColumn;
		return dna.get(row).charAt(initColumn);
	}

	@Override
	public boolean existsNextChar() {
		return column < iterations;
	}

	@Override
	public void nextChar() {
		column++;
		row--;
	}

	@Override
	public void nextLine() {
		initColumn++;
		row = iterations - 1;
	}
}
