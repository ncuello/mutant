package com.ncuello.mutant.service.detector;

import java.util.List;

import org.springframework.stereotype.Service;

/**
 * Busca coincidencias iniciando en matriz [0][0] y avanzando 1 columna.
 * Cuando finaliza línea se retrocede una unidad en fila y columna arranca en 0. 
 * 
 * @author ncuello
 *
 */

@Service
public class HorizontalDetector extends DetectorDna {

	@Override
	public void initializeDirection(List<String> dna) {
		super.initializeDirection(dna);
		this.row = 0;
		this.column = 0;
	}

	@Override
	public boolean existsNextLine() {
		return row < iterations;
	}

	@Override
	public Character getCharInitLine() {
		return dna.get(row).charAt(column);
	}

	@Override
	public boolean existsNextChar() {
		return column < iterations;
	}

	@Override
	public void nextChar() {
		column++;
	}

	@Override
	public void nextLine() {
		row++;
		column = 0;
	}

}
