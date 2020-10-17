package com.ncuello.mutant.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StatsDTO {
	
	@JsonProperty("count_mutant_dna")
	private Long countMutant = 0L;
	
	@JsonProperty("count_human_dna")
	private Long countHuman = 0L;
	
	private Double ratio = 0.0;
	
	public StatsDTO() {
		super();
	}

	public StatsDTO(Long countMutant, Long countHuman, Double ratio) {
		super();
		this.countMutant = countMutant;
		this.countHuman = countHuman;
		this.ratio = ratio;
	}

	public Long getCountMutant() {
		return countMutant;
	}

	public void setCountMutant(Long countMutant) {
		this.countMutant = countMutant;
	}

	public Long getCountHuman() {
		return countHuman;
	}

	public void setCountHuman(Long countHuman) {
		this.countHuman = countHuman;
	}

	public Double getRatio() {
		return ratio;
	}

	public void setRatio(Double ratio) {
		this.ratio = ratio;
	}

	@Override
	public String toString() {
		return "StatsDTO [countMutant=" + countMutant + ", countHuman=" + countHuman + ", ratio=" + ratio + "]";
	}
}
