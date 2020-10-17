package com.ncuello.mutant;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ncuello.mutant.dto.StatsDTO;
import com.ncuello.mutant.repository.HumanRepository;
import com.ncuello.mutant.service.HumanService;
import com.ncuello.mutant.service.HumanServiceImpl;
import com.ncuello.mutant.service.detector.DetectorDna;
import com.ncuello.mutant.service.detector.DiagonalDownLeftDetector;
import com.ncuello.mutant.service.detector.DiagonalDownRightDetector;
import com.ncuello.mutant.service.detector.DiagonalTopLeftDetector;
import com.ncuello.mutant.service.detector.DiagonalTopRightDetector;
import com.ncuello.mutant.service.detector.HorizontalDetector;
import com.ncuello.mutant.service.detector.VerticalDetector;
import com.ncuello.mutant.util.ValidatorDna;
import com.ncuello.mutant.util.ValidatorDnaTest;

@SpringBootTest
class MutantApplicationTests {
	
	@Autowired
	private List<DetectorDna> list;
	
	@InjectMocks
	private HumanServiceImpl service;

    @Mock
    private HumanRepository repository;

	@Test
	void contextLoads() {
	}
	
	@Test
	public void dnaCorrect() {
		String adnRow0 = "Ac";
		String adnRow1 = "At";
		
		List<String> adn = new ArrayList<String>();
		adn.add(adnRow0);
		adn.add(adnRow1);
		
		ValidatorDna.validate(adn);
		
	}
	
	@Test
	public void prueba() {
		String adnRow0 = "cctcaaaa";
		String adnRow1 = "cactaaaa";
		String adnRow2 = "cabbaaaa";
		String adnRow3 = "aaaaBaaa";
		String adnRow4 = "cvbbbbsd";
		String adnRow5 = "wesdfdsf";
		String adnRow6 = "wedsfdsd";
		String adnRow7 = "dasdasdq";
		
		List<String> adn = new ArrayList<String>();
		
		adn.add(adnRow0);
		adn.add(adnRow1);
		adn.add(adnRow2);
		adn.add(adnRow3);
		adn.add(adnRow4);
		adn.add(adnRow5);
		adn.add(adnRow6);
		adn.add(adnRow7);
		
		adn = adn.stream().map(row -> row.toUpperCase()).collect(Collectors.toList());
		
		adn.stream().forEach(row -> System.out.println(row));
		
		HorizontalDetector horizontalDetector = new HorizontalDetector();
		
		Integer cantidad = horizontalDetector.repetitions(adn);
		System.out.println(cantidad);
	}
	

	@Test
	public void list() {
		String adnRow0 = "ACTCAAAA";
		String adnRow1 = "AACTAAAA";
		String adnRow2 = "AABBAAAA";
		String adnRow3 = "AAAABAAA";
		String adnRow4 = "SAFAFAFD";
		String adnRow5 = "GDSFGSDF";
		String adnRow6 = "SDFDSDDS";
		String adnRow7 = "SDGSDGSD";
		
		final List<String> adn = new ArrayList<String>();
		adn.add(adnRow0);
		adn.add(adnRow1);
		adn.add(adnRow2);
		adn.add(adnRow3);
		adn.add(adnRow4);
		adn.add(adnRow5);
		adn.add(adnRow6);
		adn.add(adnRow7);
		
		adn.stream().forEach(row -> System.out.println(row));
		list.parallelStream().forEach(row -> System.out.println(row.getClass().getSimpleName() + ": " + row.repetitions(adn)));
	}
	
	@Test
	public void serviceDetector() {
		String adnRow0 = "ACTAAAAA";
		String adnRow1 = "AACTAAAA";
		String adnRow2 = "AAAAAAAA";
		String adnRow3 = "AAAABAAA";
		String adnRow4 = "SAFAFASD";
		String adnRow5 = "GDSFGSDF";
		String adnRow6 = "SDFDSDDS";
		String adnRow7 = "SDGSDGSD";
		
		final List<String> adn = new ArrayList<String>();
		adn.add(adnRow0);
		adn.add(adnRow1);
		adn.add(adnRow2);
		adn.add(adnRow3);
		adn.add(adnRow4);
		adn.add(adnRow5);
		adn.add(adnRow6);
		adn.add(adnRow7);
		
		adn.stream().forEach(row -> System.out.println(row));
		list.parallelStream().forEach(row -> System.out.println(row.getClass().getSimpleName() + ": " + row.repetitions(adn)));
	}
	
	@Test
	public void serviceDetectorStream() {
		String adnRow0 = "ACTAAAAA";
		String adnRow1 = "AACTAAAA";
		String adnRow2 = "AAAAAAAA";
		String adnRow3 = "AAAABAAA";
		String adnRow4 = "SAFAFASD";
		String adnRow5 = "GDSFGSDF";
		String adnRow6 = "SDFDSDDS";
		String adnRow7 = "SDGSDGSD";
		
		final List<String> adn = new ArrayList<String>();
		adn.add(adnRow0);
		adn.add(adnRow1);
		adn.add(adnRow2);
		adn.add(adnRow3);
		adn.add(adnRow4);
		adn.add(adnRow5);
		adn.add(adnRow6);
		adn.add(adnRow7);
		
		adn.stream().forEach(row -> System.out.println(row));
		list.stream().forEach(row -> System.out.println(row.getClass().getSimpleName() + ": " + row.repetitions(adn)));
	}
	
	@Test
	public void vertical() {
		String adnRow0 = "ACDCAAAA";
		String adnRow1 = "AADTAAAA";
		String adnRow2 = "AADBAAAA";
		String adnRow3 = "AADAAAAA";
		String adnRow4 = "SAEAFAFS";
		String adnRow5 = "GDEFGSDF";
		String adnRow6 = "SDEDSFDS";
		String adnRow7 = "SDESDGSD";
		
		final List<String> adn = new ArrayList<String>();
		adn.add(adnRow0);
		adn.add(adnRow1);
		adn.add(adnRow2);
		adn.add(adnRow3);
		adn.add(adnRow4);
		adn.add(adnRow5);
		adn.add(adnRow6);
		adn.add(adnRow7);
		
		adn.stream().forEach(row -> System.out.println(row));
		VerticalDetector verticalDetector = new VerticalDetector();
		
		Integer cantidad = verticalDetector.repetitions(adn);
		System.out.println(cantidad);
	}
	
	@Test
	public void diagonalDownLeft() {
		String adnRow0 = "AZAZAZAZ";
		String adnRow1 = "ZAZAZAZA";
		String adnRow2 = "AZAZAZAZ";
		String adnRow3 = "ZAZAZAZA";
		String adnRow4 = "AZAZAZAZ";
		String adnRow5 = "ZAZAZAZA";
		String adnRow6 = "AZAZAZAZ";
		String adnRow7 = "ZAZAZAZA";
		
		final List<String> adn = new ArrayList<String>();
		adn.add(adnRow0);
		adn.add(adnRow1);
		adn.add(adnRow2);
		adn.add(adnRow3);
		adn.add(adnRow4);
		adn.add(adnRow5);
		adn.add(adnRow6);
		adn.add(adnRow7);
		
		adn.stream().forEach(row -> System.out.println(row));
		
		DiagonalDownLeftDetector diagonal = new DiagonalDownLeftDetector();
		
		Integer cantidad = diagonal.repetitions(adn);
		
		System.out.println(cantidad);
		
//		list.parallelStream().forEach(row -> System.out.println(row.repetitions(adn)));
	}

	@Test
	public void diagonalDownLeftx4() {
		String adnRow0 = "AZAZ";
		String adnRow1 = "ZAZA";
		String adnRow2 = "AZAZ";
		String adnRow3 = "ZAZA";
		
		final List<String> adn = new ArrayList<String>();
		adn.add(adnRow0);
		adn.add(adnRow1);
		adn.add(adnRow2);
		adn.add(adnRow3);
		
		adn.stream().forEach(row -> System.out.println(row));
		
		DiagonalDownLeftDetector diagonal = new DiagonalDownLeftDetector();
		
		Integer cantidad = diagonal.repetitions(adn);
		
		System.out.println(cantidad);
		
//		list.parallelStream().forEach(row -> System.out.println(row.repetitions(adn)));
	}
	
	@Test
	public void diagonalDownRightx5() {
		String adnRow0 = "AZAZA";
		String adnRow1 = "ZAZAZ";
		String adnRow2 = "AZAZA";
		String adnRow3 = "ZAZAZ";
		String adnRow4 = "AZAZA";
		
		final List<String> adn = new ArrayList<String>();
		adn.add(adnRow0);
		adn.add(adnRow1);
		adn.add(adnRow2);
		adn.add(adnRow3);
		adn.add(adnRow4);
		
		adn.stream().forEach(row -> System.out.println(row));
		
		DiagonalDownRightDetector diagonal = new DiagonalDownRightDetector();
		
		Integer cantidad = diagonal.repetitions(adn);
		
		System.out.println(cantidad);
		
//		list.parallelStream().forEach(row -> System.out.println(row.repetitions(adn)));
	}
	
	@Test
	public void diagonalDownRightx8() {
		String adnRow0 = "AZAZAZAZ";
		String adnRow1 = "ZAZAZAZA";
		String adnRow2 = "AZAZAZAZ";
		String adnRow3 = "ZAZAZAZA";
		String adnRow4 = "AZAZAZAZ";
		String adnRow5 = "ZAZAZAZA";
		String adnRow6 = "AZAZAZAZ";
		String adnRow7 = "ZAZAZAZA";
		
		final List<String> adn = new ArrayList<String>();
		adn.add(adnRow0);
		adn.add(adnRow1);
		adn.add(adnRow2);
		adn.add(adnRow3);
		adn.add(adnRow4);
		adn.add(adnRow5);
		adn.add(adnRow6);
		adn.add(adnRow7);
		
		adn.stream().forEach(row -> System.out.println(row));
		
		DiagonalDownRightDetector diagonal = new DiagonalDownRightDetector();
		
		Integer cantidad = diagonal.repetitions(adn);
		
		System.out.println(cantidad);
		
//		list.parallelStream().forEach(row -> System.out.println(row.repetitions(adn)));
	}
	
	@Test
	public void diagonalDownRightx9() {
		String adnRow0 = "AZAZAZAZA";
		String adnRow1 = "ZAZAZAZAZ";
		String adnRow2 = "AZAZAZAZA";
		String adnRow3 = "ZAZAZAZAZ";
		String adnRow4 = "AZAZAZAZA";
		String adnRow5 = "ZAZAZAZAZ";
		String adnRow6 = "AZAZAZAZA";
		String adnRow7 = "ZAZAZAZAZ";
		String adnRow8 = "AZAZAZAZA";
		
		final List<String> adn = new ArrayList<String>();
		adn.add(adnRow0);
		adn.add(adnRow1);
		adn.add(adnRow2);
		adn.add(adnRow3);
		adn.add(adnRow4);
		adn.add(adnRow5);
		adn.add(adnRow6);
		adn.add(adnRow7);
		adn.add(adnRow8);
		
		adn.stream().forEach(row -> System.out.println(row));
		
		DiagonalDownRightDetector diagonal = new DiagonalDownRightDetector();
		
		Integer cantidad = diagonal.repetitions(adn);
		
		System.out.println(cantidad);
		
//		list.parallelStream().forEach(row -> System.out.println(row.repetitions(adn)));
	}
	
	@Test
	public void diagonalTopLeftx4() {
		String adnRow0 = "AZAZ";
		String adnRow1 = "ZAZA";
		String adnRow2 = "AZAZ";
		String adnRow3 = "ZAZA";
		
		final List<String> adn = new ArrayList<String>();
		adn.add(adnRow0);
		adn.add(adnRow1);
		adn.add(adnRow2);
		adn.add(adnRow3);
		
		adn.stream().forEach(row -> System.out.println(row));
		
		DiagonalTopLeftDetector diagonal = new DiagonalTopLeftDetector();
		
		Integer cantidad = diagonal.repetitions(adn);
		
		System.out.println(cantidad);
		
//		list.parallelStream().forEach(row -> System.out.println(row.repetitions(adn)));
	}
	
	@Test
	public void diagonalTopLeftx8() {
		String adnRow0 = "AZAZAZAZ";
		String adnRow1 = "ZAZAZAZA";
		String adnRow2 = "AZAZAZAZ";
		String adnRow3 = "ZAZAZAZA";
		String adnRow4 = "AZAZAZAZ";
		String adnRow5 = "ZAZAZAZA";
		String adnRow6 = "AZAZAZAZ";
		String adnRow7 = "ZAZAZAZA";
		
		final List<String> adn = new ArrayList<String>();
		adn.add(adnRow0);
		adn.add(adnRow1);
		adn.add(adnRow2);
		adn.add(adnRow3);
		adn.add(adnRow4);
		adn.add(adnRow5);
		adn.add(adnRow6);
		adn.add(adnRow7);
		
		adn.stream().forEach(row -> System.out.println(row));
		
		DiagonalTopLeftDetector diagonal = new DiagonalTopLeftDetector();
		
		Integer cantidad = diagonal.repetitions(adn);
		
		System.out.println(cantidad);
		
//		//		list.parallelStream().forEach(row -> System.out.println(row.repetitions(adn)));
	}
	
	@Test
	public void diagonalTopRightx5() {
		String adnRow0 = "AZAZA";
		String adnRow1 = "ZAZAZ";
		String adnRow2 = "AZAZA";
		String adnRow3 = "ZAZAZ";
		String adnRow4 = "AZAZA";
		
		final List<String> adn = new ArrayList<String>();
		adn.add(adnRow0);
		adn.add(adnRow1);
		adn.add(adnRow2);
		adn.add(adnRow3);
		adn.add(adnRow4);
		
		adn.stream().forEach(row -> System.out.println(row));
		
		DiagonalTopRightDetector diagonal = new DiagonalTopRightDetector();
		
		Integer cantidad = diagonal.repetitions(adn);
		
		System.out.println(cantidad);
		
//		list.parallelStream().forEach(row -> System.out.println(row.repetitions(adn)));
	}
	
	@Test
	public void diagonalTopRightx8() {
		String adnRow0 = "AZAZAZAZ";
		String adnRow1 = "ZAZAZAZA";
		String adnRow2 = "AZAZAZAZ";
		String adnRow3 = "ZAZAZAZA";
		String adnRow4 = "AZAZAZAZ";
		String adnRow5 = "ZAZAZAZA";
		String adnRow6 = "AZAZAZAZ";
		String adnRow7 = "ZAZAZAZA";
		
		final List<String> adn = new ArrayList<String>();
		adn.add(adnRow0);
		adn.add(adnRow1);
		adn.add(adnRow2);
		adn.add(adnRow3);
		adn.add(adnRow4);
		adn.add(adnRow5);
		adn.add(adnRow6);
		adn.add(adnRow7);
		
		adn.stream().forEach(row -> System.out.println(row));
		
		DiagonalTopRightDetector diagonal = new DiagonalTopRightDetector();
		
		Integer cantidad = diagonal.repetitions(adn);
		
		System.out.println(cantidad);
		
//		list.parallelStream().forEach(row -> System.out.println(row.repetitions(adn)));
	}
	
	@Test
	public void diagonalTopRightx9() {
		String adnRow0 = "AZAZAZAZA";
		String adnRow1 = "ZAZAZAZAZ";
		String adnRow2 = "AZAZAZAZA";
		String adnRow3 = "ZAZAZAZAZ";
		String adnRow4 = "AZAZAZAZA";
		String adnRow5 = "ZAZAAZAZA";
		String adnRow6 = "AZAZAZAZA";
		String adnRow7 = "ZAZAZAZAZ";
		String adnRow8 = "AZAZAZAZA";
		
		final List<String> adn = new ArrayList<String>();
		adn.add(adnRow0);
		adn.add(adnRow1);
		adn.add(adnRow2);
		adn.add(adnRow3);
		adn.add(adnRow4);
		adn.add(adnRow5);
		adn.add(adnRow6);
		adn.add(adnRow7);
		adn.add(adnRow8);
		
		adn.stream().forEach(row -> System.out.println(row));
		
		DiagonalTopRightDetector diagonal = new DiagonalTopRightDetector();
		
		Integer cantidad = diagonal.repetitions(adn);
		
		System.out.println(cantidad);
		
//		list.parallelStream().forEach(row -> System.out.println(row.repetitions(adn)));
	}
	
//	@Test
//	public void stats() {
//		when(repository.count()).thenReturn(100L);
//        // mutant dna count
//        when(repository.countByIsMutantTrue()).thenReturn(40L);
//        
//        StatsDTO stats = service.getStats();
//        
//        
//        System.out.println(stats.toString());
//        
//        
//	}
}
