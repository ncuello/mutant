package com.ncuello.mutant.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ncuello.mutant.dto.StatsDTO;
import com.ncuello.mutant.model.Human;
import com.ncuello.mutant.repository.HumanRepository;

@SpringBootTest
public class HumanServiceTest {
	
	@InjectMocks
	private HumanServiceImpl serviceMock;
	
	@Autowired
	private HumanService service;

    @Mock
    private HumanRepository repository;
    
	@Test
	public void ratioStats() {
		when(repository.count()).thenReturn(100L);
        // mutant dna count
        when(repository.countByIsMutantTrue()).thenReturn(45L);
        
        StatsDTO stats = serviceMock.getStats();
        
        assertEquals(0.45, stats.getRatio());
	}
	
	@Test
	public void ratioStatsWithoutHumans() {
		when(repository.count()).thenReturn(0L);
        // mutant dna count
        when(repository.countByIsMutantTrue()).thenReturn(0L);
        
        StatsDTO stats = serviceMock.getStats();
        
        assertEquals(0.0, stats.getRatio());
	}
	
	@Test
	public void notMutantInDatabase() {
		
		String adnRow0 = "AAAC";
		String adnRow1 = "GATC";
		String adnRow2 = "GAGC";
		String adnRow3 = "GATC";
		
		final List<String> adn = new ArrayList<String>();
		adn.add(adnRow0);
		adn.add(adnRow1);
		adn.add(adnRow2);
		adn.add(adnRow3);
		
		Human human = new Human(1L, adn.toString(), false);
		
		when(repository.findByDna(adn.toString())).thenReturn(human);
        
        boolean isMutant = serviceMock.isMutant(adn);
        
        assertFalse(isMutant);
	}
	
	@Test
	public void mutantInDatabase() {
		
		String adnRow0 = "AAAC";
		String adnRow1 = "GATC";
		String adnRow2 = "GAGC";
		String adnRow3 = "GATC";
		
		final List<String> adn = new ArrayList<String>();
		adn.add(adnRow0);
		adn.add(adnRow1);
		adn.add(adnRow2);
		adn.add(adnRow3);
		
		Human human = new Human(1L, adn.toString(), true);
		
		when(repository.findByDna(adn.toString())).thenReturn(human);
        
        boolean isMutant = serviceMock.isMutant(adn);
        
        assertTrue(isMutant);
	}
	
	@Test
	public void notMutantCalculate() {
		
		String adnRow0 = "AAAC";
		String adnRow1 = "GATC";
		String adnRow2 = "GTGT";
		String adnRow3 = "GATC";
		
		final List<String> adn = new ArrayList<String>();
		adn.add(adnRow0);
		adn.add(adnRow1);
		adn.add(adnRow2);
		adn.add(adnRow3);
		
        boolean isMutant = service.isMutant(adn);
        
        assertFalse(isMutant);
	}
	
	@Test
	public void mutantCalculate() {
		
		String adnRow0 = "GAAC";
		String adnRow1 = "GGTC";
		String adnRow2 = "GTGT";
		String adnRow3 = "GATG";
		
		final List<String> adn = new ArrayList<String>();
		adn.add(adnRow0);
		adn.add(adnRow1);
		adn.add(adnRow2);
		adn.add(adnRow3);
		
        boolean isMutant = service.isMutant(adn);
        
        assertTrue(isMutant);
	}

}
