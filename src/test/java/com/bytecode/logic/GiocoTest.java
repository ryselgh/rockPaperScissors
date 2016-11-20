package com.bytecode.logic;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;

public class GiocoTest {
	
	private static final String EOL = System.getProperty("line.separator");
	private final ByteArrayOutputStream output = new ByteArrayOutputStream();
	private Gioco gioco;
	
	@Before
	public void setUpOutputStream() {
	    System.setOut(new PrintStream(output));
	}

	@Test
	public void testIstanzaGioco() {
		
	    gioco = new Gioco(new ByteArrayInputStream(("1"+EOL+"sasso"+EOL+"sasso"+EOL+"sasso"+EOL+"no"+EOL).getBytes()));
		assertNotNull(gioco);
		
	}
	
	@Test(expected=NullPointerException.class)
	public void testGiocoArgomentoInvalido(){
		gioco = new Gioco(null);
	}

	@Test
	public void testEsitoGioco_IA() {
		
	    gioco = new Gioco(new ByteArrayInputStream(("1"+EOL+"sasso"+EOL+"carta"+EOL+"forbice"+EOL+"no"+EOL).getBytes()));
		String result = output.toString();
	    assertTrue(result.contains("La partita termina in parità!") ||
	    			result.contains("Vince la partita il giocatore 1!") ||
	    			result.contains("Vince la partita la CPU!"));
	    assertTrue(!result.contains("Vince la partita il giocatore 2!"));
		
	}
	
	@Test
	public void testEsitoGioco_DueGiocatori() {
		
	    gioco = new Gioco(new ByteArrayInputStream(("2"+EOL+"forbice"+EOL+"sasso"+EOL+"carta"+EOL+"forbice"+EOL+"sasso"+EOL+"carta"+EOL+"no"+EOL).getBytes()));
		String result = output.toString();
	    assertTrue(result.contains("La partita termina in parità!") ||
	    			result.contains("Vince la partita il giocatore 1!") ||
	    			result.contains("Vince la partita il giocatore 2!"));
	    assertTrue(!result.contains("Vince la partita la CPU!"));
		
	}

	@Test
	public void testInputErrato() {
		gioco = new Gioco(new ByteArrayInputStream(("20"+EOL+"1"+EOL+"pistola"+EOL+"sasso"+EOL+"forbice"+EOL+"carta"+EOL+"ni"+EOL+"no"+EOL).getBytes()));
		String result = output.toString();
		assertTrue(result.contains("Risposta non valida, riprova."));
	}

}
