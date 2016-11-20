package com.bytecode.logic;

import static org.junit.Assert.*;

import org.junit.Test;

public class RisultatoTest {

	@Test
	public void testVinceSe() {
		
		Risultato result1 = Risultato.vinceSe(true);
		Risultato result2 = Risultato.vinceSe(false);
		assertEquals(result1,Risultato.WINNER);
		assertEquals(result2,Risultato.LOSER);
		
	}
	
	@Test
	public void testToString() {
		
		String result1 = Risultato.WINNER.toString();
		String result2 = Risultato.LOSER.toString();
		String result3 = Risultato.DRAW.toString();
		assertEquals(result1,"Hai vinto!");
		assertEquals(result2,"Hai perso!");
		assertEquals(result3,"Parità!");
		
	}

}
