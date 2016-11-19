package com.bytecode.logic;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;

public class SceltaTest {

	@Test
	public void testRisultatoContro_WIN() {
		
		Scelta[] case1 = {Scelta.CARTA,Scelta.SASSO};
		Scelta[] case2 = {Scelta.SASSO,Scelta.FORBICE};
		Scelta[] case3 = {Scelta.FORBICE,Scelta.CARTA};
		Risultato result1 = case1[0].risultatoContro(case1[1]);
		Risultato result2 = case2[0].risultatoContro(case2[1]);
		Risultato result3 = case3[0].risultatoContro(case3[1]);
		assertEquals(result1,Risultato.WINNER);
		assertEquals(result2,Risultato.WINNER);
		assertEquals(result3,Risultato.WINNER);
	}
	
	@Test
	public void testRisultatoContro_LOSE() {
		
		Scelta[] case1 = {Scelta.SASSO,Scelta.CARTA};
		Scelta[] case2 = {Scelta.FORBICE,Scelta.SASSO};
		Scelta[] case3 = {Scelta.CARTA,Scelta.FORBICE};
		Risultato result1 = case1[0].risultatoContro(case1[1]);
		Risultato result2 = case2[0].risultatoContro(case2[1]);
		Risultato result3 = case3[0].risultatoContro(case3[1]);
		assertEquals(result1,Risultato.LOSER);
		assertEquals(result2,Risultato.LOSER);
		assertEquals(result3,Risultato.LOSER);
	}
	
	@Test
	public void testRisultatoContro_DRAW() {
		
		Scelta[] case1 = {Scelta.SASSO,Scelta.SASSO};
		Scelta[] case2 = {Scelta.CARTA,Scelta.CARTA};
		Scelta[] case3 = {Scelta.FORBICE,Scelta.FORBICE};
		Risultato result1 = case1[0].risultatoContro(case1[1]);
		Risultato result2 = case2[0].risultatoContro(case2[1]);
		Risultato result3 = case3[0].risultatoContro(case3[1]);
		assertEquals(result1,Risultato.DRAW);
		assertEquals(result2,Risultato.DRAW);
		assertEquals(result3,Risultato.DRAW);
	}

	@Test
	public void testParseInput() {
		
		String[] stringhe = {"sasso","Carta","ForBICE"};
		Scelta result1 = Scelta.parseInput(stringhe[0]);
		Scelta result2 = Scelta.parseInput(stringhe[1]);
		Scelta result3 = Scelta.parseInput(stringhe[2]);
		assertEquals(result1,Scelta.SASSO);
		assertEquals(result2,Scelta.CARTA);
		assertEquals(result3,Scelta.FORBICE);
		
	}

	@Test
	public void testGetSceltaCasuale() {
		
		Random random = new Random();
		Scelta sceltaCasuale = Scelta.getSceltaCasuale(random);
		boolean result = false;
		Scelta[] sceltePossibili = Scelta.values();
		for(Scelta s: sceltePossibili)
			if(sceltaCasuale.equals(s))
				result = true;
		assertTrue(result);
		
	}

	@Test
	public void testToString() {
		
		assertEquals(Scelta.SASSO.toString(),"sasso");
		
	}
	
	@Test(expected=NullPointerException.class)
	public void testRisultatoControNull() {
		
		Scelta scelta = Scelta.CARTA;
		scelta.risultatoContro(null);
		
	}
	
	@Test(expected=NullPointerException.class)
	public void testParseInputNull() {
		
		Scelta.parseInput(null);
		
	}
	
	@Test(expected=NullPointerException.class)
	public void testGetSceltaCasualeNull() {
		
		Scelta.getSceltaCasuale(null);
		
	}

}
