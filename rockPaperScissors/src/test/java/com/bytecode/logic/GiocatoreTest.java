package com.bytecode.logic;

import static org.junit.Assert.*;

import org.junit.Test;

public class GiocatoreTest {

	@Test
	public void testGiocatore() {
		Giocatore giocatore = new Giocatore();
		int result = giocatore.getPunteggio();
		assertEquals(result,0);
	}

	@Test
	public void testAddPunto() {
		Giocatore giocatore = new Giocatore();
		int punti = 3;
		for(int i=0; i<punti; i++)
			giocatore.addPunto();
		int result = giocatore.getPunteggio();
		assertEquals(result,punti);
	}

	@Test
	public void testGetPunteggio() {
		Giocatore giocatore = new Giocatore();
		int punti = 3;
		for(int i=0; i<punti; i++)
			giocatore.addPunto();
		int result = giocatore.getPunteggio();
		assertEquals(result,punti);
	}

}
