package com.ncuello.mutant.service.detector;

import java.util.List;

import org.springframework.stereotype.Service;

/**
 * Busca coincidencias iniciando en matriz [0][1] y avanzando 1 columna y 1 fila.
 * Cuando finaliza línea se avanza una unidad en columna y fila arranca en 0.
 * 
 * @author ncuello
 *
 */

@Service
public class DiagonalDownRightDetector extends DetectorDna {

	private Integer initColumn;
	
	@Override
	public void initializeDirection(List<String> dna) {
		super.initializeDirection(dna);
		this.row = 0;
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
		row++;
	}

	@Override
	public void nextLine() {
		initColumn++;
		row = 0;
	}
}
